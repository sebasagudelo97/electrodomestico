package com.ceiba.electrodomestico.infraestructura.controlador;

import com.ceiba.electrodomestico.aplicacion.comando.ComandoFactura;
import com.ceiba.electrodomestico.aplicacion.manejador.factura.ManejadorCrearFactura;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/factura")
public class ControladorFactura {

    private final ManejadorCrearFactura manejadorCrearFactura;

    public ControladorFactura(ManejadorCrearFactura manejadorCrearFactura) {
        this.manejadorCrearFactura = manejadorCrearFactura;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void guardarFactura(@RequestBody ComandoFactura comandoFactura){
        this.manejadorCrearFactura.ejecutar(comandoFactura);
    }
}
