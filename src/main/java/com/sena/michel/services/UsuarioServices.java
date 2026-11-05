package com.sena.michel.services;

import java.util.List;

import com.sena.michel.dtos.UsuarioDto;

public interface UsuarioServices {
    // registrar un nuevo usuario
    UsuarioDto guardar(UsuarioDto usuarioDto);

    // Listar todos los usuarios
    List<UsuarioDto> listarTodos();

    // Consultar usuario por id
    UsuarioDto consultarPorId(Long id);

    // Actualizar usuario
    UsuarioDto actualizar(Long id, UsuarioDto usuarioDto);

    // Eliminar usuario
    void eliminar(Long id);
}
