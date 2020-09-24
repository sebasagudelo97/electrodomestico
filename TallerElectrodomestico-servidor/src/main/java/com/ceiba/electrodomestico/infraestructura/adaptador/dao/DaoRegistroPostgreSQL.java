package com.ceiba.electrodomestico.infraestructura.adaptador.dao;

import com.ceiba.electrodomestico.dominio.puerto.dao.DaoRegistro;
import com.ceiba.electrodomestico.infraestructura.entidad.EntidadRegistro;
import com.ceiba.electrodomestico.infraestructura.repositoriojpa.RepositorioRegistroJPA;
import org.springframework.stereotype.Repository;

@Repository
public class DaoRegistroPostgreSQL implements DaoRegistro {

    private RepositorioRegistroJPA repositorioRegistroJPA;

    public DaoRegistroPostgreSQL(RepositorioRegistroJPA repositorioRegistroJPA) {
        this.repositorioRegistroJPA = repositorioRegistroJPA;
    }

    @Override
    public EntidadRegistro consultarRegistrPorId(long id) {
        return repositorioRegistroJPA.obtenerRegistroPorId(id);
    }
}
