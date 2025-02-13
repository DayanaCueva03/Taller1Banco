/*package com.itsqmet.Taller1.Controlador;

import com.itsqmet.Taller1.Entidad.Usuario;
import com.itsqmet.Taller1.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class UserController {
    @Autowired
    UsuarioService usuarioService;
    @GetMapping("/RegistroUser")
    public String mostrarFormulario() {
        return "Usuario/registroEmpleado";  // Asegúrate de que el archivo HTML está en templates/Pages/
    }

    @PostMapping("/guardarUsuario")

    public String registrarUsuario(@RequestParam("clienteId") int clienteId,
                                   @RequestParam("username") String username,
                                   @RequestParam("password") String password) {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setClienteID(clienteId);
        nuevoUsuario.setUsername(username);
        nuevoUsuario.setPassword(password);
        nuevoUsuario.setRol("cliente");  // El rol por defecto será 'cliente'

        usuarioService.guardarUsuario(nuevoUsuario);  // Este es tu servicio para guardar el usuario en la base de datos

        return "redirect:/RegistroUser";  // Redirige a la página de login tras el registro exitoso
    }


}*/