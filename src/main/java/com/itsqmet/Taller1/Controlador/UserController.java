package com.itsqmet.Taller1.Controlador;

import com.itsqmet.Taller1.Entidad.Usuario;
import com.itsqmet.Taller1.Rol.Rol;
import com.itsqmet.Taller1.Service.UsuarioService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class UserController {
    @Autowired
    UsuarioService usuarioService;

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
        return "redirect:/RegistroUser";

    }
}

