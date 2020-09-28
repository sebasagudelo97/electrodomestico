package com.ceiba.electrodomestico.dominio.modelo;

import com.ceiba.electrodomestico.dominio.validador.ValidadorArgumento;

public class TipoElectrodomestico {

    private static final String CAMPO_OBLIGATORIO = "Este campo es obligatorio";

    private long id;
    private String marca;
    private String descripcion;

    public TipoElectrodomestico(long id, String marca, String descripcion) {
        ValidadorArgumento.validarCampoObligatorio(marca, CAMPO_OBLIGATORIO);
        ValidadorArgumento.validarCampoObligatorio(descripcion, CAMPO_OBLIGATORIO);

        this.id = id;
        this.marca = marca;
        this.descripcion = descripcion;
    }

    public long getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
