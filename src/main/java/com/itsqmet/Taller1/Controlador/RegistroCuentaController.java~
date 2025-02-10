package com.itsqmet.Taller1.Controlador;

import com.itsqmet.Taller1.Entidad.Cliente;
import com.itsqmet.Taller1.Entidad.Cuenta;
import com.itsqmet.Taller1.Service.CuentaServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class RegistroCuentaController {
    @Autowired
    CuentaServicio cuentaServicio;
    //Registro de datos personales del cliente
    @GetMapping("/registroCuenta")
    public String vista(Model model){
        model.addAttribute("cliente", new Cliente());
        return "Pages/registroCuenta";
        }
    @PostMapping("/RegistroCuenta")
    public String registroEmpleado(Cliente cliente,RedirectAttributes redirectAttributes){
        cuentaServicio.guardarCliente(cliente);
        //enviar Id a la  siguiente vista
          Long clienteId=cliente.getId();
        redirectAttributes.addFlashAttribute("clienteId", clienteId);

        System.out.println("Registro exitoso"+clienteId);
        return "redirect:/AbrirCuenta";

    }

    //Registro de cuentas

    @GetMapping("/AbrirCuenta")
    public String AbirCuenta(@ModelAttribute("clienteId")Cliente clienteId,Model model){
        Cuenta cuenta = new Cuenta();

        model.addAttribute("cuenta", cuenta);
        cuenta.setCliente(clienteId);

        return "Pages/abrirCuenta";
    }

    @PostMapping("/guardarCuenta")
    public String guardarCuenta(@ModelAttribute("cuenta") Cuenta cuenta,
                                @RequestParam("clienteId") Long clienteId, Model model) {
        // Asignar el cliente manualmente
        Cliente cliente = new Cliente();
        cliente.setId(clienteId);  // Establecer el ID del cliente
        cuenta.setCliente(cliente);
        cuentaServicio.guardarCuenta(cuenta);
        model.addAttribute("cuenta", cuenta);
       return "Pages/confirmarCuenta";
    }
    @GetMapping("/generarValoresCuenta")
    public String generarValoresCuenta(@RequestParam("tipoCuenta") String tipoCuenta, Model model) {
        Cuenta cuenta = new Cuenta();
        cuenta.setTipoCuenta(tipoCuenta);

        // Aseguramos que cliente no sea nulo
        Cliente cliente = new Cliente();
        cuenta.setCliente(cliente);

        // Generar el número de cuenta automáticamente
        cuenta = cuentaServicio.generarNumeroCuenta(cuenta);

        model.addAttribute("cuenta", cuenta);

        return "Pages/abrirCuenta";
    }


    //Tarjeta de presentacion

//    @GetMapping("/confirmacionCuenta")
//    public String mostrarConfirmacionCuenta(@RequestParam("clienteId") Long clienteId, Model model) {
//        // Obtener la cuenta usando el clienteId
//        List<Cuenta> cuenta = cuentaServicio.obtenerCuentaPorClienteId(clienteId);
//
//        // Asegúrate de que la cuenta esté completamente poblada
//        model.addAttribute("cuenta", cuenta);
//
//        return "Pages/confirmarCuenta";  // La vista que contiene la tarjeta de presentación
//    }




}
