package com.ceiba.electrodomestico.aplicacion.manejador.factura;

import com.ceiba.electrodomestico.dominio.dto.FacturaDto;
import com.ceiba.electrodomestico.dominio.puerto.dao.DaoFactura;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarFactura {

    private final DaoFactura daoFactura;

    public ManejadorListarFactura(DaoFactura daoFactura) {
        this.daoFactura = daoFactura;
    }

    public List<FacturaDto> listarTodo(){
        return this.daoFactura.listarTodo();
    }
}
