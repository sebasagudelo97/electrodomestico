package com.ceiba.electrodomestico.dominio.puerto.dao;

import com.ceiba.electrodomestico.dominio.dto.RegistroDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DaoRegistro {


    List<RegistroDto> listarRegistro();
    List<RegistroDto> listarRegistroListoParaEntrega();
}
