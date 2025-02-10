package com.itsqmet.Taller1.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AtencionClienteController {
    @GetMapping("/index")
    public String vista() {
        return "/index";
    }

    // Mapea la URL "/atencionCliente" y retorna la vista correspondiente
    @GetMapping("/informacionCliente")
    public String mostrarFormulario() {
        return "Pages/informacionCliente";  // Nombre de la vista HTML sin espacio adicional
    }

    // Mapea la URL "/atencionCliente" para procesar el formulario y mostrar el mensaje de confirmación
    /*@PostMapping("/")
    public String procesarMensaje(
            @RequestParam String nombre,
            @RequestParam String email,
            @RequestParam String mensaje,
            Model model) {
        // Retornar la vista de confirmación
        return "pages/informacionCliente";  // Página de confirmación correctamente mapeada
    }*/
}
