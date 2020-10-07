package com.ceiba.electrodomestico.infraestructura.entidad;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "factura")
public class EntidadFactura {

    @Id
    @Column(name = "in_codigo")
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private LocalDate fechaActual;

    @Column(nullable = false)
    private double valorAPagar;

    @Column
    private double valorAdicional;

    @OneToOne
    @JoinColumn
    private EntidadRegistro entidadRegistro;
}
