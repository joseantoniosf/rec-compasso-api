package com.example.recrutamentocompassoapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Estado")
@Getter
@Setter
@NoArgsConstructor
public class Estado {

	@Id
	@Size(max = 2)
	private String uf;
	
	@NotNull
	@Size(max = 100)
	private String nome;

	
	public Estado(String uf) {
		this.uf = uf;
	}
}
