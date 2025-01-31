package com.itsqmet.Taller1.Service;

import com.itsqmet.Taller1.Entidad.Banco;
import com.itsqmet.Taller1.Repositorio.BancoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BancoServicio {

    @Autowired
    private BancoRepositorio bancoRepositorio;

    public List<Banco> buscarPorNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            return bancoRepositorio.findAll();
        } else {
            return bancoRepositorio.findByNombreContainingIgnoreCase(nombre);
        }
    }


    public void insertarEmpleado(Banco banco) {
        bancoRepositorio.save(banco);
    }

    public void eliminarEmpleado(Long id) {
        bancoRepositorio.deleteById(id);
    }
}
