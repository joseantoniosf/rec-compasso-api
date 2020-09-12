package com.example.recrutamentocompassoapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Cidade")
@Getter
@Setter
@NoArgsConstructor
public class Cidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotNull
	@Size(max = 100)
	private String nome;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "estado_uf")
	private Estado estado;

	public Cidade(Long codigo, String nome, Estado estado) {
		this.codigo = codigo;
		this.nome = nome;
		this.estado = estado;
	}
}
