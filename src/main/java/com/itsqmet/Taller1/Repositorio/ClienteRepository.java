package com.itsqmet.Taller1.Repositorio;

import com.itsqmet.Taller1.Entidad.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query(value = "SELECT cl.nombre, cl.cedula, cu.numero_cuenta, cu.saldo, cu.tipo_cuenta,cu.fecha_caducidad,cl.id \n" +
            "FROM cliente cl \n" +
            "JOIN cuenta cu ON cl.id = cu.id_cliente\n"+
            "WHERE cl.id = :id\n" +
            "ORDER BY cu.fecha_apertura DESC limit 1", nativeQuery = true)
    List<Object[]> buscarCuentaReciente(@Param("id") Long id);


}
