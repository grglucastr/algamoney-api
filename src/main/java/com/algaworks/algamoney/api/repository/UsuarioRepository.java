package com.algaworks.algamoney.api.repository;

import com.algaworks.algamoney.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository
extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);
}
