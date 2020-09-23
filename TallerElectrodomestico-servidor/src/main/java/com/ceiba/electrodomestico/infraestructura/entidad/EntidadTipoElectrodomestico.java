package com.ceiba.electrodomestico.infraestructura.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "tipo_electrodomestico")
public class EntidadTipoElectrodomestico {

    @Id
    @Column(name = "in_codigo")
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String descripcion;
}
