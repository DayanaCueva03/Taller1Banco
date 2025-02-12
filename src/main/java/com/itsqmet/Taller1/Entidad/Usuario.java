package com.itsqmet.Taller1.Entidad;

import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private int ClienteID;
    private String username;
    private String password;
    private String rol;
}
