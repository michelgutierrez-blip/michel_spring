package com.sena.michel.servicesImplement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sena.michel.dtos.ClienteDto;
import com.sena.michel.mappers.ClienteMapper;
import com.sena.michel.models.usuarios.Cliente;
import com.sena.michel.repositoryes.ClienteRepository;
import com.sena.michel.services.ClienteServices;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;


@Service 
@RequiredArgsConstructor
public class ClienteServicesImpl implements ClienteServices {
    
    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    @Override
    public ClienteDto guardar(ClienteDto clienteDto) {
    Cliente cliente = clienteMapper.toEntity(clienteDto);
    Cliente clienteGuardado = clienteRepository.save(cliente);
    return clienteMapper.toDto(clienteGuardado);
    }

    @Override
    public List<ClienteDto> listarTodos() {
        return clienteRepository.findAll().stream()
        .map(clienteMapper::toDto)
        .toList();
    }

    @Override
    public ClienteDto consultarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con id: " + id));
        return clienteMapper.toDto(cliente);
    }

    @Override
    public ClienteDto actualizar(Long id, ClienteDto clienteDto) {
        Cliente clienteEncontrado = clienteRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con id: " + id));

        // Actualizar datos
        clienteEncontrado.setNom(clienteDto.getNomb());
        clienteEncontrado.setApe(clienteDto.getApell());
        clienteEncontrado.setDir(clienteDto.getDirec());
        clienteEncontrado.setTel(clienteDto.getTele());
        clienteEncontrado.setTipo_Cliente(clienteDto.getTipCli());
        clienteEncontrado.setPuntos(clienteDto.getPts());

        Cliente clienteActualizado = clienteRepository.save(clienteEncontrado);
        return clienteMapper.toDto(clienteActualizado);
    }

    @Override 
    public void eliminar(Long id) {
        Cliente cliente = clienteRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con id: " + id));
        clienteRepository.delete(cliente);
    }
}
