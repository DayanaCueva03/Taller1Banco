package com.itsqmet.Taller1.Repositorio;

import com.itsqmet.Taller1.Entidad.Expediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpedienteRepository extends JpaRepository<Expediente, Long> {
}
