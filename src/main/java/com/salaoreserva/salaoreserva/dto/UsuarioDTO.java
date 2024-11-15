package com.salaoreserva.salaoreserva.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

	@NotBlank(message = "O nome é obrigatório")
	private String nome;
	
	@Email(message = "E-mail inválido")
	@NotBlank(message = "O e-mail é obrigatório")
	private String email;
	
	@NotBlank(message = "O telefone é obrigatório")
	private String telefone;
	
	@NotBlank(message = "A unidade é obrigatória")
	private String unidade;
	
	@NotBlank(message = "O username é obrigatório")
	private String username;
	
	@Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres")
	@NotBlank(message = "A senha é obrigatória")
	private String password;
}
