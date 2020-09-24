package com.ceiba.electrodomestico.dominio.puerto.repositorio;

import com.ceiba.electrodomestico.dominio.modelo.Registro;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioRegistro {

    void guardar(Registro registro);
}
