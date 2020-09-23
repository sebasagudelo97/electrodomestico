package com.ceiba.electrodomestico.dominio.modelo;

public class TipoElectrodomestico {

    private long id;
    private String marca;
    private String descripcion;

    public TipoElectrodomestico(long id, String marca, String descripcion) {
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
