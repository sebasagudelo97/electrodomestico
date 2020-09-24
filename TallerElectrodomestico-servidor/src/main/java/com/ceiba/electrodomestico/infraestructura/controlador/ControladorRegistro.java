package com.ceiba.electrodomestico.infraestructura.controlador;

import com.ceiba.electrodomestico.aplicacion.comando.ComandoRegistro;
import com.ceiba.electrodomestico.aplicacion.manejador.ManejadorActualizarRegistroParaEntrega;
import com.ceiba.electrodomestico.aplicacion.manejador.ManejadorCrearRegistro;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/registro")
public class ControladorRegistro {

    private final ManejadorCrearRegistro manejadorCrearRegistro;
    private final ManejadorActualizarRegistroParaEntrega manejadorActualizarRegistroParaEntrega;

    public ControladorRegistro(ManejadorCrearRegistro manejadorCrearRegistro, ManejadorActualizarRegistroParaEntrega manejadorActualizarRegistroParaEntrega) {
        this.manejadorCrearRegistro = manejadorCrearRegistro;
        this.manejadorActualizarRegistroParaEntrega = manejadorActualizarRegistroParaEntrega;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void guardarRegistro(@RequestBody ComandoRegistro comandoRegistro){
        this.manejadorCrearRegistro.ejecutar(comandoRegistro);
    }

    @PutMapping(value= "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void actualizarRegistro(@PathVariable long id){
        this.manejadorActualizarRegistroParaEntrega.ejecutar(id);
    }
}
