package com.ceiba.electrodomestico.dominio.puerto.dao;

import com.ceiba.electrodomestico.dominio.dto.RegistroDto;
import com.ceiba.electrodomestico.infraestructura.entidad.EntidadRegistro;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DaoRegistro {

    EntidadRegistro consultarRegistrPorId(long id);
    List<RegistroDto> listarRegistro();
    List<RegistroDto> listarRegistroListoParaEntrega();
}
