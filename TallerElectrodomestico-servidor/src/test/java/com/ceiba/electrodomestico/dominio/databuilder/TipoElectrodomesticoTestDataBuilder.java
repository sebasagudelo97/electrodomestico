package com.ceiba.electrodomestico.dominio.databuilder;

import com.ceiba.electrodomestico.dominio.modelo.TipoElectrodomestico;

public class TipoElectrodomesticoTestDataBuilder {

    private static final long ID = 1l;
    private static final String MARCA = "imusa";
    private static final String DESCRIPCION = "olla";

    private long id;
    private String marca;
    private String descripcion;

    public TipoElectrodomesticoTestDataBuilder(){
        this.id = ID;
        this.marca = MARCA;
        this.descripcion = DESCRIPCION;
    }

    public TipoElectrodomesticoTestDataBuilder conId(long id){
        this.id = id;
        return this;
    }

    public TipoElectrodomesticoTestDataBuilder conMarca(String marca){
        this.marca = marca;
        return this;
    }

    public TipoElectrodomesticoTestDataBuilder conDescripcion(String descripcion){
        this.descripcion = descripcion;
        return this;
    }

    public TipoElectrodomestico build(){
        return new TipoElectrodomestico(this.id,this.marca,this.descripcion);
    }

}
