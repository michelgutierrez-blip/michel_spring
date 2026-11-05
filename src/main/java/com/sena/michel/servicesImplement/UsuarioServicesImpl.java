package com.sena.michel.servicesImplement;

import java.util.List;

import org.springframework.stereotype.Service;
import com.sena.michel.dtos.UsuarioDto;
import com.sena.michel.mappers.UsuarioMapper;
import com.sena.michel.models.usuarios.Usuario;
import com.sena.michel.repositoryes.UsuarioRepository;
import com.sena.michel.services.UsuarioServices;

import jakarta.persistence.EntityNotFoundException;


import lombok.RequiredArgsConstructor;


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

    @Override 
    public List<UsuarioDto> listarTodos() {
        return usuarioRepository.findAll().stream()
                .map(usuarioMapper::convierteaDto)
                .toList();
    }

    @Override
    public UsuarioDto consultarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con id: " + id));
        return usuarioMapper.convierteaDto(usuario);
    }

    @Override
    public UsuarioDto actualizar(Long id, UsuarioDto usuarioDto) {
        Usuario usuarioEncontrado = usuarioRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con id: " + id));

        // Actualizar datos 
        usuarioEncontrado.setNom(usuarioDto.getNomb());
        usuarioEncontrado.setApe(usuarioDto.getApell());
        usuarioEncontrado.setDir(usuarioDto.getDirec());
        usuarioEncontrado.setTel(usuarioDto.getTele());

        Usuario usuarioActualizado = usuarioRepository.save(usuarioEncontrado);
        return usuarioMapper.convierteaDto(usuarioActualizado);
    }

    @Override
    public void eliminar(Long id) {
        Usuario usuarioEncontrado = usuarioRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con id: " + id));
        usuarioRepository.delete(usuarioEncontrado);
    }
}
