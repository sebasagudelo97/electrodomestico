package com.ceiba.electrodomestico.dominio.servicio.registro;

import com.ceiba.electrodomestico.dominio.modelo.Registro;
import com.ceiba.electrodomestico.dominio.puerto.repositorio.RepositorioRegistro;
import org.springframework.stereotype.Service;

@Service
public class ServicioCrearRegistro {

    private RepositorioRegistro repositorioRegistro;

    public ServicioCrearRegistro(RepositorioRegistro repositorioRegistro) {
        this.repositorioRegistro = repositorioRegistro;
    }

    public void ejecutar(Registro registro){
        this.repositorioRegistro.guardar(registro);
    }
}
