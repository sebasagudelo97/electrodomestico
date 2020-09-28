package com.ceiba.electrodomestico.dominio.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TipoElectrodomesticoDto {

    private long id;
    private String marca;
    private String descripcion;
}
