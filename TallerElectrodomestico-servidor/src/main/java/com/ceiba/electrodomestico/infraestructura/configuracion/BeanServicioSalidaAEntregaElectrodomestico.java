package com.ceiba.electrodomestico.infraestructura.configuracion;

import com.ceiba.electrodomestico.dominio.puerto.repositorio.RepositorioRegistro;
import com.ceiba.electrodomestico.dominio.servicio.registro.ServicioSalidaAEntregaElectrodomestico;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioSalidaAEntregaElectrodomestico {

    @Bean
    public ServicioSalidaAEntregaElectrodomestico servicioSalidaAEntregaElectrodomestico(RepositorioRegistro repositorioRegistro){
        return new ServicioSalidaAEntregaElectrodomestico(repositorioRegistro);
    }
}
