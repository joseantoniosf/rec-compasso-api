package com.example.recrutamentocompassoapi.model.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeDTO {
	
	@NotNull
	@Size(min = 3, max = 100)
	private String nome;
	
	@NotNull
	@Size(max = 2)
	private String estado;
	
}
