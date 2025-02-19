package com.itsqmet.Taller1.Repositorio;

import com.itsqmet.Taller1.Entidad.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    @Query(value = "select cu.numero_cuenta,cu.id from cliente cl \n" +
            "Join cuenta cu \n" +
            "on cl.id=cu.id_cliente where cl.id= :id", nativeQuery = true)
    List<Object[]> buscarCuentas(@Param("id") Long id);
}
