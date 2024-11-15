package com.salaoreserva.salaoreserva.service.imp;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salaoreserva.salaoreserva.model.Reserva;
import com.salaoreserva.salaoreserva.repository.ReservaRepository;
import com.salaoreserva.salaoreserva.service.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService {
	
	@Autowired
	private ReservaRepository reservaRepository;

	@Override
	public List<Reserva> buscarTodasReservas() {
		return reservaRepository.findAll();
	}

	@Override
	public List<Reserva> buscarReservasPordia(LocalDate data) {
		return reservaRepository.findByDataReserva(data);
	}

}
