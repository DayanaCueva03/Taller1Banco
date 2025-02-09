package com.itsqmet.Taller1.Entidad;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Movimientos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
private BigDecimal monto;

@DateTimeFormat(pattern = "yyyy-MM-dd")
private LocalDateTime fechaMovimiento;
private String CuentaDestino ;
    private String CuentaOrigen;
    //relacion de muchos a muchos entre cuenta y transacción

    @ManyToOne
    @JoinColumn(name = "id_cuenta")
    private Cuenta cuenta;
    @ManyToOne
    @JoinColumn(name = "id_transaccion")
    private Transacciones transaccion;

}
