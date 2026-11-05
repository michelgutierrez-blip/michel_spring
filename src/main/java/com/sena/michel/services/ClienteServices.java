package com.sena.michel.services;

import java.util.List;

import com.sena.michel.dtos.ClienteDto;

public interface ClienteServices {
    // registrar un nuevo cliente
    ClienteDto guardar(ClienteDto clienteDto);

    // listar todos los clientes
    List<ClienteDto> listarTodos();

    // consultar cliente por id
    ClienteDto consultarPorId(Long id);

    // actualizar cliente
    ClienteDto actualizar(Long id, ClienteDto clienteDto);

    // eliminar cliente
    void eliminar(Long id);

}
