package com.ceiba.electrodomestico.infraestructura.configuracion;

import com.ceiba.electrodomestico.dominio.puerto.repositorio.RepositorioRegistro;
import com.ceiba.electrodomestico.dominio.servicio.registro.ServicioCrearRegistro;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioCrearRegistro {

    @Bean
    public ServicioCrearRegistro servicioCrearRegistro(RepositorioRegistro repositorioRegistro){
        return new ServicioCrearRegistro(repositorioRegistro);
    }
}
