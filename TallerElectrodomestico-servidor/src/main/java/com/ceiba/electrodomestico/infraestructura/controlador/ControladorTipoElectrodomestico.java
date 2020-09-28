package com.ceiba.electrodomestico.infraestructura.controlador;

import com.ceiba.electrodomestico.aplicacion.manejador.tipoelectrodomestico.ManejadorListarTipoElectrodomestico;
import com.ceiba.electrodomestico.dominio.dto.TipoElectrodomesticoDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/tipo-electrodomestico")
public class ControladorTipoElectrodomestico {

    private final ManejadorListarTipoElectrodomestico manejadorListarTipoElectrodomestico;

    public ControladorTipoElectrodomestico(ManejadorListarTipoElectrodomestico manejadorListarTipoElectrodomestico) {
        this.manejadorListarTipoElectrodomestico = manejadorListarTipoElectrodomestico;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TipoElectrodomesticoDto> listarTodo(){
        return this.manejadorListarTipoElectrodomestico.listarTodo();
    }
}
