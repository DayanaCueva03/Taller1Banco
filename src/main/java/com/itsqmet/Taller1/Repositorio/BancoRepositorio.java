package com.itsqmet.Taller1.Repositorio;

import com.itsqmet.Taller1.Entidad.Banco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BancoRepositorio extends JpaRepository<Banco, Long> {
    List<Banco> findByNombreContainingIgnoreCase(String nombre);
}
