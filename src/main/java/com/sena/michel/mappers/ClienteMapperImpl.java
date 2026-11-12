package com.sena.michel.mappers;

import org.springframework.stereotype.Component;

import com.sena.michel.dtos.ClienteDto;
import com.sena.michel.dtos.ClienteDtoResponse;
import com.sena.michel.models.usuarios.Cliente;

@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public ClienteDtoResponse toDto(Cliente cliente) {
        // Validar que tenga datos
        if (cliente == null) {
            return null;
        }

        // Convertir de cliente a clienteDto
        return ClienteDtoResponse.builder()
                // atributos de ususaio
                .id(cliente.getId())
                .nomb(cliente.getNom())
                .apell(cliente.getApe())
                .direc(cliente.getDir())
                .tele(cliente.getTel())

                // atributos de cliente

                .tipCli(cliente.getTipoCliente().getNom_TipoCli())
                .pts(cliente.getPuntos())
                .build();

    }

    @Override
    public Cliente toEntity(ClienteDto clienteDto) {
        // Validar que tenga datos
        if (clienteDto == null) {
            return null;
        }

        return Cliente.builder()
                // Atributos de usuariodto
                .id(clienteDto.getId())
                .nom(clienteDto.getNomb())
                .ape(clienteDto.getApell())
                .dir(clienteDto.getDirec())
                .tel(clienteDto.getTele())
                // Atributos de cliente)
                .puntos(clienteDto.getPts())
                .build();

    }

}
