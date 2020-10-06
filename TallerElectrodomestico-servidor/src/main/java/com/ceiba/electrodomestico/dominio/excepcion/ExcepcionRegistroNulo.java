package com.ceiba.electrodomestico.dominio.excepcion;

public class ExcepcionRegistroNulo extends RuntimeException{

    public ExcepcionRegistroNulo(String message) {
        super(message);
    }
}
