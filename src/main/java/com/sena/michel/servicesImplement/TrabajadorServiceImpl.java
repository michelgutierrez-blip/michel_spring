package com.sena.michel.servicesImplement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sena.michel.dtos.TrabajadorDto;
import com.sena.michel.dtos.TrabajadorDtoResponse;
import com.sena.michel.mappers.TrabajadorMapper;
import com.sena.michel.models.usuarios.CargosTrabajador;
import com.sena.michel.models.usuarios.Trabajador;
import com.sena.michel.repositoryes.CargoTrabajadorRepository;
import com.sena.michel.repositoryes.TrabajadorRepository;
import com.sena.michel.services.TrabajadorServices;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;


@Service 
@RequiredArgsConstructor 
public class TrabajadorServiceImpl implements TrabajadorServices {

    private final TrabajadorRepository trabajadorRepository;
    private final TrabajadorMapper trabajadorMapper;
    private final CargoTrabajadorRepository cartrarepo;

    @Override
    public TrabajadorDtoResponse guardar(TrabajadorDto trabajadorDto) {
    // 1. buscar id de cargo en base de datos
    CargosTrabajador cargo = cartrarepo.findById(trabajadorDto.getCargo())
        .orElseThrow(() -> new EntityNotFoundException("Cargo no encontrado con id: " + trabajadorDto.getCargo()));

    // 2. convierte DTO en Entidad
    Trabajador trabajador = trabajadorMapper.toEntity(trabajadorDto);

    // 3. el ID del trabajador debe ser nulo porque es autoincrementable
    trabajador.setId(null);

    // 4. asignar cargo "id"
    trabajador.setCarTraba(cargo);

    // 5. guardar trabajador en base de datos
        Trabajador trabajadorGuardado = trabajadorRepository.save(trabajador);
        return trabajadorMapper.toDto(trabajadorGuardado);
    }

    
    @Override
    public List<TrabajadorDtoResponse> listarTodos() {
        return trabajadorRepository.findAll().stream()
                .map(trabajadorMapper::toDto)
                .toList();
    }

    @Override
    public TrabajadorDtoResponse consultarPorId(Long id) {
        Trabajador trabajador = trabajadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trabajador no encontrado con id: " + id));
        return trabajadorMapper.toDto(trabajador);
    }

    @Override 
    public TrabajadorDtoResponse actualizar(Long id, TrabajadorDto trabajadorDto) {
        Trabajador trabajadorEncontrado = trabajadorRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Trabajador no encontrado con id: " + id));

        // Actualizar datos
        trabajadorEncontrado.setNom(trabajadorDto.getNomb());
        trabajadorEncontrado.setApe(trabajadorDto.getApell());
        trabajadorEncontrado.setDir(trabajadorDto.getDirec());
        trabajadorEncontrado.setTel(trabajadorDto.getTele());

        trabajadorEncontrado.setCarTraba(cartrarepo.findById(trabajadorDto.getCargo())
        .orElseThrow(() -> new EntityNotFoundException("Cargo no encontrado" + trabajadorDto.getCargo())));

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
