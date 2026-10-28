package com.sena.michel.mappers;

import org.springframework.stereotype.Component;

import com.sena.michel.dtos.ClienteDto;
import com.sena.michel.models.usuarios.Cliente;

@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override 
    public ClienteDto toDto(Cliente cliente) {
        //Validar que tenga datos
        if (cliente == null) {
            return null;
        }

        //Convertir de cleinte a clienteDto
        return ClienteDto.builder()
        //atributos de ususaio
        .id(cliente.getId())
        .nomb(cliente.getNom())
        .apell(cliente.getApe())
        .direc(cliente.getDir())

        //atributos de cliente
        .tipCli(cliente.getTipo_Cliente())
        .pts(cliente.getPuntos())
        .build();

    }

    @Override
    public Cliente toEntity(ClienteDto clienteDto) {
        //Validar que tenga datos
        if (clienteDto == null) {
            return null;
        }

            return Cliente.builder();
        }

    }

}
