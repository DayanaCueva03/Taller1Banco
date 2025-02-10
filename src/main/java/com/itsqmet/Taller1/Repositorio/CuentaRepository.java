package com.itsqmet.Taller1.Repositorio;

import com.itsqmet.Taller1.Entidad.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    public List<Cuenta> findByClienteId(Long clienteId);
}
