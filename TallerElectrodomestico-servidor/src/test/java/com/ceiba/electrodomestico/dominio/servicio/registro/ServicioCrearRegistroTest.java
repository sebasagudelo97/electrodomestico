package com.ceiba.electrodomestico.dominio.servicio.registro;

import com.ceiba.electrodomestico.dominio.databuilder.modelo.RegistroTestDataBuilder;
import com.ceiba.electrodomestico.dominio.modelo.Registro;
import com.ceiba.electrodomestico.dominio.puerto.repositorio.RepositorioRegistro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class ServicioCrearRegistroTest {

    ServicioCrearRegistro servicioCrearRegistro;
    RepositorioRegistro repositorioRegistro;

    @BeforeEach
    public void init(){
        repositorioRegistro = Mockito.mock(RepositorioRegistro.class);
        servicioCrearRegistro = new ServicioCrearRegistro(repositorioRegistro);
    }

    @Test
    public void ejecutarTest(){
        Registro registro = new RegistroTestDataBuilder().build();
        servicioCrearRegistro.ejecutar(registro);


        Assertions.assertEquals(registro.getTipoElectrodomestico().getMarca(), "imusa");
    }
}
