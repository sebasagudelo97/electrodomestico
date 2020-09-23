package com.ceiba.electrodomestico.aplicacion.comando;

import com.ceiba.electrodomestico.dominio.modelo.TipoElectrodomestico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoRegistro {

    private long id;
    private String nombreCliente;
    private String cedulaCliente;
    private TipoElectrodomestico tipoElectrodomestico;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private boolean estadoRegistro;
    private String telefono;
    private double valorPagar;
}
