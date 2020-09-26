package com.ceiba.electrodomestico.dominio.databuilder;

import com.ceiba.electrodomestico.aplicacion.comando.ComandoFactura;
import com.ceiba.electrodomestico.dominio.modelo.Factura;
import com.ceiba.electrodomestico.dominio.modelo.Registro;

import java.time.LocalDate;

public class ComandoFacturaTestDataBuilder {

    private static final long ID = 1l;
    private static final double VALOR_A_PAGAR = 5000;
    private static final double VALOR_ADICIONAL = 250;
    private static final LocalDate FECHA_ACTUAL = LocalDate.of(2020, 9, 26);
    private static final Registro REGISTRO = new RegistroTestDataBuilder().conFechaSalida(LocalDate.of(2020,10,9)).conValorPagar(5000).build();

    private long id;
    private double valorAPagar;
    private double valorAdicional;
    private LocalDate fechaActual;
    private Registro registro;

    public ComandoFacturaTestDataBuilder(){
        this.fechaActual =FECHA_ACTUAL;
        this.registro = REGISTRO;
    }

    public ComandoFactura build(){
        return new ComandoFactura(this.id,this.valorAPagar,this.valorAdicional,this.fechaActual,this.registro);
    }
}
