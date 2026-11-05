package com.sena.michel.servicesImplement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sena.michel.dtos.TrabajadorDto;
import com.sena.michel.mappers.TrabajadorMapper;
import com.sena.michel.models.usuarios.Trabajador;
import com.sena.michel.repositoryes.TrabajadorRepository;
import com.sena.michel.services.TrabajadorServices;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;


@Service 
@RequiredArgsConstructor 
public class TrabajadorServiceImpl implements TrabajadorServices {

    private final TrabajadorRepository trabajadorRepository;
    private final TrabajadorMapper trabajadorMapper;

    @Override
    public TrabajadorDto guardar(TrabajadorDto trabajadorDto) {
        Trabajador trabajador = trabajadorMapper.toEntity(trabajadorDto);
        Trabajador trabajadorGuardado = trabajadorRepository.save(trabajador);
        return trabajadorMapper.toDto(trabajadorGuardado);
    }

    @Override
    public List<TrabajadorDto> listarTodos() {
        return trabajadorRepository.findAll().stream()
                .map(trabajadorMapper::toDto)
                .toList();
    }

    @Override
    public TrabajadorDto consultarPorId(Long id) {
        Trabajador trabajador = trabajadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trabajador no encontrado con id: " + id));
        return trabajadorMapper.toDto(trabajador);
    }

    @Override 
    public TrabajadorDto actualizar(Long id, TrabajadorDto trabajadorDto) {
        Trabajador trabajadorEncontrado = trabajadorRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Trabajador no encontrado con id: " + id));

        // Actualizar datos
        trabajadorEncontrado.setNom(trabajadorDto.getNomb());
        trabajadorEncontrado.setApe(trabajadorDto.getApell());
        trabajadorEncontrado.setDir(trabajadorDto.getDirec());
        trabajadorEncontrado.setTel(trabajadorDto.getTele());
        trabajadorEncontrado.setCargo(trabajadorDto.getCargo());
        trabajadorEncontrado.setSueldo(trabajadorDto.getSueldo());

        Trabajador trabajadorActualizado = trabajadorRepository.save(trabajadorEncontrado);
        return trabajadorMapper.toDto(trabajadorActualizado);
    }

    @Override 
    public void eliminar(Long id) {
    Trabajador trabajador = trabajadorRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Trabajador no encontrado con id: " + id));
        trabajadorRepository.delete(trabajador);
    }
}
