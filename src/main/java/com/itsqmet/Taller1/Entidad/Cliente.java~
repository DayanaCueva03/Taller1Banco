package com.itsqmet.Taller1.Entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
public class Cliente  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


   // @Max(value = 10, message = "El número de cédula debe ser de 10 dígitos")
    @Column(unique = true)
    private String cedula;

    //@Size(min = 20, max = 50)
    private String nombre;

   // @NotBlank
    private String correo;

   // @Max(value = 10, message = "El número de teléfono debe ser de 10 dígitos")
    private String telefono;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_nacimiento;

    //@Size(min = 20, max = 150)
    private String direccion;

    //cardinalidad 1 a varios conCuenta

    @OneToMany(mappedBy = "cliente")
    private List<Cuenta> cuentas;
    @OneToMany(mappedBy = "cliente")
    private List<Expediente> expediente;


    }

    // Getters y setters

