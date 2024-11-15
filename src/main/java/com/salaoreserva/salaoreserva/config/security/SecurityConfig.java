package com.salaoreserva.salaoreserva.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.salaoreserva.salaoreserva.utils.constants.Routes;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers(
                                        Routes.Users.FRONTPAGE_USER,
                                        Routes.Users.SALAO_BUSCA_PDIA,
                                        Routes.Users.SALAO_DIAS_DISPONIVEIS,
                                        Routes.Users.REGISTER,
                                        Routes.Users.RESERVAS,
                                        Routes.Users.LOGIN,
                                        Routes.Users.REGISTER,
                                        Routes.Resource.FONTS,
                                        Routes.Resource.IMAGES,
                                        Routes.Resource.CSS,
                                        Routes.Resource.JS).permitAll()
                                .requestMatchers(Routes.Users.ADMIN + "/**").hasRole("ADMIN")
                                .requestMatchers(Routes.Users.USERS + "/**").hasRole("USER")
                                .anyRequest().authenticated()
                )
                .formLogin(form -> form
                                .loginPage(Routes.Users.LOGIN)
                                .failureUrl(Routes.Erro.LOGIN_ERROR)
                                .successHandler((request, response, authentication) -> {
                                    String role = authentication.getAuthorities().stream()
                                            .findFirst().get().getAuthority();
                                    if (role.equals("ROLE_ADMIN")) {
                                        response.sendRedirect("/salao-reserva" + Routes.Users.FRONTPAGE_ADMIN);
                                    } else if (role.equals("ROLE_USER")) {
                                        response.sendRedirect("/salao-reserva" + Routes.Users.FRONTPAGE_USER);
                                    } else {
                                        response.sendRedirect("/salao-reserva" + Routes.Erro.LOGIN_ERROR);
                                    }
                                })
                                .permitAll()
                )
                .exceptionHandling(exceptionHandling -> exceptionHandling
                                .accessDeniedPage("/error/403")
                )
                .logout(logout -> logout
                                .logoutUrl("/users/logout")
                                .logoutSuccessUrl("/login?logout")
                                .permitAll()
                );

        return http.build();
    }
}
