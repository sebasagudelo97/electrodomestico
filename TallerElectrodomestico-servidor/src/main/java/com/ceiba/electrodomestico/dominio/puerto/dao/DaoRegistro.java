package com.ceiba.electrodomestico.dominio.puerto.dao;

import com.ceiba.electrodomestico.dominio.dto.RegistroDto;
import com.ceiba.electrodomestico.infraestructura.entidad.EntidadRegistro;

import java.util.List;


public interface DaoRegistro {


    List<RegistroDto> listarRegistro();
    EntidadRegistro buscarPorId(long id);
    List<RegistroDto> listarRegistroListoParaEntrega();
}
