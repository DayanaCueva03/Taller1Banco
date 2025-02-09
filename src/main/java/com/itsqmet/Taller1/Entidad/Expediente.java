package com.itsqmet.Taller1.Entidad;

import jakarta.persistence.*;

@Entity
public class Expediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    //relacion de muchos a muchos con cliente y ascesor
    @ManyToOne
    @JoinColumn(name = "idcliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idasesor")
    private Asesor asesor;

}
