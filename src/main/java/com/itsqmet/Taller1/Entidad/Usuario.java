package com.itsqmet.Taller1.Entidad;

import com.itsqmet.Taller1.Rol.Rol;
import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private Long ClienteID;  // Debe ser único para vincular cada usuario con un cliente específico

    @Column(unique = true, nullable = false)
    private String username;  // Campo único para loguearse

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)  // Guarda el valor como texto en la base de datos (CLIENTE, ADMINISTRADOR, EMPLEADO)
    @Column(nullable = false)
    private Rol rol;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Long getClienteID() {
        return ClienteID;
    }

    public void setClienteID(Long clienteID) {
        ClienteID = clienteID;
    }
}
