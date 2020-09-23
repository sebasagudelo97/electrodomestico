package com.ceiba.electrodomestico.dominio.modelo;

import java.time.LocalDate;

public class Factura {

    private long id;
    private double valorAPagar;
    private double valorAdicional;
    private LocalDate fechaActual;
    private Registro registro;

    public Factura(long id, double valorAPagar, double valorAdicional, LocalDate fechaActual, Registro registro) {
        this.id = id;
        this.valorAPagar = valorAPagar;
        this.valorAdicional = valorAdicional;
        this.fechaActual = fechaActual;
        this.registro = registro;
    }

    public long getId() {
        return id;
    }

    public double getValorAPagar() {
        return valorAPagar;
    }

    public double getValorAdicional() {
        return valorAdicional;
    }

    public LocalDate getFechaActual() {
        return fechaActual;
    }

    public Registro getRegistro() {
        return registro;
    }
}
