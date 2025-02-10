package com.itsqmet.Taller1.Controlador;

import com.itsqmet.Taller1.Entidad.InformacionClienteDTO;
import com.itsqmet.Taller1.Service.ClienteServicio;
import com.itsqmet.Taller1.Service.CuentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ClienteController {
    @Autowired
    ClienteServicio cliente;
    @Autowired
    CuentaServicio cuentaServicio;

    //Traer informacion del cliente
    @GetMapping("/DatosCliente")
    public String traerInformacion(@RequestParam("id") Long id, Model model) {
        InformacionClienteDTO informacion = cliente.buscarCuentaReciente(id);
      List<InformacionClienteDTO> informacion2 = cuentaServicio.buscarListaCuentas(id);
        model.addAttribute("datos", informacion);
        model.addAttribute("cuentas", informacion2);// Pasamos solo un objeto al modelo
        return "Pages/DatosCliente";
    }

}
