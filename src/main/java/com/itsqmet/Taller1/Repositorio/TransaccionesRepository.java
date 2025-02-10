package com.itsqmet.Taller1.Repositorio;

import com.itsqmet.Taller1.Entidad.Transacciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionesRepository extends JpaRepository<Transacciones, Long> {
}
