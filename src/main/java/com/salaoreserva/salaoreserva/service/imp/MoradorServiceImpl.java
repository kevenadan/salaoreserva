package com.salaoreserva.salaoreserva.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salaoreserva.salaoreserva.model.Morador;
import com.salaoreserva.salaoreserva.repository.MoradorRepository;
import com.salaoreserva.salaoreserva.service.MoradorService;

@Service
public class MoradorServiceImpl implements MoradorService{
	
	@Autowired
	private MoradorRepository moradorRepository;

	@Override
	public Optional<Morador> buscarPorUsername(String username) {
		
		return moradorRepository.findByUsername(username);
	}

}
