package com.itsqmet.Taller1.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GestorRolesController {

    @GetMapping("/gestorRoles")
    public String gestorRoles() {
        return "pages/gestorRoles";
    }

    @GetMapping("/crearRoles")
    public String administrarRoles () {
        return "pages/crearRoles";
    }
}
