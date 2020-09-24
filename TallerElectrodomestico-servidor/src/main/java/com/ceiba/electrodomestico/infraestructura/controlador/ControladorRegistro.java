package com.ceiba.electrodomestico.infraestructura.controlador;

import com.ceiba.electrodomestico.aplicacion.comando.ComandoRegistro;
import com.ceiba.electrodomestico.aplicacion.manejador.ManejadorActualizarRegistroParaEntrega;
import com.ceiba.electrodomestico.aplicacion.manejador.ManejadorCrearRegistro;
import com.ceiba.electrodomestico.aplicacion.manejador.ManejadorListarRegistro;
import com.ceiba.electrodomestico.dominio.dto.RegistroDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/registro")
public class ControladorRegistro {

    private final ManejadorCrearRegistro manejadorCrearRegistro;
    private final ManejadorActualizarRegistroParaEntrega manejadorActualizarRegistroParaEntrega;
    private final ManejadorListarRegistro manejadorListarRegistro;

    public ControladorRegistro(ManejadorCrearRegistro manejadorCrearRegistro, ManejadorActualizarRegistroParaEntrega manejadorActualizarRegistroParaEntrega, ManejadorListarRegistro manejadorListarRegistro) {
        this.manejadorCrearRegistro = manejadorCrearRegistro;
        this.manejadorActualizarRegistroParaEntrega = manejadorActualizarRegistroParaEntrega;
        this.manejadorListarRegistro = manejadorListarRegistro;
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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RegistroDto> listarRegistro(){
        return this.manejadorListarRegistro.ejecutar();
    }
}
