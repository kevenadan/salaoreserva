package com.salaoreserva.salaoreserva.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salaoreserva.salaoreserva.model.Salao;

public interface SalaoRepository  extends JpaRepository<Salao, Long>{

	Optional<Salao> findByTipoSalao(String tipoSalao);
}
