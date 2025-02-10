package com.itsqmet.Taller1.Repositorio;

import com.itsqmet.Taller1.Entidad.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query(value = "SELECT cl.nombre, cl.cedula, cu.numero_cuenta, cu.saldo, cu.tipo_cuenta " +
            "FROM cliente cl " +
            "JOIN cuenta cu ON cl.id = cu.id_cliente " +
            "WHERE cl.id = :id", nativeQuery = true)
    List<Object[]> buscarCuentas(@Param("id") Long id);

    @Query(value = "SELECT cl.nombre, cl.cedula, cu.numero_cuenta, cu.saldo, cu.tipo_cuenta, \n" +
            "       tr.monto, tr.fecha_movimiento, tr.descripcion\n" +
            "FROM cliente cl \n" +
            "JOIN cuenta cu ON cl.id = cu.id_cliente\n" +
            "JOIN transacciones tr ON cu.id = tr.id_cuenta\n" +
            "WHERE cl.id = :id\n" +
            "ORDER BY cu.fecha_apertura DESC limit 1;", nativeQuery = true)
    List<Object[]> buscarCuentaReciente(@Param("id") Long id);


}
