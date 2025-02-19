package com.itsqmet.Taller1.Service;

import com.itsqmet.Taller1.Entidad.Cliente;
import com.itsqmet.Taller1.Entidad.Cuenta;
import com.itsqmet.Taller1.Entidad.InformacionClienteDTO;
import com.itsqmet.Taller1.Repositorio.ClienteRepository;
import com.itsqmet.Taller1.Repositorio.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CuentaServicio {
    @Autowired
    CuentaRepository cuentaRepository;
    @Autowired
    ClienteRepository clienteRepository;
    //Datos del cliente
    public void  guardarCliente(Cliente cliente){
        clienteRepository.save(cliente);
    }
    public Optional<Cliente> buscarClienteporId(Long id){
        return clienteRepository.findById(id);
    }

    //Datos de la cuenta
    public void guardarCuenta(Cuenta cuenta){
        cuentaRepository.save(cuenta);
    }

    public String generarNumeroCuentaAleatoria(){
        return String.format("%06d",(int)(Math.random()*1000000));
    }


    public Cuenta generarNumeroCuenta(Cuenta cuenta){
        if (cuenta.getTipoCuenta() != null) {
            String tipoCuenta = cuenta.getTipoCuenta();
            String numeroCuenta = tipoCuenta.equals("Ahorro") ? "17" + generarNumeroCuentaAleatoria() : "20" + generarNumeroCuentaAleatoria();
            cuenta.setNumeroCuenta(numeroCuenta);
            cuenta.setFechaApertura(LocalDate.now());
            cuenta.setFechaCaducidad(LocalDate.now().plusYears(2));
            cuenta.setSaldo(BigDecimal.valueOf(0.0));
            cuenta.setEstado("Activa");
        }
        return cuenta;
    }

    public List<InformacionClienteDTO> buscarListaCuentas(Long id) {
        List<Object[]> datos = cuentaRepository.buscarCuentas(id);
        List<InformacionClienteDTO> registros = new ArrayList<>();

        for (Object[] registro : datos) {
            InformacionClienteDTO informacion = extraerInformacion(registro);
            registros.add(informacion);
        }
        return registros;
    }

//sirve para las transacciones para buscar listas con id
    private InformacionClienteDTO extraerInformacion(Object[] registros) {
        InformacionClienteDTO informacion = new InformacionClienteDTO();
        if (registros.length > 0) informacion.setNumeroCuenta((String) registros[0]);
        if (registros.length > 1) informacion.setCuentaId((Long) registros[1]);
        return informacion;
    }
    public Cuenta buscarPorId(Long id) {
        return cuentaRepository.findById(id).orElse(null);
    }

}
