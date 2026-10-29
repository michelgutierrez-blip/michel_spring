package com.sena.michel.servicesImplement;

import org.springframework.stereotype.Service;

import com.sena.michel.dtos.UsuarioDto;
import com.sena.michel.mappers.UsuarioMapper;
import com.sena.michel.models.usuarios.Usuario;
import com.sena.michel.repositoryes.UsuarioRepository;
import com.sena.michel.services.UsuarioServices;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@Service
@RequiredArgsConstructor
public class UsuarioServicesImpl implements UsuarioServices {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public UsuarioDto guardar(UsuarioDto usuarioDto) {
        Usuario usuario = usuarioMapper.convierteaEntidad(usuarioDto);
        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        return usuarioMapper.convierteaDto(usuarioGuardado);
    }
}
