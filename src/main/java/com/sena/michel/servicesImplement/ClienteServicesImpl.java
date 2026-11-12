package com.sena.michel.servicesImplement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sena.michel.dtos.ClienteDto;
import com.sena.michel.dtos.ClienteDtoResponse;
import com.sena.michel.mappers.ClienteMapper;
import com.sena.michel.models.usuarios.Cliente;
import com.sena.michel.models.usuarios.TiposCliente;
import com.sena.michel.repositoryes.ClienteRepository;
import com.sena.michel.repositoryes.TipoClienteRepository;
import com.sena.michel.services.ClienteServices;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServicesImpl implements ClienteServices {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;
    private final TipoClienteRepository ticlirepo;

    @Override
    public ClienteDtoResponse guardar(ClienteDto clienteDto) {
        // 1. busar id de tipocliente en base de datos
        TiposCliente tipo = ticlirepo.findById(clienteDto.getTipCli())
                .orElseThrow(() -> new EntityNotFoundException("Tipo de cliente no encontrado con"));

        // 2. convierte DTO en Entidad
        Cliente cliente = clienteMapper.toEntity(clienteDto);

        // 3. el ID del cliente debe ser nul porque es autoincrementable
        cliente.setId(null);

        // 4. asignar tipocliente "id"
        cliente.setTipoCliente(tipo);

        // 5. guardar cliente en base de datos
        Cliente clienteGuardado = clienteRepository.save(cliente);
        return clienteMapper.toDto(clienteGuardado);
    }

    @Override
    public List<ClienteDtoResponse> listarTodos() {
        return clienteRepository.findAll().stream()
                .map(clienteMapper::toDto)
                .toList();
    }

    @Override
    public ClienteDtoResponse consultarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con id: " + id));
        return clienteMapper.toDto(cliente);
    }

    @Override
    public ClienteDtoResponse actualizar(Long id, ClienteDto clienteDto) {
        Cliente clienteEncontrado = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con id: " + id));

        // Actualizar datos
        clienteEncontrado.setNom(clienteDto.getNomb());
        clienteEncontrado.setApe(clienteDto.getApell());
        clienteEncontrado.setDir(clienteDto.getDirec());
        clienteEncontrado.setTel(clienteDto.getTele());
        clienteEncontrado.setTipoCliente(ticlirepo.findById(clienteDto.getTipCli())
                .orElseThrow(() -> new EntityNotFoundException(
                        "no se encuentra tipo de cliente " + clienteDto.getTipCli())));
        clienteEncontrado.setPuntos(clienteDto.getPts());

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
