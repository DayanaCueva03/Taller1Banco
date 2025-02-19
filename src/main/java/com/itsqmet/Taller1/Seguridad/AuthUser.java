package com.itsqmet.Taller1.Seguridad;

import com.itsqmet.Taller1.Service.UsuarioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AuthUser {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, SuccesLogin successHandler) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // Rutas solo para administrador
                        .requestMatchers("/AgregarAsesores").hasAuthority("ROLE_ADMINISTRADOR")

                        // Rutas disponibles para CLIENTES y ADMINISTRADORES
                        .requestMatchers("/DatosCliente").hasAnyAuthority("ROLE_CLIENTE", "ROLE_ADMINISTRADOR")

                        // Rutas públicas (disponibles sin necesidad de autenticación)
                        .requestMatchers("/**","/index/**", "/login", "/registroCuenta/**", "/AbrirCuenta/**", "/ConfirmarCuenta/**").permitAll()

                        // Bloquea cualquier otra ruta no definida
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login").permitAll()
                        .successHandler(successHandler)
                        .failureUrl("/login?error=true")
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/index").permitAll()
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Método para configurar el AuthenticationManager sin usar 'and()'
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, UsuarioService usuarioService) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(usuarioService)  // Usamos el UsuarioService
                .passwordEncoder(passwordEncoder());  // Usamos el PasswordEncoder
        return authenticationManagerBuilder.build();
    }

}
