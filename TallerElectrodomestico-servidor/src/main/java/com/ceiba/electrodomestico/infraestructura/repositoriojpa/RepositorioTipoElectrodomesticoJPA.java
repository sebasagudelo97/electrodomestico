package com.ceiba.electrodomestico.infraestructura.repositoriojpa;

import com.ceiba.electrodomestico.infraestructura.entidad.EntidadTipoElectrodomestico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface RepositorioTipoElectrodomesticoJPA extends JpaRepository<EntidadTipoElectrodomestico, Serializable> {
}
