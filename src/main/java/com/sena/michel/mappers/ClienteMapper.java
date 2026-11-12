package com.sena.michel.mappers;

import com.sena.michel.dtos.ClienteDto;
import com.sena.michel.dtos.ClienteDtoResponse;
import com.sena.michel.models.usuarios.Cliente;


public interface ClienteMapper  {

    // De cliente a ClienteDto
    Cliente toEntity(ClienteDto clienteDto);
    


    // De ClienteDto a cliente
    ClienteDtoResponse toDto(Cliente cliente);
}
