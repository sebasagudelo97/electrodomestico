package com.ceiba.electrodomestico.infraestructura.convertidor;

import com.ceiba.electrodomestico.dominio.modelo.TipoElectrodomestico;
import com.ceiba.electrodomestico.infraestructura.entidad.EntidadTipoElectrodomestico;

public class ConvertidorTipoElectrodomestico {

    private ConvertidorTipoElectrodomestico() { }

    public static TipoElectrodomestico convertirDeEntidadAModelo(EntidadTipoElectrodomestico entidadTipoElectrodomestico){
        return new TipoElectrodomestico(entidadTipoElectrodomestico.getId(),entidadTipoElectrodomestico.getMarca(),entidadTipoElectrodomestico.getDescripcion());
    }
}
