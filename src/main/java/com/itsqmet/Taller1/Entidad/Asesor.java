package com.itsqmet.Taller1.Entidad;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Asesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String correo;
    private String telefono;


    @OneToMany(mappedBy = "asesor")
    private List<Expediente> expediente;






}
