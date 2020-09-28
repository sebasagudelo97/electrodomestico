package com.ceiba.electrodomestico.dominio.databuilder.modelo;

import com.ceiba.electrodomestico.dominio.modelo.Factura;
import com.ceiba.electrodomestico.dominio.modelo.Registro;

import java.time.LocalDate;

public class FacturaTestDataBuilder {

    private static final long ID = 1l;
    private static final double VALOR_A_PAGAR = 0;
    private static final double VALOR_ADICIONAL = 0;
    private static final LocalDate FECHA_ACTUAL = LocalDate.of(2020, 9, 26);
    private static final Registro REGISTRO = new RegistroTestDataBuilder().conFechaSalida(LocalDate.of(2020,10,9)).conValorPagar(5000).build();

    private long id;
    private double valorAPagar;
    private double valorAdicional;
    private LocalDate fechaActual;
    private Registro registro;

    public FacturaTestDataBuilder(){
        this.id = ID;
        this.valorAPagar = VALOR_A_PAGAR;
        this.valorAdicional = VALOR_ADICIONAL;
        this.fechaActual = FECHA_ACTUAL;
        this.registro = REGISTRO;
    }

    public FacturaTestDataBuilder conId(long id){
        this.id = id;
        return this;
    }

    public FacturaTestDataBuilder conValorAPagar(double valorAPagar){
        this.valorAPagar = valorAPagar;
        return this;
    }

    public FacturaTestDataBuilder conValorAdicional(double valorAdicional){
        this.valorAdicional = valorAdicional;
        return this;
    }

    public FacturaTestDataBuilder conFechaActual(LocalDate fechaActual){
        this.fechaActual=fechaActual;
        return this;
    }

    public FacturaTestDataBuilder conRegistro(Registro registro){
        this.registro = registro;
        return this;
    }

    public Factura build(){
        return new Factura(this.id,this.valorAPagar,this.valorAdicional,this.fechaActual,this.registro);
    }
}
