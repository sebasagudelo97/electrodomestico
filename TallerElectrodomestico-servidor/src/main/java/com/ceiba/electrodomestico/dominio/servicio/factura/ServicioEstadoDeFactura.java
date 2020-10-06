package com.ceiba.electrodomestico.dominio.servicio.factura;

import com.ceiba.electrodomestico.dominio.puerto.dao.DaoRegistro;
import com.ceiba.electrodomestico.infraestructura.entidad.EntidadRegistro;
import com.ceiba.electrodomestico.infraestructura.repositoriojpa.RepositorioRegistroJPA;

public class ServicioEstadoDeFactura {

    private final DaoRegistro daoRegistro;
    private final RepositorioRegistroJPA repositorioRegistroJPA;

    public ServicioEstadoDeFactura(DaoRegistro daoRegistro, RepositorioRegistroJPA repositorioRegistroJPA) {
        this.daoRegistro = daoRegistro;
        this.repositorioRegistroJPA = repositorioRegistroJPA;
    }

    public void cambiarEstadoDeFactura(long id){
        EntidadRegistro entidadRegistro = daoRegistro.buscarPorId(id);
        entidadRegistro.setEstadoFactura(true);
        repositorioRegistroJPA.save(entidadRegistro);
    }
}
