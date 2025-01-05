package ForumHub.Api.Usuario;
import ForumHub.Api.Usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "usuarios")
@Entity(name = "Usuario") //U
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login; // era usuario
    private String senha;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Usando "ROLE_USER" de acordo com a convenção do Spring Security
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        // Retorne 'true' para indicar que a conta não expirou
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Retorne 'true' para indicar que a conta não está bloqueada
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Retorne 'true' para indicar que as credenciais não estão expiradas
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Retorne 'true' para indicar que a conta está habilitada
        return true;
    }
}
