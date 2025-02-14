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
                        .requestMatchers("/AgregarAsesores").hasAuthority("ROLE_ADMINISTRADOR")
                        .requestMatchers("/DatosCliente").authenticated()  // Esta regla debe ir primero
                        .requestMatchers("/registroCuenta/**", "/AbrirCuenta/**", "/ConfirmarCuenta/**").permitAll()
                        .anyRequest().permitAll()  // Permite todo lo demás
                )
                .formLogin(form -> form
                        .loginPage("/login").permitAll()
                        .successHandler(successHandler)  // Usa el CustomSuccessHandler para redirigir después del login
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
