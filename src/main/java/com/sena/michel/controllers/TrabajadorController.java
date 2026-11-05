package com.sena.michel.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.michel.dtos.TrabajadorDto;
import com.sena.michel.services.TrabajadorServices;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping ("/api/trabajador")
@RequiredArgsConstructor 
public class TrabajadorController {

    private final TrabajadorServices trabajadorServices;

    // registrar trabajador
    @PostMapping("registrar")
    public ResponseEntity<TrabajadorDto> guardar(@RequestBody TrabajadorDto trabajadorDto) {
        TrabajadorDto trabajadorGuardado = trabajadorServices.guardar(trabajadorDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(trabajadorGuardado);
    }

    // Listar todos los trabajadores
    @PostMapping("/traba")
    public ResponseEntity<List<TrabajadorDto>> listarTodos() {
        return ResponseEntity.ok(trabajadorServices.listarTodos());
    }

    // Actualizar trabajador
    @PostMapping("/actualizar")
    public ResponseEntity<TrabajadorDto> UpdatePost(
        @RequestBody TrabajadorDto trabajadorDto) {
        TrabajadorDto trabajadorActualizado = trabajadorServices.actualizar(trabajadorDto.getId(), trabajadorDto);
        return ResponseEntity.ok(trabajadorActualizado);
    }

    // Eliminar trabajador
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        trabajadorServices.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
