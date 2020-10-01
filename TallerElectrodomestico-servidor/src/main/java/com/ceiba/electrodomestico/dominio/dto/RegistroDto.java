package com.ceiba.electrodomestico.dominio.dto;

import com.ceiba.electrodomestico.dominio.modelo.TipoElectrodomestico;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class RegistroDto {

    private long id;
    private String nombreCliente;
    private String cedulaCliente;
    private TipoElectrodomestico tipoElectrodomestico;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private boolean estadoFactura;
    private boolean estadoRegistro;
    private String telefono;
    private double valorPagar;

}
