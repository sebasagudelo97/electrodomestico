package com.ceiba.electrodomestico.aplicacion.manejador.factura;

import com.ceiba.electrodomestico.aplicacion.comando.ComandoFactura;
import com.ceiba.electrodomestico.aplicacion.fabrica.FabricaFactura;
import com.ceiba.electrodomestico.dominio.modelo.Factura;
import com.ceiba.electrodomestico.dominio.servicio.factura.ServicioCrearFactura;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearFactura {

    private final ServicioCrearFactura servicioCrearFactura;
    private final FabricaFactura fabricaFactura;

    public ManejadorCrearFactura(ServicioCrearFactura servicioCrearFactura, FabricaFactura fabricaFactura) {
        this.servicioCrearFactura = servicioCrearFactura;
        this.fabricaFactura = fabricaFactura;
    }

    public void ejecutar(ComandoFactura comandoFactura){
        Factura factura = this.fabricaFactura.crear(comandoFactura);
        servicioCrearFactura.ejecutar(factura);
    }
}
