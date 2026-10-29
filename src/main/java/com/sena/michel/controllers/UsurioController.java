package com.sena.michel.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.michel.dtos.UsuarioDto;
import com.sena.michel.services.UsuarioServices;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping ("/api/usuario")
@RequiredArgsConstructor 
public class UsurioController {

        private final UsuarioServices usuarioServices;
    
    //registrar usuario
    @PostMapping 
    public ResponseEntity<UsuarioDto> guardar(@RequestBody UsuarioDto usuarioDto) {
        UsuarioDto usuarioGuardado = usuarioServices.guardar(usuarioDto);
        return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(usuarioGuardado);

    }
}
