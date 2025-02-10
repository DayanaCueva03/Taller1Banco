package com.itsqmet.Taller1.Service;

import com.itsqmet.Taller1.Entidad.InformacionClienteDTO;
import com.itsqmet.Taller1.Repositorio.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class Cliente {
    @Autowired
    ClienteRepository clienteRepository;


    public List<InformacionClienteDTO> buscarCuentas(Long id) {
        List<Object[]> datos = clienteRepository.buscarCuentas(id);
        List<InformacionClienteDTO> registros = new ArrayList<>();

        for (Object[] registro : datos) {
            InformacionClienteDTO informacion = extraerInformacion(registro);
            registros.add(informacion);
        }
        return registros;
    }

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
        informacion.setCedulaCliente((String) registros[1]);
        informacion.setNombreCliente((String) registros[0]);
        informacion.setNumeroCuenta((String) registros[2]);
        informacion.setSaldo((BigDecimal) registros[3]);
        informacion.setTipoCuenta((String) registros[4]);
        return informacion;
    }
}
