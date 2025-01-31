package com.itsqmet.Taller1.Entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Cliente {
    @Id
    @Max(value = 10, message = "El número de cédula debe ser de 10 dígitos")
    private String cedula;

    @Size(min = 20, max = 50)
    private String nombres_completos;

    @NotBlank
    private String correo_electronico;

    @Max(value = 10, message = "El número de teléfono debe ser de 10 dígitos")
    private String telefono;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_nacimiento;

    @Size(min = 20, max = 150)
    private String direccion;

    public @Size(min = 20, max = 150) String getDireccion() {
        return direccion;
    }

    public void setDireccion(@Size(min = 20, max = 150) String direccion) {
        this.direccion = direccion;
    }

    // Getters y setters


    public @Max(value = 10, message = "El número de cédula debe ser de 10 dígitos") String getCedula() {
        return cedula;
    }

    public void setCedula(@Max(value = 10, message = "El número de cédula debe ser de 10 dígitos") String cedula) {
        this.cedula = cedula;
    }

    public @Size(min = 20, max = 50) String getNombres_completos() {
        return nombres_completos;
    }

    public void setNombres_completos(@Size(min = 20, max = 50) String nombres_completos) {
        this.nombres_completos = nombres_completos;
    }

    public @NotBlank String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(@NotBlank String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public @Max(value = 10, message = "El número de teléfono debe ser de 10 dígitos") String getTelefono() {
        return telefono;
    }

    public void setTelefono(@Max(value = 10, message = "El número de teléfono debe ser de 10 dígitos") String telefono) {
        this.telefono = telefono;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
}
