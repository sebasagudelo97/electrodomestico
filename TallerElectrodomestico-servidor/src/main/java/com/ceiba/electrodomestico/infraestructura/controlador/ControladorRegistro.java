package com.ceiba.electrodomestico.infraestructura.controlador;

import com.ceiba.electrodomestico.aplicacion.comando.ComandoRegistro;
import com.ceiba.electrodomestico.aplicacion.manejador.ManejadorCrearRegistro;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/registro")
public class ControladorRegistro {

    private final ManejadorCrearRegistro manejadorCrearRegistro;

    public ControladorRegistro(ManejadorCrearRegistro manejadorCrearRegistro) {
        this.manejadorCrearRegistro = manejadorCrearRegistro;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void guardarRegistro(@RequestBody ComandoRegistro comandoRegistro){
        this.manejadorCrearRegistro.ejecutar(comandoRegistro);
    }
}
