package com.ceiba.electrodomestico.dominio.excepcion;

public class ExcepcionCampoObligatorio extends RuntimeException{

    public ExcepcionCampoObligatorio(String message) {
        super(message);
    }
}
