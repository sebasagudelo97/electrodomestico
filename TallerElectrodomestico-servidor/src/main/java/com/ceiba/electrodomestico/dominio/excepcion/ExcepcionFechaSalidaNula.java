package com.ceiba.electrodomestico.dominio.excepcion;

public class ExcepcionFechaSalidaNula extends RuntimeException{

    public ExcepcionFechaSalidaNula(String message) {
        super(message);
    }
}
