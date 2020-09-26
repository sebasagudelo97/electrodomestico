package com.ceiba.electrodomestico.dominio.modelo;

import java.time.DayOfWeek;
import java.time.LocalDate;


public class Factura {

    private static final int CERO_INICIALIZADOR = 0;
    private static final long UNO_PARA_SUMAR_DIAS = 1l;
    private static final int DIAS_MAXIMOS = 5;
    private static final double PORCENTAJE_AUMENTO = 0.05;

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

    public int calcularDiasEntreFechas() {
        int contadorDias = CERO_INICIALIZADOR;
        while (fechaActual.isBefore(registro.getFechaSalida())) {
            if (fechaActual.getDayOfWeek() != DayOfWeek.SUNDAY) {
                contadorDias++;
            }
            fechaActual = fechaActual.plusDays(UNO_PARA_SUMAR_DIAS);
        }
        return contadorDias;
    }

    public double calcularValorAPagar(){
        if (this.calcularDiasEntreFechas() > DIAS_MAXIMOS){
            this.valorAdicional = registro.getValorPagar() * PORCENTAJE_AUMENTO;
            this.valorAPagar = registro.getValorPagar() + valorAdicional;
        }else {
            this.valorAPagar = registro.getValorPagar();
        }
        return this.valorAPagar;
    }
}
