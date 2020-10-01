package com.ceiba.electrodomestico.infraestructura.controlador;

import com.ceiba.electrodomestico.aplicacion.comando.ComandoFactura;
import com.ceiba.electrodomestico.aplicacion.manejador.factura.ManejadorCrearFactura;
import com.ceiba.electrodomestico.aplicacion.manejador.factura.ManejadorListarFactura;
import com.ceiba.electrodomestico.dominio.dto.FacturaDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/factura")
public class ControladorFactura {

    private final ManejadorCrearFactura manejadorCrearFactura;
    private final ManejadorListarFactura manejadorListarFactura;

    public ControladorFactura(ManejadorCrearFactura manejadorCrearFactura, ManejadorListarFactura manejadorListarFactura) {
        this.manejadorCrearFactura = manejadorCrearFactura;
        this.manejadorListarFactura = manejadorListarFactura;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void guardarFactura(@RequestBody ComandoFactura comandoFactura){
        this.manejadorCrearFactura.ejecutar(comandoFactura);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FacturaDto> listarTodo(){
        return this.manejadorListarFactura.listarTodo();
    }
}
