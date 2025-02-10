package com.itsqmet.Taller1.Entidad;

import java.math.BigDecimal;

public class InformacionClienteDTO {
    private String nombreCliente;
private String cedulaCliente;
private String numeroCuenta;
private BigDecimal Saldo;
private String tipoCuenta;

//Getters y Setters


    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public BigDecimal getSaldo() {
        return Saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        Saldo = saldo;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }
}
