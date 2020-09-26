package com.ceiba.electrodomestico.infraestructura.adaptador.repositorio;

import com.ceiba.electrodomestico.dominio.modelo.Factura;
import com.ceiba.electrodomestico.dominio.puerto.repositorio.RepositorioFactura;
import com.ceiba.electrodomestico.infraestructura.convertidor.ConvertidorRegistro;
import com.ceiba.electrodomestico.infraestructura.entidad.EntidadFactura;
import com.ceiba.electrodomestico.infraestructura.entidad.EntidadRegistro;
import com.ceiba.electrodomestico.infraestructura.repositoriojpa.RepositorioFacturaJPA;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioFacturaPostgreSQL implements RepositorioFactura {

    private final RepositorioFacturaJPA repositorioFacturaJPA;

    public RepositorioFacturaPostgreSQL(RepositorioFacturaJPA repositorioFacturaJPA) {
        this.repositorioFacturaJPA = repositorioFacturaJPA;
    }

    @Override
    public void guardar(Factura factura) {
        ModelMapper modelMapper = new ModelMapper();
        EntidadRegistro entidadRegistro = ConvertidorRegistro.convertirDeModeloAEntidad(factura.getRegistro());
        EntidadFactura entidadFactura = modelMapper.map(factura, EntidadFactura.class);
        entidadFactura.setEntidadRegistro(entidadRegistro);
        repositorioFacturaJPA.save(entidadFactura);
    }
}
