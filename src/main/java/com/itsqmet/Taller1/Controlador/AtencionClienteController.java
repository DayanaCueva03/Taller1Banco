package com.itsqmet.Taller1.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AtencionClienteController {

    @GetMapping("/")
    public String redirectToIndex() {
        return "redirect:/index";  // Redirige automáticamente a /index
    }

    @GetMapping("/index")
    public String showIndex() {
        return "index";  // Devuelve la vista index.html
    }

}


