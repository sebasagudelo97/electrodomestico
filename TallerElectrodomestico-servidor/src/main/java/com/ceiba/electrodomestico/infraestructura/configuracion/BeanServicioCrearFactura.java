package com.ceiba.electrodomestico.infraestructura.configuracion;

import com.ceiba.electrodomestico.dominio.puerto.repositorio.RepositorioFactura;
import com.ceiba.electrodomestico.dominio.servicio.factura.ServicioCrearFactura;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioCrearFactura {

    @Bean
    public ServicioCrearFactura servicioCrearFactura(RepositorioFactura repositorioFactura){
        return new ServicioCrearFactura(repositorioFactura);
    }

}
