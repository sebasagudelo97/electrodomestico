package com.ceiba.electrodomestico.infraestructura.configuracion;

import com.ceiba.electrodomestico.dominio.puerto.dao.DaoRegistro;
import com.ceiba.electrodomestico.dominio.servicio.factura.ServicioEstadoDeFactura;
import com.ceiba.electrodomestico.infraestructura.repositoriojpa.RepositorioRegistroJPA;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioEstadoDeFactura {

    public ServicioEstadoDeFactura servicioEstadoDeFactura(DaoRegistro daoRegistro, RepositorioRegistroJPA repositorioRegistroJPA){
        return new ServicioEstadoDeFactura(daoRegistro, repositorioRegistroJPA);
    }
}
