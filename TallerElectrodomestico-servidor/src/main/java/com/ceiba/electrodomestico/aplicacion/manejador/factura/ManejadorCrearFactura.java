package com.ceiba.electrodomestico.aplicacion.manejador.factura;

import com.ceiba.electrodomestico.aplicacion.comando.ComandoFactura;
import com.ceiba.electrodomestico.aplicacion.fabrica.FabricaFactura;
import com.ceiba.electrodomestico.dominio.modelo.Factura;
import com.ceiba.electrodomestico.dominio.servicio.factura.ServicioCrearFactura;
import com.ceiba.electrodomestico.dominio.servicio.registro.ServicioEstadoDeFactura;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearFactura {

    private final ServicioCrearFactura servicioCrearFactura;
    private final ServicioEstadoDeFactura servicioEstadoDeFactura;
    private final FabricaFactura fabricaFactura;

    public ManejadorCrearFactura(ServicioCrearFactura servicioCrearFactura, ServicioEstadoDeFactura servicioEstadoDeFactura, FabricaFactura fabricaFactura) {
        this.servicioCrearFactura = servicioCrearFactura;
        this.servicioEstadoDeFactura = servicioEstadoDeFactura;
        this.fabricaFactura = fabricaFactura;
    }

    public void ejecutar(ComandoFactura comandoFactura){
        this.servicioEstadoDeFactura.cambiarEstadoDeFactura(comandoFactura.getRegistro().getId());
        Factura factura = this.fabricaFactura.crear(comandoFactura);
        servicioCrearFactura.ejecutar(factura);
    }
}
