package com.ceiba.electrodomestico.aplicacion.comando;

import com.ceiba.electrodomestico.dominio.modelo.Registro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoFactura {

    private long id;
    private double valorAPagar;
    private double valorAdicional;
    private LocalDate fechaActual;
    private Registro registro;
}
