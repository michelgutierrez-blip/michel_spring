package com.sena.michel.services;

import java.util.List;

import com.sena.michel.dtos.TrabajadorDto;
import com.sena.michel.dtos.TrabajadorDtoResponse;

public interface TrabajadorServices {
    // registrar un nuevo trabajador
    TrabajadorDtoResponse guardar(TrabajadorDto trabajadorDto);

    // Listar todos los trabajadores
    List<TrabajadorDtoResponse> listarTodos();

    // Consultar trabajador por id
    TrabajadorDtoResponse consultarPorId(Long id);

    // Actualizar trabajador
    TrabajadorDtoResponse actualizar(Long id, TrabajadorDto trabajadorDto);

    // Eliminar trabajador
    void eliminar(Long id);
 
}
