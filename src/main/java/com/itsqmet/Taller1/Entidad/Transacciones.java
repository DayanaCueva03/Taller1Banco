package com.itsqmet.Taller1.Entidad;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Transacciones  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private BigDecimal monto;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaMovimiento;
    private String CuentaDestino ;
    private String CuentaOrigen;

    @ManyToOne
    @JoinColumn(name = "id_cuenta" , nullable = false)
    private Cuenta cuenta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public LocalDate getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(LocalDate fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public String getCuentaDestino() {
        return CuentaDestino;
    }

    public void setCuentaDestino(String cuentaDestino) {
        CuentaDestino = cuentaDestino;
    }

    public String getCuentaOrigen() {
        return CuentaOrigen;
    }

    public void setCuentaOrigen(String cuentaOrigen) {
        CuentaOrigen = cuentaOrigen;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
