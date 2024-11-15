package com.salaoreserva.salaoreserva.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@ToString
@SuperBuilder 
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Morador")
public class Morador extends Usuario {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "unidade")
	private String unidade;
	
	@Column(name = "telefone")
	private String telefone;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "morador", cascade = CascadeType.ALL)
	private List<Reserva> reservas;
	
}
