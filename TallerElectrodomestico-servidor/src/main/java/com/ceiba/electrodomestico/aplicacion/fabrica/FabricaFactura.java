package com.ceiba.electrodomestico.aplicacion.fabrica;

import com.ceiba.electrodomestico.aplicacion.comando.ComandoFactura;
import com.ceiba.electrodomestico.dominio.modelo.Factura;
import org.springframework.stereotype.Component;

@Component
public class FabricaFactura {

    public Factura crear(ComandoFactura comandoFactura){
        return new Factura(comandoFactura.getId(), comandoFactura.getValorAPagar(), comandoFactura.getValorAdicional(),comandoFactura.getFechaActual(),comandoFactura.getRegistro());
    }
}
