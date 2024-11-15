package com.salaoreserva.salaoreserva.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.salaoreserva.salaoreserva.dto.ReservaDTO;
import com.salaoreserva.salaoreserva.model.Salao;

public interface SalaoService {

	void salvarReserva(ReservaDTO reservaDTO);

	List<LocalDate> buscarDiasDisponiveis(String tipoSalao);
	
	Optional<Salao> buscarPorTipoSalao(String tipoSalao);
	
}
