package com.sena.michel.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.michel.models.usuarios.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
