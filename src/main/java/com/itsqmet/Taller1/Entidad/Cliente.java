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

    @OneToMany(mappedBy = "clientes")
    private List<Expediente> expediente;

    // Getters y setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public List<Expediente> getExpediente() {
        return expediente;
    }

    public void setExpediente(List<Expediente> expediente) {
        this.expediente = expediente;
    }
}



