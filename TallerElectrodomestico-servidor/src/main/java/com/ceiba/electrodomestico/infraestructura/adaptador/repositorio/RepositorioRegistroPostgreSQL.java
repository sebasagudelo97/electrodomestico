package com.ceiba.electrodomestico.infraestructura.adaptador.repositorio;

import com.ceiba.electrodomestico.dominio.modelo.Registro;
import com.ceiba.electrodomestico.dominio.puerto.repositorio.RepositorioRegistro;
import com.ceiba.electrodomestico.infraestructura.entidad.EntidadRegistro;
import com.ceiba.electrodomestico.infraestructura.entidad.EntidadTipoElectrodomestico;
import com.ceiba.electrodomestico.infraestructura.repositoriojpa.RepositorioRegistroJPA;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioRegistroPostgreSQL implements RepositorioRegistro {

    private RepositorioRegistroJPA repositorioRegistroJPA;
    private ModelMapper modelMapper = new ModelMapper();

    public RepositorioRegistroPostgreSQL(RepositorioRegistroJPA repositorioRegistroJPA) {
        this.repositorioRegistroJPA = repositorioRegistroJPA;
    }

    @Override
    public void guardar(Registro registro) {
        EntidadTipoElectrodomestico entidadTipoElectrodomestico = modelMapper.map(registro.getTipoElectrodomestico(), EntidadTipoElectrodomestico.class);
        EntidadRegistro entidadRegistro = modelMapper.map(registro, EntidadRegistro.class);
        entidadRegistro.setEntidadTipoElectrodomestico(entidadTipoElectrodomestico);
        repositorioRegistroJPA.save(entidadRegistro);
    }
}
