package com.itsqmet.Taller1.Service;

import com.itsqmet.Taller1.Entidad.Cliente;
import com.itsqmet.Taller1.Entidad.Cuenta;
import com.itsqmet.Taller1.Repositorio.ClienteRepository;
import com.itsqmet.Taller1.Repositorio.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
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

    public List<Cuenta> obtenerCuentaPorClienteId(Long clienteId) {
        // Suponiendo que existe un campo 'cliente' en la entidad Cuenta que es una relación con Cliente
        return cuentaRepository.findByClienteId(clienteId);
    }

    //Metodo Para generear numeros de cuenta de manera automatica

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



}
