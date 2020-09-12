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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Cliente")
@Getter
@Setter
@AllArgsConstructor
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
    private Date data_nasc;
    
	@Size(max = 3)
    private int idade;
    
	@NotNull
	@ManyToOne
	@JoinColumn(name = "cidade_codigo")
    private Cidade cidade;
}
