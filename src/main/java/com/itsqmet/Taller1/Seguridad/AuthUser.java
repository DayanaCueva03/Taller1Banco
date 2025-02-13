package com.itsqmet.Taller1.Seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AuthUser {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**", "/index", "/registroCuenta/**", "/AbrirCuenta/**", "/ConfirmarCuenta/**").permitAll() // Permitir acceso a estas rutas
                        .anyRequest().authenticated()  // Requiere autenticación para el resto
                )
                .formLogin(form -> form
                        .loginPage("/login").permitAll()  // Página de login personalizada
                        .defaultSuccessUrl("/index", true)  // Redirige a /index después de iniciar sesión correctamente
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")  // URL para cerrar sesión
                        .logoutSuccessUrl("/index").permitAll()  // Redirigir a /index tras cerrar sesión
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
