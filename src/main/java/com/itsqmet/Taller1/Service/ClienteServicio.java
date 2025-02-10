package com.itsqmet.Taller1.Service;

import com.itsqmet.Taller1.Entidad.InformacionClienteDTO;
import com.itsqmet.Taller1.Repositorio.ClienteRepository;
import com.itsqmet.Taller1.Repositorio.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServicio {
    @Autowired
    ClienteRepository clienteRepository;

    public InformacionClienteDTO buscarCuentaReciente(Long id) {
        List<Object[]> datos = clienteRepository.buscarCuentaReciente(id);

        if (!datos.isEmpty()) {
            return extraerInformacion(datos.get(0));
        }
        return null;
    }


    //Metodo para extraer la data
    private InformacionClienteDTO extraerInformacion(Object[] registros) {
        InformacionClienteDTO informacion = new InformacionClienteDTO();

        if (registros.length > 0) informacion.setNombreCliente((String) registros[0]);          // cl.nombre
        if (registros.length > 1) informacion.setCedulaCliente((String) registros[1]);          // cl.cedula
        if (registros.length > 2) informacion.setNumeroCuenta((String) registros[2]);           // cu.numero_cuenta
        if (registros.length > 3) informacion.setSaldo((BigDecimal) registros[3]);              // cu.saldo
        if (registros.length > 4) informacion.setTipoCuenta((String) registros[4]);             // cu.tipo_cuenta
        if (registros.length > 5 && registros[5] instanceof java.sql.Date) {
            java.sql.Date fechaCaducidad = (java.sql.Date) registros[5];
            informacion.setFechaCaducidad(fechaCaducidad.toLocalDate());
        }
        if (registros.length>6) informacion.setClienteId((Long) registros[6]);
        return informacion;
    }

}
