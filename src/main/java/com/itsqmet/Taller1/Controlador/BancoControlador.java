package com.itsqmet.Taller1.Controlador;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BancoControlador {

    @GetMapping("/index")
    public String vista(){
        return "/index";
    }
}
