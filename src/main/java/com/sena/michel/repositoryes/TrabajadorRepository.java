package com.sena.michel.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.michel.models.usuarios.Trabajador;

public interface TrabajadorRepository extends JpaRepository<Trabajador, Long> {

}
