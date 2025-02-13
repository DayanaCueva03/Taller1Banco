package com.itsqmet.Taller1.Repositorio;

import com.itsqmet.Taller1.Entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userRepository extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByUsername(String username);
}
