package com.sena.michel.services;

import java.util.List;

import com.sena.michel.dtos.ClienteDto;
import com.sena.michel.dtos.ClienteDtoResponse;

public interface ClienteServices {
    // registrar un nuevo cliente
    ClienteDtoResponse guardar(ClienteDto clienteDto);

    // listar todos los clientes
    List<ClienteDtoResponse> listarTodos();

    // consultar cliente por id
    ClienteDtoResponse consultarPorId(Long id);

    // actualizar cliente
    ClienteDtoResponse actualizar(Long id, ClienteDto clienteDto);

    // eliminar cliente
    void eliminar(Long id);

}
