package com.ceiba.electrodomestico.dominio.puerto.dao;

import com.ceiba.electrodomestico.infraestructura.entidad.EntidadRegistro;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoRegistro {

    EntidadRegistro consultarRegistrPorId(long id);
}
