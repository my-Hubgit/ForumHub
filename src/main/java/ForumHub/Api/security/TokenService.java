package ForumHub.Api.security;


import ForumHub.Api.Usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Service
public class TokenService {

@Value("${api.security.token.secret}")
    private String secret;
        public String gerarToken(Usuario usuario){
            try {
                var algoritimo = Algorithm.HMAC256(secret);
                return JWT.create()
                        .withIssuer("ForumHub.Api")
                        .withSubject(usuario.getUsername()) // era getUsername
                        .withExpiresAt(dataExpiracao())
                        .sign(algoritimo);
            } catch (JWTCreationException exception){
                // Invalid Signing configuration / Couldn't convert Claims.
            throw new RuntimeException("Erro ao gerar o Token", exception);
            }



    }


    public String getSubject (String tokenJWT){
        try {
            var algoritimo = Algorithm.HMAC256(secret);
            System.out.println("test do Token");
            return JWT.require(algoritimo)
                    // specify any specific claim validations
                    .withIssuer("ForumHub.Api")
                    // reusable verifier instance
                    .build()
                    .verify(tokenJWT)
                    .getSubject();



        } catch (JWTVerificationException exception){
            // Invalid signature/claims
            throw new RuntimeException("TokenJWT invalido.");
        }


    }





    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}

