package com.ceiba.electrodomestico.dominio.servicio.registro;

import com.ceiba.electrodomestico.dominio.puerto.dao.DaoRegistro;
import com.ceiba.electrodomestico.dominio.servicio.factura.ServicioEstadoDeFactura;
import com.ceiba.electrodomestico.infraestructura.entidad.EntidadRegistro;
import com.ceiba.electrodomestico.infraestructura.repositoriojpa.RepositorioRegistroJPA;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEstadoFacturaTest {

    private static final long ID = 1L;

    ServicioEstadoDeFactura servicioEstadoDeFactura;
    RepositorioRegistroJPA repositorioRegistroJPA;
    DaoRegistro daoRegistro;

    @BeforeEach
    public void init(){
        daoRegistro = Mockito.mock(DaoRegistro.class);
        repositorioRegistroJPA = Mockito.mock(RepositorioRegistroJPA.class);
        servicioEstadoDeFactura = new ServicioEstadoDeFactura(daoRegistro,repositorioRegistroJPA);
    }

    @Test
    public void cambiarEstadFacturaTest(){
        EntidadRegistro entidadRegistro = Mockito.mock(EntidadRegistro.class);
        Mockito.when(daoRegistro.buscarPorId(ID)).thenReturn(entidadRegistro);
        entidadRegistro.setEstadoFactura(true);
        Mockito.when(entidadRegistro.isEstadoFactura()).thenReturn(true);
        repositorioRegistroJPA.save(entidadRegistro);

        Assertions.assertEquals(true, entidadRegistro.isEstadoFactura());
    }
}
