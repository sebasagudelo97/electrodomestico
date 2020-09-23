package com.ceiba.electrodomestico.infraestructura.entidad;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "registro")
public class EntidadRegistro {

    @Id
    @Column(name = "in_codigo")
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String nombreCliente;

    @Column(nullable = false)
    private String cedulaCliente;

    @ManyToOne
    @JoinColumn(name = "in_codigo")
    private EntidadTipoElectrodomestico  entidadTipoElectrodomestico;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private LocalDate fechaIngreso;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private LocalDate fechaSalida;

    @Column(nullable = false)
    private boolean estadoRegistro;

    @Column(nullable = false)
    private String telefono;

    @Column
    private double valorPagar;
}
