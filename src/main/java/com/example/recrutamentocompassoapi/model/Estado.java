package com.example.recrutamentocompassoapi.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Estado")
@Getter
@Setter
@AllArgsConstructor
public class Estado {

	
	@NotNull
	@Size(max = 2)
	private String uf;
	
	@NotNull
	@Size(max = 100)
	private String nome;

}
