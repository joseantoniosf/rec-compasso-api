package com.example.recrutamentocompassoapi.model;

import java.util.Date;

import javax.persistence.Column;
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
@Table(name = "Cliente")
@Getter
@Setter
@NoArgsConstructor
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    
	@NotNull
	@Size(min = 5, max = 100)
	@Column(name = "nome_completo")
    private String nomeCompleto;
    
	@NotNull
	@Size(max = 1)
    private String sexo;
    
	@NotNull
	@Column(name = "data_nasc")
    private Date dataNascimento;
    
    private int idade;
    
	@NotNull
	@ManyToOne
	@JoinColumn(name = "cidade_codigo")
    private Cidade cidade;
	
	
	public Cliente(Long codigo, String nomeCompleto, String sexo, Date dataNascimento,
			int idade, Cidade cidade) {
		this.codigo = codigo;
		this.nomeCompleto = nomeCompleto;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.idade = idade;
		this.cidade = cidade;
	}
}
