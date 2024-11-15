package com.salaoreserva.salaoreserva.dto;

import com.salaoreserva.salaoreserva.model.Morador;
import com.salaoreserva.salaoreserva.model.Salao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservaDTO {
	
	private String data;
	private String tipoSalao;
	private Morador morador;
	private Salao salao;
}
