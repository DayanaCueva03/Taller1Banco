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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
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
                                    @ModelAttribute Transacciones transacciones, RedirectAttributes redirectAttributes) {
        Cuenta cuentaOrigen = cuentaServicio.buscarPorId(cuentaOrigenId);
        if (cuentaOrigen == null) {
            throw new IllegalArgumentException("La cuenta de origen no existe.");
        }

        if (cuentaOrigen.getSaldo().compareTo(BigDecimal.ZERO) <= 0 ||
                cuentaOrigen.getSaldo().compareTo(transacciones.getMonto()) < 0) {
            // Pasar el mensaje de error al modelo para mostrarlo en el modal
            redirectAttributes.addFlashAttribute("mensajeError", "Saldo insuficiente");
            // Redirigir al mismo formulario, pasando el ID del cliente
            return "redirect:/DatosCliente?id=" + id;
        }

        // Restar el monto del saldo de la cuenta
        cuentaOrigen.setSaldo(cuentaOrigen.getSaldo().subtract(transacciones.getMonto()));
        cuentaServicio.guardarCuenta(cuentaOrigen);


        transacciones.setCuenta(cuentaOrigen);
        transacciones.setCuentaOrigen(cuentaOrigenNumero);
        if (transacciones.getFechaMovimiento() == null) {
            transacciones.setFechaMovimiento(LocalDate.now());
        }

        transacciones.setId(null);
        cliente.guardarTransaccion(transacciones);

        return "redirect:/DatosCliente?id=" + id;
    }

}
