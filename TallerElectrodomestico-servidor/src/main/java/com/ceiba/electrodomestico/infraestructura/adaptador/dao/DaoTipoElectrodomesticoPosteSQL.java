package com.ceiba.electrodomestico.infraestructura.adaptador.dao;

import com.ceiba.electrodomestico.dominio.dto.TipoElectrodomesticoDto;
import com.ceiba.electrodomestico.dominio.puerto.dao.DaoTipoElectrodomestico;
import com.ceiba.electrodomestico.infraestructura.convertidor.ConvertidorTipoElectrodomestico;
import com.ceiba.electrodomestico.infraestructura.entidad.EntidadTipoElectrodomestico;
import com.ceiba.electrodomestico.infraestructura.repositoriojpa.RepositorioTipoElectrodomesticoJPA;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DaoTipoElectrodomesticoPosteSQL implements DaoTipoElectrodomestico {

    private final RepositorioTipoElectrodomesticoJPA repositorioTipoElectrodomesticoJPA;

    public DaoTipoElectrodomesticoPosteSQL(RepositorioTipoElectrodomesticoJPA repositorioTipoElectrodomesticoJPA) {
        this.repositorioTipoElectrodomesticoJPA = repositorioTipoElectrodomesticoJPA;
    }

    @Override
    public List<TipoElectrodomesticoDto> listarTipoElectrodomestico() {
        List<EntidadTipoElectrodomestico> entidadTipoElectrodomestico = this.repositorioTipoElectrodomesticoJPA.findAll();
        List<TipoElectrodomesticoDto> tipoElectrodomesticoDto = new ArrayList<>();
        return ConvertidorTipoElectrodomestico.convertirListaTipoElectrodomesticoEntidadADto(entidadTipoElectrodomestico,tipoElectrodomesticoDto);
    }
}
