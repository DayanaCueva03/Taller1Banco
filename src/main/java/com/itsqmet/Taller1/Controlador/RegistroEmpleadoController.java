package com.itsqmet.Taller1.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registroEmpleado")
public class RegistroEmpleadoController {

    @GetMapping
    public String mostrarFormulario() {
        return "Pages/registroEmpleado";  // Asegúrate de que el archivo HTML está en templates/Pages/
    }
}