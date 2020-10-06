package com.ceiba.electrodomestico.dominio.validador;

import com.ceiba.electrodomestico.dominio.excepcion.ExcepcionCampoObligatorio;
import org.assertj.core.api.Fail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidadorArgumentoTest {

    private static final String EXCEPCION_CAMPO_OBLIGATORIO = "Este campo es obligatorio";

    @Test
    public void validarCampoObligatorioConArgumentoNuloTest(){
        Assertions.assertThrows(ExcepcionCampoObligatorio.class,
                    () -> ValidadorArgumento.validarCampoObligatorio(null, EXCEPCION_CAMPO_OBLIGATORIO),
                    EXCEPCION_CAMPO_OBLIGATORIO);

    }
}
