package com.sena.michel.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.michel.models.usuarios.TiposCliente;

public interface TipoClienteRepository extends JpaRepository<TiposCliente, Byte> {

}
