package com.itsqmet.Taller1.Controlador;

import com.itsqmet.Taller1.Entidad.Cuenta;
import com.itsqmet.Taller1.Entidad.Transacciones;
import com.itsqmet.Taller1.Service.ClienteServicio;
import com.itsqmet.Taller1.Service.CuentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.time.LocalDate;

@Controller
public class Movimientos {
    @Autowired
    private CuentaServicio cuentaServicio;
    @Autowired
    private ClienteServicio cliente;
///Moviemientos de dinero en la base de datos de Prestabank
    //Transacciones

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


    //Depositar en base a la transaccion
    @PostMapping("/DepositarDinero")
    public String enviarDeposito(@RequestParam("id") Long id,
                                    @RequestParam("IdcuentaOrigen") Long IdcuentaOrigen,
                                    @RequestParam("cuentaOrigenDeposito") String cuentaOrigenDeposito,
                                    @ModelAttribute Transacciones transacciones, RedirectAttributes redirectAttributes) {

        Cuenta cuentaOrigen = cuentaServicio.buscarPorId(IdcuentaOrigen);
        if (cuentaOrigen == null) {
            throw new IllegalArgumentException("La cuenta de origen no existe.");
        }

        if (cuentaOrigen.getSaldo().compareTo(BigDecimal.ZERO) <= 0 ||
                cuentaOrigen.getSaldo().compareTo(transacciones.getMonto()) < 0) {
            // Pasar el mensaje de error al modelo para mostrarlo en el modal
            redirectAttributes.addFlashAttribute("mensajeError", "No se puede depositar,valores menores a 0");
            // Redirigir al mismo formulario, pasando el ID del cliente
            return "redirect:/DatosCliente?id=" + id;
        }

        // Restar el monto del saldo de la cuenta

        cuentaOrigen.setSaldo(cuentaOrigen.getSaldo().add(transacciones.getMonto()));
        cuentaServicio.guardarCuenta(cuentaOrigen);


        transacciones.setCuenta(cuentaOrigen);
        transacciones.setCuentaOrigen(cuentaOrigenDeposito);
        transacciones.setCuentaDestino(cuentaOrigenDeposito);
        if (transacciones.getFechaMovimiento() == null || transacciones.getDescripcion().isEmpty() ) {
            transacciones.setFechaMovimiento(LocalDate.now());
            transacciones.setDescripcion("DEPOSITO");
        }

        transacciones.setId(null);
        cliente.guardarTransaccion(transacciones);
        return "redirect:/DatosCliente?id=" + id;
    }

    //Retirar en base a la transaccion
    @PostMapping("/RetirarDinero")
    public String enviarRetiro(@RequestParam("id") Long id,
                                 @RequestParam("cuentaOrigenIdRetiro") Long cuentaOrigenIdRetiro,
                                 @RequestParam("cuentaOrigeRetiro") String cuentaOrigeRetiro,
                                 @ModelAttribute Transacciones transacciones, RedirectAttributes redirectAttributes) {

        Cuenta cuentaOrigen = cuentaServicio.buscarPorId(cuentaOrigenIdRetiro);
        if (cuentaOrigen == null) {
            throw new IllegalArgumentException("La cuenta de origen no existe.");
        }

        if (cuentaOrigen.getSaldo().compareTo(BigDecimal.ZERO) <= 0 ||
                cuentaOrigen.getSaldo().compareTo(transacciones.getMonto()) < 0) {
            // Pasar el mensaje de error al modelo para mostrarlo en el modal
            redirectAttributes.addFlashAttribute("mensajeError", "No se puede depositar,valores menores a 0");
            // Redirigir al mismo formulario, pasando el ID del cliente
            return "redirect:/DatosCliente?id=" + id;
        }

        // Restar el monto del saldo de la cuenta

        cuentaOrigen.setSaldo(cuentaOrigen.getSaldo().subtract(transacciones.getMonto()));
        cuentaServicio.guardarCuenta(cuentaOrigen);


        transacciones.setCuenta(cuentaOrigen);
        transacciones.setCuentaOrigen(cuentaOrigeRetiro);
        transacciones.setCuentaDestino(cuentaOrigeRetiro);
        if (transacciones.getFechaMovimiento() == null || transacciones.getDescripcion().isEmpty() ) {
            transacciones.setFechaMovimiento(LocalDate.now());
            transacciones.setDescripcion("RETIRO");
        }

        transacciones.setId(null);
        cliente.guardarTransaccion(transacciones);
        return "redirect:/DatosCliente?id=" + id;
    }

    //Pagos

    @PostMapping("/Pagos")
    public String enviarPagos(@RequestParam("id") Long id,
                               @RequestParam("IdcuentaOrigenPagos") Long IdcuentaOrigenPagos,
                               @RequestParam("cuentaOrigenPagos") String cuentaOrigenPagos,
                               @ModelAttribute Transacciones transacciones, RedirectAttributes redirectAttributes) {

        Cuenta cuentaOrigen = cuentaServicio.buscarPorId(IdcuentaOrigenPagos);
        if (cuentaOrigen == null) {
            throw new IllegalArgumentException("La cuenta de origen no existe.");
        }

        if (cuentaOrigen.getSaldo().compareTo(BigDecimal.ZERO) <= 0 ||
                cuentaOrigen.getSaldo().compareTo(transacciones.getMonto()) < 0) {
            // Pasar el mensaje de error al modelo para mostrarlo en el modal
            redirectAttributes.addFlashAttribute("mensajeError", "No se puede depositar,valores menores a 0");
            // Redirigir al mismo formulario, pasando el ID del cliente
            return "redirect:/DatosCliente?id=" + id;
        }

        // Restar el monto del saldo de la cuenta

        cuentaOrigen.setSaldo(cuentaOrigen.getSaldo().subtract(transacciones.getMonto()));
        cuentaServicio.guardarCuenta(cuentaOrigen);


        transacciones.setCuenta(cuentaOrigen);
        transacciones.setCuentaOrigen(cuentaOrigenPagos);
        transacciones.setCuentaDestino(cuentaOrigenPagos);
        if (transacciones.getFechaMovimiento() == null ) {
            transacciones.setFechaMovimiento(LocalDate.now());
        }

        transacciones.setId(null);
        cliente.guardarTransaccion(transacciones);
        return "redirect:/DatosCliente?id=" + id;
    }








}
