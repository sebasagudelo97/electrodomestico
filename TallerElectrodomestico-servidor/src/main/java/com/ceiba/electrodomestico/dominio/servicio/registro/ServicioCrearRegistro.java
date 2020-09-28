package com.ceiba.electrodomestico.dominio.servicio.registro;

import com.ceiba.electrodomestico.dominio.modelo.Registro;
import com.ceiba.electrodomestico.dominio.puerto.repositorio.RepositorioRegistro;

public class ServicioCrearRegistro {

    private final RepositorioRegistro repositorioRegistro;

    public ServicioCrearRegistro(RepositorioRegistro repositorioRegistro) {
        this.repositorioRegistro = repositorioRegistro;
    }

    public void ejecutar(Registro registro){
        this.repositorioRegistro.guardar(registro);
    }
}
