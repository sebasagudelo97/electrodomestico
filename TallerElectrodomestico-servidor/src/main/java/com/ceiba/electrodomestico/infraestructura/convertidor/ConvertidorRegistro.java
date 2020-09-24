package com.ceiba.electrodomestico.infraestructura.convertidor;

import com.ceiba.electrodomestico.dominio.modelo.Registro;
import com.ceiba.electrodomestico.dominio.modelo.TipoElectrodomestico;
import com.ceiba.electrodomestico.infraestructura.entidad.EntidadRegistro;

public class ConvertidorRegistro {

    private ConvertidorRegistro() {}

    public static Registro convertirDeEntidadAModelo(EntidadRegistro entidadRegistro){
        TipoElectrodomestico tipoElectrodomestico = ConvertidorTipoElectrodomestico.convertirDeEntidadAModelo(entidadRegistro.getEntidadTipoElectrodomestico());
        return new Registro(entidadRegistro.getId(), entidadRegistro.getNombreCliente(),entidadRegistro.getCedulaCliente(),tipoElectrodomestico,entidadRegistro.getFechaIngreso(),entidadRegistro.getFechaSalida(),entidadRegistro.isEstadoRegistro(),entidadRegistro.getTelefono(),entidadRegistro.getValorPagar());
    }
}
