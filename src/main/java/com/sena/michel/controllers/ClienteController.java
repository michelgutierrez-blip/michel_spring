package com.sena.michel.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.michel.dtos.ClienteDto;
import com.sena.michel.services.ClienteServices;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping("/api/cliente")
@RequiredArgsConstructor    
public class ClienteController {

    private final ClienteServices clienteServices;

    // registrar un nuevo cliente
    @PostMapping("registrar")
    public ResponseEntity<ClienteDto> guardar(@RequestBody ClienteDto clienteDto) {
        ClienteDto clienteGuardado = clienteServices.guardar(clienteDto);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(clienteGuardado);
    }
    
    // Listar todos los clientes
    @PostMapping("/listar")
    public ResponseEntity<List<ClienteDto>> listarTodos() {
        return ResponseEntity.ok(clienteServices.listarTodos());
    }

    // Actualizar cliente
    @PostMapping("/actualizar/{id}")
    public ResponseEntity<ClienteDto> Update(
        @PathVariable Long id,
        @RequestBody ClienteDto clienteDto) {
        ClienteDto clienteActualizado = clienteServices.actualizar(id, clienteDto);
        return ResponseEntity.ok(clienteActualizado);
    }

    // Eliminar cliente
    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        clienteServices.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
