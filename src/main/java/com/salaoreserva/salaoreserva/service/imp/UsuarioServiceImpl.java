package com.salaoreserva.salaoreserva.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.salaoreserva.salaoreserva.dto.UsuarioDTO;
import com.salaoreserva.salaoreserva.enums.Role;
import com.salaoreserva.salaoreserva.model.Morador;
import com.salaoreserva.salaoreserva.model.Usuario;
import com.salaoreserva.salaoreserva.repository.MoradorRepository;
import com.salaoreserva.salaoreserva.repository.UsuarioRepository;
import com.salaoreserva.salaoreserva.service.UsuarioService;

import jakarta.transaction.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private MoradorRepository moradorRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void salvarUsuario(UsuarioDTO usuarioDTO) {
		
		Morador morador = Morador.builder()
		        .nome(usuarioDTO.getNome())
		        .email(usuarioDTO.getEmail())
		        .username(usuarioDTO.getUsername())
		        .password(passwordEncoder.encode(usuarioDTO.getPassword()))
		        .role(Role.ROLE_USER)
		        .unidade(usuarioDTO.getUnidade())
		        .telefone(usuarioDTO.getTelefone())
		        .build();
		
		moradorRepository.save(morador);
				
	}

	@Override
	public Usuario buscarPorUsername(String username) {
		
		return null;
	}
}
