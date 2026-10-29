package com.sena.michel.services;

import com.sena.michel.dtos.UsuarioDto;

public interface UsuarioServices {
    // registrar un nuevo usuario
    UsuarioDto guardar(UsuarioDto usuarioDto);

}
