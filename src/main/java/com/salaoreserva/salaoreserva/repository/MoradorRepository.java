package com.salaoreserva.salaoreserva.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salaoreserva.salaoreserva.model.Morador;
import com.salaoreserva.salaoreserva.model.Usuario;

public interface MoradorRepository extends JpaRepository<Usuario, Long> {
	 Optional<Morador> findByUsername(String username);
}
