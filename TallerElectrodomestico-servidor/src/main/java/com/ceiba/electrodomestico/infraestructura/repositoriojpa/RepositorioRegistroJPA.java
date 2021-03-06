package com.ceiba.electrodomestico.infraestructura.repositoriojpa;

import com.ceiba.electrodomestico.infraestructura.entidad.EntidadRegistro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface RepositorioRegistroJPA extends JpaRepository<EntidadRegistro, Serializable> {

    @Query(value = "select * from registro where estado_registro = false", nativeQuery = true)
    List<EntidadRegistro> listarTodoNoEntrega();


    @Query(value = "select * from registro where (estado_registro = true) and (estado_factura = false)", nativeQuery = true)
    List<EntidadRegistro> obtenerRegistrosListoParaEntregar();

    @Query(value = "select * from registro where registro.id =:id", nativeQuery = true)
    EntidadRegistro buscarRegistroPorId(@Param("id") long id);
}
