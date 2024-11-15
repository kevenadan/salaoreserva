package com.salaoreserva.salaoreserva.service.imp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salaoreserva.salaoreserva.dto.ReservaDTO;
import com.salaoreserva.salaoreserva.model.Reserva;
import com.salaoreserva.salaoreserva.model.Salao;
import com.salaoreserva.salaoreserva.repository.ReservaRepository;
import com.salaoreserva.salaoreserva.repository.SalaoRepository;
import com.salaoreserva.salaoreserva.service.SalaoService;

@Service
public class SalaoServiceImpl implements SalaoService {
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

	@Autowired
	private ReservaRepository reservaRepository;
	
	@Autowired
	private SalaoRepository salaoRepository;

	@Override
	public List<LocalDate> buscarDiasDisponiveis(String tipoSalao) {
		List<LocalDate> reservasOcupadas = reservaRepository.findDiasOcupadosByTipoSalao(tipoSalao);
		List<LocalDate> diasDisponiveis = new ArrayList<>();

		// Disponibiliza os próximos 30 dias, excluindo os já ocupados
		LocalDate hoje = LocalDate.now();
		for (int i = 1; i <= 30; i++) {
			LocalDate dia = hoje.plusDays(i);
			if (reservasOcupadas.stream().noneMatch(reserva -> reserva.equals(dia))) {
				diasDisponiveis.add(dia);
			}
		}
		return diasDisponiveis;
	}

	@Override
	public void salvarReserva(ReservaDTO reservaDTO) {
		
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	    LocalDateTime dataReserva;
	    try {
	        // Converte a data de String para LocalDateTime, assumindo o horário como 00:00
	        LocalDate data = LocalDate.parse(reservaDTO.getData(), formatter);
	        dataReserva = data.atStartOfDay(); // Define o horário como início do dia
	    } catch (DateTimeParseException e) {
	        throw new IllegalArgumentException("Formato de data inválido. Use o formato yyyy-MM-dd", e);
	    }

	    List<LocalDate> diasOcupados = reservaRepository.findDiasOcupadosByTipoSalao(reservaDTO.getTipoSalao());
	    if (diasOcupados.stream()
	            .anyMatch(reserva -> reserva.equals(dataReserva.toLocalDate()))) {
	        throw new IllegalArgumentException("Esse dia já está ocupado para o tipo de salão selecionado.");
	    }

	    Reserva novaReserva = new Reserva();
	    novaReserva.setDataReserva(dataReserva);
	    novaReserva.setMorador(reservaDTO.getMorador());
	    novaReserva.setSalao(reservaDTO.getSalao());
	    novaReserva.setStatus("CONFIRMADA");

	    reservaRepository.save(novaReserva);
	}

	@Override
	public Optional<Salao> buscarPorTipoSalao(String tipoSalao) {
		
		return salaoRepository.findByTipoSalao(tipoSalao);
	}
}
