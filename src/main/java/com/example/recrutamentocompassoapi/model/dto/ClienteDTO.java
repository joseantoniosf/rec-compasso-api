package com.example.recrutamentocompassoapi.model.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {

	@NotNull
	@Size(min = 5, max = 100)
    private String nomeCompleto;
    
	@NotNull
	@Size(max = 1)
    private String sexo;
    
	@NotNull
    private Date dataNascimento;
    
    private int idade;
    
	@NotNull
	private Long cidadeCodigo;
	
}
