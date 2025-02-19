package com.itsqmet.Taller1.Seguridad;
import com.itsqmet.Taller1.Entidad.Usuario;
import com.itsqmet.Taller1.Repositorio.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SuccesLogin implements AuthenticationSuccessHandler {

    @Autowired
    private userRepository usuarioRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        String username = authentication.getName();
        Usuario usuario = usuarioRepository.findByUsername(username);

        if (usuario != null) {
            String rol = usuario.getRol().toString();  // Verifica el rol del usuario
            if ("ADMINISTRADOR".equals(rol)) {
                response.sendRedirect("/AgregarAsesores");
            } else if ("CLIENTE".equals(rol)) {
                String clienteId = String.valueOf(usuario.getClienteID());
                response.sendRedirect("/DatosCliente?id=" + clienteId);
            } else {
                response.sendRedirect("/login?error=true");  // Redirige al login en caso de rol desconocido
            }
        } else {
            response.sendRedirect("/login?error=true");  // Redirige al login si el usuario no se encuentra
        }
    }

}
