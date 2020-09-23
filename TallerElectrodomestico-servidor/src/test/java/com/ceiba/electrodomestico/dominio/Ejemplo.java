package com.ceiba.electrodomestico.dominio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Ejemplo {

    @Test
    public void pruebaEjemplo(){
        int numero1 = 3;
        int nuemero2 = 3;
        int resultado = 3 + 3;
        int suma = 6;

        Assertions.assertEquals(suma, resultado);
    }
}
