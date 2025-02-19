package com.itsqmet.Taller1.Repositorio;

import com.itsqmet.Taller1.Entidad.Asesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsesorRepository extends JpaRepository<Asesor, Long> {
}
