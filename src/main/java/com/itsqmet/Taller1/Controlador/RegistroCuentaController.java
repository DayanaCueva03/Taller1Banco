package com.itsqmet.Taller1.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistroCuentaController {
    @GetMapping("/registroCuenta")
    public String vista(){
    return "Pages/registroCuenta";
        }
}
