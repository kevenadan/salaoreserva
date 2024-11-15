package com.salaoreserva.salaoreserva.service;

import com.salaoreserva.salaoreserva.dto.UsuarioDTO;
import com.salaoreserva.salaoreserva.model.Usuario;

public interface UsuarioService {

	public void salvarUsuario(UsuarioDTO usuario);
	
	public Usuario buscarPorUsername(String username);
	
}
