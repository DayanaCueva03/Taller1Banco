package com.itsqmet.Taller1.Service;

import com.itsqmet.Taller1.Entidad.Cuenta;
import com.itsqmet.Taller1.Repositorio.BancoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BancoServicio {

    @Autowired
    private BancoRepositorio bancoRepositorio;

    public List<Cuenta> buscarPorNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            return bancoRepositorio.findAll();
        } else {
            return bancoRepositorio.findByNombreContainingIgnoreCase(nombre);
        }
    }


    public void insertarEmpleado(Cuenta cuenta) {
        bancoRepositorio.save(cuenta);
    }

    public void eliminarEmpleado(Long id) {
        bancoRepositorio.deleteById(id);
    }
}
