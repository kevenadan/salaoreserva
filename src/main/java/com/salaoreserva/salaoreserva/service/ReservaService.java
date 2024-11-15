package com.salaoreserva.salaoreserva.service;

import java.time.LocalDate;
import java.util.List;

import com.salaoreserva.salaoreserva.model.Reserva;

public interface ReservaService {

	public List<Reserva> buscarTodasReservas();
	
	public List<Reserva> buscarReservasPordia(LocalDate data);
}
