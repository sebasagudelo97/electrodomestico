package com.ceiba.electrodomestico.aplicacion.manejador.tipoelectrodomestico;

import com.ceiba.electrodomestico.dominio.dto.TipoElectrodomesticoDto;
import com.ceiba.electrodomestico.dominio.puerto.dao.DaoTipoElectrodomestico;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarTipoElectrodomestico {

    private final DaoTipoElectrodomestico daoTipoElectrodomestico;

    public ManejadorListarTipoElectrodomestico(DaoTipoElectrodomestico daoTipoElectrodomestico) {
        this.daoTipoElectrodomestico = daoTipoElectrodomestico;
    }

    public List<TipoElectrodomesticoDto> listarTodo(){
        return this.daoTipoElectrodomestico.listarTipoElectrodomestico();
    }
}
