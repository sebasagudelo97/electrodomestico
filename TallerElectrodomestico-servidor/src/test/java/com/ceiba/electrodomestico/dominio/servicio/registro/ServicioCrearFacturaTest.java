package com.ceiba.electrodomestico.dominio.servicio.registro;

import com.ceiba.electrodomestico.dominio.databuilder.modelo.FacturaTestDataBuilder;
import com.ceiba.electrodomestico.dominio.excepcion.ExcepcionRegistroNulo;
import com.ceiba.electrodomestico.dominio.modelo.Factura;
import com.ceiba.electrodomestico.dominio.puerto.repositorio.RepositorioFactura;
import com.ceiba.electrodomestico.dominio.servicio.factura.ServicioCrearFactura;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioCrearFacturaTest {
    private static final String REGISTRO_NULO = "El registro no puede ser nulo";

    ServicioCrearFactura servicioCrearFactura;
    RepositorioFactura repositorioFactura;

    @BeforeEach
    public void init(){
        repositorioFactura= Mockito.mock(RepositorioFactura.class);
        servicioCrearFactura = new ServicioCrearFactura(repositorioFactura);
    }

    @Test
    public void validarEntradaDeFacturaConRegistroNuloTest(){
        Factura factura = new FacturaTestDataBuilder().conRegistro(null).build();
        Assertions.assertThrows(ExcepcionRegistroNulo.class,
                () -> ServicioCrearFactura.validarRegistroEnFacturaNoNulo(factura),
                REGISTRO_NULO);
    }
}
