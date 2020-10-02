package com.ceiba.electrodomestico.dominio.modelo;

import com.ceiba.electrodomestico.dominio.databuilder.modelo.FacturaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class FacturaTest {
    private static final int VALOR_ESPERADO = 11;
    private static final double VALOR_ESPERADO_CON_AUMENTOS = 5250;
    private static final double VALOR_ESPERADO_SIN_AUMENTO = 5000;
    private static final LocalDate FECHA_ACTUAL = LocalDate.of(2020, 9, 27);

    @Test
    public void calcularDiasEntreFechasTest(){
        Factura factura = new FacturaTestDataBuilder().build();
        int valorObtenido = factura.calcularDiasEntreFechas();

        Assertions.assertEquals(VALOR_ESPERADO,valorObtenido);
    }

    @Test
    public void calcularValorAPagarConCobroAdicionalTest(){
        Factura factura = new FacturaTestDataBuilder().build();
        double valorEsperado = VALOR_ESPERADO_CON_AUMENTOS;
        double valorObtenido = factura.calcularValorAPagar();

        Assertions.assertEquals(valorEsperado, valorObtenido);
    }

    @Test
    public void calcularValorAPagarSinCobroAdicionalTest(){
        Factura factura = new FacturaTestDataBuilder().conFechaActual(FECHA_ACTUAL).build();
        double valorEsperado = VALOR_ESPERADO_SIN_AUMENTO;
        double valorObtenido = factura.calcularValorAPagar();

        Assertions.assertEquals(valorEsperado, valorObtenido);
    }
}
