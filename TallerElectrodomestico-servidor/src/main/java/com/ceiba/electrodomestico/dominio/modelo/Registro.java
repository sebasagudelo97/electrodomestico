package com.ceiba.electrodomestico.dominio.modelo;

import com.ceiba.electrodomestico.dominio.validador.ValidadorArgumento;

import java.time.LocalDate;

public class Registro {

    private static final String EXCEPCION_CAMPO_OBLIGATORIO = "Este campo es obligatorio";

    private long id;
    private String nombreCliente;
    private String cedulaCliente;
    private TipoElectrodomestico tipoElectrodomestico;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private boolean estadoRegistro;
    private boolean estadoFactura;
    private String telefono;
    private double valorPagar;


    public Registro(long id, String nombreCliente, String cedulaCliente, TipoElectrodomestico tipoElectrodomestico, LocalDate fechaIngreso, LocalDate fechaSalida, boolean estadoFactura, boolean estadoRegistro, String telefono, double valorPagar) {
        ValidadorArgumento.validarCampoObligatorio(nombreCliente, EXCEPCION_CAMPO_OBLIGATORIO);
        ValidadorArgumento.validarCampoObligatorio(cedulaCliente, EXCEPCION_CAMPO_OBLIGATORIO);
        ValidadorArgumento.validarCampoObligatorio(tipoElectrodomestico, EXCEPCION_CAMPO_OBLIGATORIO);
        ValidadorArgumento.validarCampoObligatorio(fechaIngreso, EXCEPCION_CAMPO_OBLIGATORIO);
        ValidadorArgumento.validarCampoObligatorio(estadoRegistro, EXCEPCION_CAMPO_OBLIGATORIO);
        ValidadorArgumento.validarCampoObligatorio(telefono, EXCEPCION_CAMPO_OBLIGATORIO);

        this.id = id;
        this.nombreCliente = nombreCliente;
        this.cedulaCliente = cedulaCliente;
        this.tipoElectrodomestico = tipoElectrodomestico;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.estadoFactura = estadoFactura;
        this.estadoRegistro = estadoRegistro;
        this.telefono = telefono;
        this.valorPagar = valorPagar;
    }

    public long getId() {
        return id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public TipoElectrodomestico getTipoElectrodomestico() {
        return tipoElectrodomestico;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public boolean isEstadoRegistro() {
        return estadoRegistro;
    }

    public String getTelefono() {
        return telefono;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public boolean isEstadoFactura() {
        return estadoFactura;
    }
}
