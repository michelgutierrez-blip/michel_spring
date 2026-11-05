package com.sena.michel.services;

import java.util.List;

import com.sena.michel.dtos.TrabajadorDto;

public interface TrabajadorServices {
    // registrar un nuevo trabajador
    TrabajadorDto guardar(TrabajadorDto trabajadorDto);

    // Listar todos los trabajadores
    List<TrabajadorDto> listarTodos();

    // Consultar trabajador por id
    TrabajadorDto consultarPorId(Long id);

    // Actualizar trabajador
    TrabajadorDto actualizar(Long id, TrabajadorDto trabajadorDto);

    // Eliminar trabajador
    void eliminar(Long id);

}
