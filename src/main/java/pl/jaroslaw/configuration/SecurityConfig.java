package pl.jaroslaw.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/**").permitAll()
//                                .requestMatchers("/mastermind", "/mastermind/login", "/mastermind/registration").permitAll()
//                                .requestMatchers("/mastermind/game/**").hasAnyRole("USER", "ADMIN", "SUPER_ADMIN")
//                                .requestMatchers("/mastermind/admin/**").hasAnyRole("ADMIN", "SUPER_ADMIN")
                                .requestMatchers("/images/**", "/css/**", "/js/**", "/WEB-INF/views/**").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/mastermind/login")
                        .failureHandler(customAuthenticationFailureHandler())
                        .defaultSuccessUrl("/mastermind/validate", true)
                )
                .logout(logout -> logout
                        .logoutUrl("/mastermind/logout")
                        .logoutSuccessUrl("/mastermind/player")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                        .logoutRequestMatcher(new AntPathRequestMatcher("/mastermind/logout", "GET"))
                )
                .securityContext(context -> context
                        .requireExplicitSave(false)
                );

        return http.build();
    }

    @Bean
    public AuthenticationFailureHandler customAuthenticationFailureHandler() {
        return (request, response, exception) -> {
            response.sendRedirect("/mastermind/login?error=true");
        };
    }

}
