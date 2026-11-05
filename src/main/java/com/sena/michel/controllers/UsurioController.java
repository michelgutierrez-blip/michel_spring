package com.sena.michel.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.michel.dtos.UsuarioDto;
import com.sena.michel.services.UsuarioServices;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
public class UsurioController {

    private final UsuarioServices usuarioServices;

    // registrar usuario
    @PostMapping
    public ResponseEntity<UsuarioDto> guardar(@RequestBody UsuarioDto usuarioDto) {
        UsuarioDto usuarioGuardado = usuarioServices.guardar(usuarioDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(usuarioGuardado);

    }

    // Listar todos los usuarios
    @GetMapping
    public ResponseEntity<List<UsuarioDto>> listarTodos() {
        return ResponseEntity.ok(usuarioServices.listarTodos());
    }

    // Listar todos los usuarios
    @PostMapping("/todos")
    public ResponseEntity<List<UsuarioDto>> listarTodos2() {
        return ResponseEntity.ok(usuarioServices.listarTodos());
    }

    // Consultar por Post
    @PostMapping("/buscar")
    public ResponseEntity<UsuarioDto> consultarPorIdPost(@RequestBody UsuarioDto usuarioDto) {
        UsuarioDto encontrado = usuarioServices.consultarPorId(usuarioDto.getId());
        return ResponseEntity.ok(encontrado);
    }

    // Actualizar usuario
    @PostMapping("/actualizar/{id}")
    public ResponseEntity<UsuarioDto> Update(
            @PathVariable Long id,
            @RequestBody UsuarioDto usuarioDto) {
        UsuarioDto usuarioActualizado = usuarioServices.actualizar(id, usuarioDto);
        return ResponseEntity.ok(usuarioActualizado);
    }

    // Actualizar usuario por post
    @PostMapping("/actualizar")
    public ResponseEntity<UsuarioDto> UpdatePost(
            @RequestBody UsuarioDto usuarioDto) {
        UsuarioDto usuarioActualizado = usuarioServices.actualizar(usuarioDto.getId(), usuarioDto);
        return ResponseEntity.ok(usuarioActualizado);
    }

    // Eliminar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        usuarioServices.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
