package com.itsqmet.Taller1.Controlador;

import com.itsqmet.Taller1.Entidad.Cliente;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class RegistroCuentaController {
    @GetMapping("/registroCuenta")
    public String vista(    Model model){
        model.addAttribute("cliente", new Cliente());
    return "Pages/registroCuenta";
        }


    @PostMapping("/RegistroCuenta")
    public String registroEmpleado(@Valid @ModelAttribute("cliente") Cliente cliente,
                                   BindingResult bindingResult , Model model){
        if(bindingResult.hasErrors()){


            model.addAttribute("errores", bindingResult.getAllErrors());

            return "Pages/registroCuenta";
        }else{

            return "Pages/registroCuenta";
        }


    }
}
