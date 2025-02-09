package com.itsqmet.Taller1.Repositorio;

import com.itsqmet.Taller1.Entidad.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BancoRepositorio extends JpaRepository<Cuenta, Long> {
    List<Cuenta> findByNombreContainingIgnoreCase(String nombre);
}
