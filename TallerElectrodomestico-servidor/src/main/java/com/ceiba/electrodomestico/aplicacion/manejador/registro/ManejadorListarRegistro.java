package com.ceiba.electrodomestico.aplicacion.manejador.registro;

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

    public List<RegistroDto> listarTodo(){
       return this.daoRegistro.listarRegistro();
    }

    public List<RegistroDto> listarListoParaEntregar(){
        return this.daoRegistro.listarRegistroListoParaEntrega();
    }
}
