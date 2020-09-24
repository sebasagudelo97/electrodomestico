package com.ceiba.electrodomestico.infraestructura.convertidor;

import com.ceiba.electrodomestico.dominio.dto.RegistroDto;
import com.ceiba.electrodomestico.dominio.modelo.Registro;
import com.ceiba.electrodomestico.dominio.modelo.TipoElectrodomestico;
import com.ceiba.electrodomestico.infraestructura.entidad.EntidadRegistro;
import org.modelmapper.ModelMapper;

import java.util.List;

public final class ConvertidorRegistro {


    private ConvertidorRegistro() {}

    public static Registro convertirDeEntidadAModelo(EntidadRegistro entidadRegistro){
        TipoElectrodomestico tipoElectrodomestico = ConvertidorTipoElectrodomestico.convertirDeEntidadAModelo(entidadRegistro.getEntidadTipoElectrodomestico());
        return new Registro(entidadRegistro.getId(), entidadRegistro.getNombreCliente(),entidadRegistro.getCedulaCliente(),tipoElectrodomestico,entidadRegistro.getFechaIngreso(),entidadRegistro.getFechaSalida(),entidadRegistro.isEstadoRegistro(),entidadRegistro.getTelefono(),entidadRegistro.getValorPagar());
    }

    public static List<RegistroDto> convertirListaRegistroEntidadADto(List<EntidadRegistro> listaEntidadRegistro, List<RegistroDto> listaRegistroDto){
        ModelMapper modelMapper = new ModelMapper();
        listaEntidadRegistro.forEach(temporal -> {
            RegistroDto registroDto = modelMapper.map(temporal, RegistroDto.class);
            listaRegistroDto.add(registroDto);
        });
        return listaRegistroDto;
    }
}
