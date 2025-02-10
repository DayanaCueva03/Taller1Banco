package com.itsqmet.Taller1.Controlador;

import com.itsqmet.Taller1.Entidad.InformacionClienteDTO;
import com.itsqmet.Taller1.Service.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ClienteController {
    @Autowired
    Cliente cliente;

    //Traer informacion del cliente

//    @GetMapping("/DatosCliente")
//    public String traerInformacion(@RequestParam("id") Long id, Model model) {
//        List<InformacionClienteDTO> informacion = cliente.buscarCuentaReciente(id);
//        model.addAttribute("datos", informacion); // Pasa la lista de información al modelo
//        return "Pages/DatosCliente"; // Retorna la vista
//    }

    @GetMapping("/DatosCliente")
    public String traerInformacion(@RequestParam("id") Long id, Model model) {
        InformacionClienteDTO informacion = cliente.buscarCuentaReciente(id);
        model.addAttribute("datos", informacion); // Pasamos solo un objeto al modelo
        return "Pages/DatosCliente";
    }

}
