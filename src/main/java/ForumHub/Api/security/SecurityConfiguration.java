package ForumHub.Api.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static javax.management.Query.and;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private SecurityFilter securityFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "login").permitAll()
                        .requestMatchers( "/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**" ).permitAll()
                        .anyRequest().authenticated() )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build(); }




    //@Bean
    //public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //    return http.csrf().disable()
    //            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    //            .and().authorizeHttpRequests()
    //            .requestMatchers(HttpMethod.POST, "/login").permitAll()
    //            .anyRequest().authenticated()
    //            .and().build();
    //}


    //@Bean
    //public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //    return
    //        http.csrf(csrf -> csrf.disable())
    //        .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
    //        .authorizeHttpRequests(req -> {
    //            req.requestMatchers("/login").permitAll();
    //            req.anyRequest().authenticated();
    //        })
    //    .build();
    //}


@Bean
    public AuthenticationManager authenticationManager (AuthenticationConfiguration configuration) throws Exception{
    return configuration.getAuthenticationManager();
    }


// codifica senha
    @Bean
    public PasswordEncoder passwordEnconder(){
    return new BCryptPasswordEncoder();

    }

}
