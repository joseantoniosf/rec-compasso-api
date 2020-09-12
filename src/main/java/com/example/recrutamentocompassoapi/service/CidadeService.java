package com.example.recrutamentocompassoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.recrutamentocompassoapi.model.Cidade;
import com.example.recrutamentocompassoapi.model.Estado;
import com.example.recrutamentocompassoapi.model.dto.CidadeDTO;
import com.example.recrutamentocompassoapi.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	public Cidade salvar(CidadeDTO cidadeDTO) {
		Cidade cidadeNova = new Cidade();
		cidadeNova.setNome(cidadeDTO.getNome());
		cidadeNova.setEstado(new Estado(cidadeDTO.getEstado()));
		
		return cidadeRepository.save(cidadeNova);
	}
	
}
