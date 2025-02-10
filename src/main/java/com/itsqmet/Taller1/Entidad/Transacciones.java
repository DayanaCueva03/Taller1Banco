package com.itsqmet.Taller1.Entidad;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Transacciones  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal monto;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime fechaMovimiento;
    private String CuentaDestino ;
    private String CuentaOrigen;
private String descripcion;

@ManyToOne
@JoinColumn(name = "id_cuenta")
private Cuenta cuenta;





}
