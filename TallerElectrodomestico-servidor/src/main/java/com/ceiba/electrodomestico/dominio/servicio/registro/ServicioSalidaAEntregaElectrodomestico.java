package com.ceiba.electrodomestico.dominio.servicio.registro;

import com.ceiba.electrodomestico.dominio.modelo.Registro;
import com.ceiba.electrodomestico.dominio.puerto.dao.DaoRegistro;
import com.ceiba.electrodomestico.dominio.puerto.repositorio.RepositorioRegistro;
import org.springframework.stereotype.Service;

@Service
public class ServicioSalidaAEntregaElectrodomestico {


    private final DaoRegistro daoRegistro;
    private final RepositorioRegistro repositorioRegistro;

    public ServicioSalidaAEntregaElectrodomestico(DaoRegistro daoRegistro, RepositorioRegistro repositorioRegistro) {
        this.daoRegistro = daoRegistro;
        this.repositorioRegistro = repositorioRegistro;
    }

    public void actualizarYGuardarRegistro(Registro registro){
        this.repositorioRegistro.guardar(registro);
    }
}
