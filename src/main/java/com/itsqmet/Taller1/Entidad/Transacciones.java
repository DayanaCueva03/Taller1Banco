package com.itsqmet.Taller1.Entidad;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Transacciones  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
private String descripcion;
@OneToMany(mappedBy = "id_transaccion")
private List<Movimientos> movimientos;




}
