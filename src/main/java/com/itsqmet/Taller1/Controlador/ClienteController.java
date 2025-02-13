package com.itsqmet.Taller1.Controlador;

import com.itsqmet.Taller1.Entidad.Cuenta;
import com.itsqmet.Taller1.Entidad.InformacionClienteDTO;
import com.itsqmet.Taller1.Entidad.Transacciones;
import com.itsqmet.Taller1.Service.ClienteServicio;
import com.itsqmet.Taller1.Service.CuentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
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
        model.addAttribute("cuentas", informacion2);
        model.addAttribute("trasaccion", new Transacciones());
        // Pasamos solo un objeto al modelo
        return "Pages/DatosCliente";
    }
    @PostMapping("/GuardarTransaccion")
    public String enviarTransaccion(@RequestParam("id") Long id,
                                    @RequestParam("cuentaOrigenId") Long cuentaOrigenId,
                                    @RequestParam("cuentaOrigenNumero") String cuentaOrigenNumero,
                                    @ModelAttribute Transacciones transacciones) {
        Cuenta cuentaOrigen = cuentaServicio.buscarPorId(cuentaOrigenId);
        if (cuentaOrigen == null) {
            throw new IllegalArgumentException("La cuenta de origen no existe.");
        }

        transacciones.setCuenta(cuentaOrigen);
        transacciones.setCuentaOrigen(cuentaOrigenNumero);  // Guardar el número de cuenta enviado desde el formulario

        if (transacciones.getFechaMovimiento() == null) {
            transacciones.setFechaMovimiento(LocalDate.now());
        }

        transacciones.setId(null);
        cliente.guardarTransaccion(transacciones);

        return "redirect:/DatosCliente?id=" + id;
    }

}
