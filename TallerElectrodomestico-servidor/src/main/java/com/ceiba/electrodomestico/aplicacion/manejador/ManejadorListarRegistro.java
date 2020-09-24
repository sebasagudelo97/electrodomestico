package com.ceiba.electrodomestico.aplicacion.manejador;

import com.ceiba.electrodomestico.dominio.dto.RegistroDto;
import com.ceiba.electrodomestico.dominio.puerto.dao.DaoRegistro;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarRegistro {

    private final DaoRegistro daoRegistro;

    public ManejadorListarRegistro(DaoRegistro daoRegistro) {
        this.daoRegistro = daoRegistro;
    }

    public List<RegistroDto> ejecutar(){
       return this.daoRegistro.listarRegistro();
    }
}