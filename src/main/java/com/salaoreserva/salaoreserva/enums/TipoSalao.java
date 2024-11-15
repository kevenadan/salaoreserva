package com.salaoreserva.salaoreserva.enums;

public enum TipoSalao {
	FESTAS("FESTAS"),
	REUNIOES("REUNIOES"),
	JOGOS("JOGOS");
	
	private final String nome;
	
	TipoSalao(String nome){
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}
