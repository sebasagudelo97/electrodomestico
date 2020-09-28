package com.ceiba.electrodomestico.dominio.puerto.dao;

import com.ceiba.electrodomestico.dominio.dto.RegistroDto;

import java.util.List;


public interface DaoRegistro {


    List<RegistroDto> listarRegistro();
    List<RegistroDto> listarRegistroListoParaEntrega();
}
