package com.ceiba.electrodomestico.infraestructura.adaptador.dao;

import com.ceiba.electrodomestico.dominio.dto.RegistroDto;
import com.ceiba.electrodomestico.dominio.puerto.dao.DaoRegistro;
import com.ceiba.electrodomestico.infraestructura.convertidor.ConvertidorRegistro;
import com.ceiba.electrodomestico.infraestructura.entidad.EntidadRegistro;
import com.ceiba.electrodomestico.infraestructura.repositoriojpa.RepositorioRegistroJPA;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DaoRegistroPostgreSQL implements DaoRegistro {

    private RepositorioRegistroJPA repositorioRegistroJPA;

    public DaoRegistroPostgreSQL(RepositorioRegistroJPA repositorioRegistroJPA) {
        this.repositorioRegistroJPA = repositorioRegistroJPA;
    }

    @Override
    public List<RegistroDto> listarRegistro() {
        List<EntidadRegistro> entidadRegistro = repositorioRegistroJPA.findAll();
        List<RegistroDto> registroDto = new ArrayList<>();
        return ConvertidorRegistro.convertirListaRegistroEntidadADto(entidadRegistro,registroDto);
    }

    @Override
    public EntidadRegistro consultarRegistrPorId(long id) {
        return repositorioRegistroJPA.obtenerRegistroPorId(id);
    }
}
