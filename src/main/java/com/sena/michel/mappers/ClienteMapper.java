package com.sena.michel.mappers;

import com.sena.michel.dtos.ClienteDto;
import com.sena.michel.models.usuarios.Cliente;

public interface ClienteMapper {

    // De cliente a ClienteDto
    ClienteDto toDto(Cliente cliente);

    // De ClienteDto a cliente
    Cliente toEntity(ClienteDto clienteDto);
}
