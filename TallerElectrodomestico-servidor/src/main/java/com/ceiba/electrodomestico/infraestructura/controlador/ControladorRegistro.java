package com.ceiba.electrodomestico.infraestructura.controlador;

import com.ceiba.electrodomestico.aplicacion.comando.ComandoRegistro;
import com.ceiba.electrodomestico.aplicacion.manejador.registro.ManejadorActualizarRegistroParaEntrega;
import com.ceiba.electrodomestico.aplicacion.manejador.registro.ManejadorCrearRegistro;
import com.ceiba.electrodomestico.aplicacion.manejador.registro.ManejadorListarRegistro;
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
    @ResponseStatus(HttpStatus.CREATED)
    public void actualizarRegistro(@PathVariable long id, @RequestBody ComandoRegistro comandoRegistro){
        this.manejadorActualizarRegistroParaEntrega.ejecutar(comandoRegistro, id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RegistroDto> listarTodo(){
        return this.manejadorListarRegistro.listarTodo();
    }

    @GetMapping(value = "/entrega")
    @ResponseStatus(HttpStatus.OK)
    public List<RegistroDto> listarListoParaEntrega(){
        return this.manejadorListarRegistro.listarListoParaEntregar();
    }
}
