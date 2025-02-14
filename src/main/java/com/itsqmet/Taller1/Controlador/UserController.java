package com.itsqmet.Taller1.Controlador;

import com.itsqmet.Taller1.Entidad.Usuario;
import com.itsqmet.Taller1.Rol.Rol;
import com.itsqmet.Taller1.Service.UsuarioService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class UserController {
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/RegistroUser")
    public String mostrarFormulario(Model model) {
        model.addAttribute("cuenta", new Usuario());
        return "Usuario/registroEmpleado";  // Asegúrate de que el archivo HTML está en templates/Pages/
    }

    @PostMapping("/guardarUsuario")
    public String registrarUsuario(@RequestParam(required = false) Long id,
                                   @RequestParam String username,
                                   @RequestParam String password,
                                   @RequestParam("id") Long clienteID,
                                   @RequestParam(required = false) Rol rol) throws Exception {
        usuarioService.registrarUsuario(id, username, password, clienteID, rol);
        return "redirect:/login";

    }


    @GetMapping("/login")
    public String mostrarLogin(Model model) {
        model.addAttribute("login", new Usuario());
        return "pages/login";
    }

    /*@PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        RedirectAttributes redirectAttributes) {

        // Intenta autenticar al usuario
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(token);

        // Si la autenticación es exitosa, se guarda en el contexto de seguridad
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Obtén el usuario autenticado
        Usuario usuario = usuarioService.obtenerUsuarioPorUsername(username);

        if (usuario != null) {
            Long clienteID = usuario.getClienteID();
            // Redirige a la página con el clienteID
            return "redirect:/DatosCliente?id=" + clienteID;
        } else {
            redirectAttributes.addFlashAttribute("error", "Usuario no encontrado.");
            return "redirect:/login";  // Redirige a login si no existe el usuario
        }
    }*/



}

