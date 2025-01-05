package ForumHub.Api.Controller;

import ForumHub.Api.Usuario.DadosAutenticacao;
import ForumHub.Api.Usuario.Usuario;
import ForumHub.Api.security.DadostokenJWT;
import ForumHub.Api.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/login")
public class AutenticacaoController    {



    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;



    @PostMapping
    public ResponseEntity<?> fazerLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var autenticationtoken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(autenticationtoken);

        // Agora usamos o tokenService para gerar o token
        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DadostokenJWT(tokenJWT));
    }
}









//@PostMapping
//    public ResponseEntity fazerLogin (@RequestBody @Valid DadosAutenticacao dados){
//       var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
//        var authentication = manager.authenticate(token);
//           // return ResponseEntity.ok().build()     //   --- Antes não gerava o token
//            return ResponseEntity.ok(TokenService.gerarToken ((Usuario) authentication.getPrincipal()));
//
//    }
//}
