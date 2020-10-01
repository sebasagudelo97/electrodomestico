package com.ceiba.electrodomestico.infraestructura.convertidor;

import com.ceiba.electrodomestico.dominio.dto.RegistroDto;
import com.ceiba.electrodomestico.dominio.modelo.Registro;
import com.ceiba.electrodomestico.infraestructura.entidad.EntidadRegistro;
import com.ceiba.electrodomestico.infraestructura.entidad.EntidadTipoElectrodomestico;
import org.dom4j.rule.Mode;
import org.modelmapper.ModelMapper;

import java.util.List;

public final class ConvertidorRegistro {


    private ConvertidorRegistro() {}


    public static RegistroDto convertirDeEntidadAModelo(EntidadRegistro entidadRegistro){
        ModelMapper modelMapper = new ModelMapper();
        RegistroDto registroDto = modelMapper.map(entidadRegistro, RegistroDto.class);
        registroDto.setTipoElectrodomestico(ConvertidorTipoElectrodomestico.convertirDeEntidadAModelo(entidadRegistro.getEntidadTipoElectrodomestico()));
        return registroDto;
    }

    public static EntidadRegistro convertirDeModeloAEntidad(Registro registro){
        ModelMapper modelMapper = new ModelMapper();
        EntidadTipoElectrodomestico entidadTipoElectrodomestico = modelMapper.map(registro, EntidadTipoElectrodomestico.class);
        return new EntidadRegistro(registro.getId(),registro.getNombreCliente(),registro.getCedulaCliente(),entidadTipoElectrodomestico,registro.getFechaIngreso(),registro.getFechaSalida(), registro.isEstadoFactura(),  registro.isEstadoRegistro(),registro.getTelefono(),registro.getValorPagar());
    }

    public static List<RegistroDto> convertirListaRegistroEntidadADto(List<EntidadRegistro> listaEntidadRegistro, List<RegistroDto> listaRegistroDto){
        ModelMapper modelMapper = new ModelMapper();
        listaEntidadRegistro.forEach(temporal -> {
            RegistroDto registroDto = modelMapper.map(temporal, RegistroDto.class);
            registroDto.setTipoElectrodomestico(ConvertidorTipoElectrodomestico.convertirDeEntidadAModelo(temporal.getEntidadTipoElectrodomestico()));
            listaRegistroDto.add(registroDto);
        });
        return listaRegistroDto;
    }
}
