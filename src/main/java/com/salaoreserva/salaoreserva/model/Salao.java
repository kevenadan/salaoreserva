package com.salaoreserva.salaoreserva.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Salao")
public class Salao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "capacidade")
	private Integer capacidade;
	
	@Column(name = "horario_abertura")
	private Date horario_abertura;
	
	@Column(name = "tipo_salao", nullable = false)
	private String tipoSalao;
	
	@Column(name = "horario_fechamento")
	private Date horario_fechamento;
	
	@Column(name = "regras")
	private String Regras;
}
