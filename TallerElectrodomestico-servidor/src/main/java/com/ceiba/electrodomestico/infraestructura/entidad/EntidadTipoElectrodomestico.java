package com.ceiba.electrodomestico.infraestructura.entidad;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tipo_electrodomestico")
public class EntidadTipoElectrodomestico {

    @Id
    @Column
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String descripcion;
}
