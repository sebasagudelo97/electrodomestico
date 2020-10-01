package com.ceiba.electrodomestico.dominio.dto;

import com.ceiba.electrodomestico.dominio.modelo.Registro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class FacturaDto {

    private long id;
    private double valorAPagar;
    private double valorAdicional;
    private LocalDate fechaActual;
    private RegistroDto registroDto;
}
