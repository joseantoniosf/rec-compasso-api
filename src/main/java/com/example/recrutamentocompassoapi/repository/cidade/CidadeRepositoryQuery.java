package com.example.recrutamentocompassoapi.repository.cidade;

import java.util.List;

import com.example.recrutamentocompassoapi.model.Cidade;
import com.example.recrutamentocompassoapi.repository.filter.CidadeFilter;

public interface CidadeRepositoryQuery {

	public List<Cidade> filtrarCidade(CidadeFilter cidadeFilter);
	
}
