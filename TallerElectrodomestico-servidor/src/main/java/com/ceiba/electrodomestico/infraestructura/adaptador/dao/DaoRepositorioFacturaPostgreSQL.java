package com.ceiba.electrodomestico.infraestructura.adaptador.dao;

import com.ceiba.electrodomestico.dominio.dto.FacturaDto;
import com.ceiba.electrodomestico.dominio.puerto.dao.DaoFactura;
import com.ceiba.electrodomestico.infraestructura.convertidor.ConvertidorFactura;
import com.ceiba.electrodomestico.infraestructura.entidad.EntidadFactura;
import com.ceiba.electrodomestico.infraestructura.repositoriojpa.RepositorioFacturaJPA;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DaoRepositorioFacturaPostgreSQL implements DaoFactura {

    private final RepositorioFacturaJPA repositorioFacturaJPA;

    public DaoRepositorioFacturaPostgreSQL(RepositorioFacturaJPA repositorioFacturaJPA) {
        this.repositorioFacturaJPA = repositorioFacturaJPA;
    }

    @Override
    public List<FacturaDto> listarTodo() {
        List<EntidadFactura> entidadFacturas = repositorioFacturaJPA.findAll();
        List<FacturaDto> facturaDtos = new ArrayList<>();
        return ConvertidorFactura.convertirListaFacturaEntidadADto(entidadFacturas,facturaDtos);
    }
}
