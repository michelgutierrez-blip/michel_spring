package com.sena.michel.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.michel.models.usuarios.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
