package com.ceiba.electrodomestico.dominio.servicio.registro;

import com.ceiba.electrodomestico.dominio.modelo.Registro;
import com.ceiba.electrodomestico.dominio.puerto.dao.DaoRegistro;
import com.ceiba.electrodomestico.dominio.puerto.repositorio.RepositorioRegistro;
import com.ceiba.electrodomestico.infraestructura.convertidor.ConvertidorRegistro;
import com.ceiba.electrodomestico.infraestructura.entidad.EntidadRegistro;
import org.springframework.stereotype.Service;

@Service
public class ServicioSalidaAEntregaElectrodomestico {

    private static final boolean CAMBIO_DE_ESTADO = true;
    private final DaoRegistro daoRegistro;
    private final RepositorioRegistro repositorioRegistro;

    public ServicioSalidaAEntregaElectrodomestico(DaoRegistro daoRegistro, RepositorioRegistro repositorioRegistro) {
        this.daoRegistro = daoRegistro;
        this.repositorioRegistro = repositorioRegistro;
    }

    public void actualizarYGuardarRegistro(long id){
        EntidadRegistro entidadRegistro = daoRegistro.consultarRegistrPorId(id);
        entidadRegistro.setEstadoRegistro(CAMBIO_DE_ESTADO);
        Registro registro = ConvertidorRegistro.convertirDeEntidadAModelo(entidadRegistro);
        this.repositorioRegistro.guardar(registro);
    }
}
