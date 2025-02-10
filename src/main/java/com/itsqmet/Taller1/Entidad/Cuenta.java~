package com.itsqmet.Taller1.Entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Size(min = 3, max = 30)

    private String tipoCuenta;

    //@NotBlank
    //@Email(message = "Ingrese el correo en formato válido")
    private String numeroCuenta;

    //@NotNull
    //@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,15}")
    private BigDecimal saldo; ;

   // @Size(min = 10, max = 150)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime fechaApertura;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime fechaCaducidad;

    private String estado;

    //Cardinalidad con la entidad Cliente, R=1-n

    @ManyToOne
    @JoinColumn(name = "cedula")
    private Cliente cliente;
@OneToMany(mappedBy = "cuenta")
    private List<Movimientos> movimientos;

}
