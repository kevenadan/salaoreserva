package com.salaoreserva.salaoreserva.service;

import java.util.Optional;

import com.salaoreserva.salaoreserva.model.Morador;

public interface MoradorService {

	public Optional<Morador> buscarPorUsername(String username);
}
