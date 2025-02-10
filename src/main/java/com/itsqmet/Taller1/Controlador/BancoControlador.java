/*package com.itsqmet.Taller1.Controlador;

import com.itsqmet.Taller1.Entidad.Cuenta;
import com.itsqmet.Taller1.Service.BancoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BancoControlador {

    @Autowired
    private BancoServicio bancoServicio;

    @GetMapping("/index")
    public String vista() {
        return "/index";
    }

    @PostMapping("/guardar")
    public String guardarBanco(Cuenta cuenta){
        bancoServicio.insertarEmpleado(cuenta);
        return "redirect:/empleados";
    }

    @GetMapping("/empleados")
    public String listaEmpleado(@RequestParam(name = "buscarEmpleado", required = false, defaultValue = "") String buscarEmpleado, Model model) {
        List<Cuenta> empleado = bancoServicio.buscarPorNombre(buscarEmpleado);
        model.addAttribute("buscarEmpleado", buscarEmpleado);
        model.addAttribute("banco", empleado);
        return "/pages/listaEmpleados";
    }

    @GetMapping("/formulario" )
    public String mostrarFormulario(Model model) {
        model.addAttribute("empleados", new Cuenta());
        return "pages/formulario";
    }
}*/
