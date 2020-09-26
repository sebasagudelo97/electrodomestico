package com.ceiba.electrodomestico.dominio.validador;

import com.ceiba.electrodomestico.dominio.excepcion.ExcepcionCampoObligatorio;

public class ValidadorArgumento {

    private ValidadorArgumento(){}

    public static void validarCampoObligatorio(Object valor, String mensaje) {
        if (valor == null) {
            throw new ExcepcionCampoObligatorio(mensaje);
        }
    }
}
