package com.example.recrutamentocompassoapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.recrutamentocompassoapi.model.Cidade;
import com.example.recrutamentocompassoapi.repository.CidadeRepository;
import com.example.recrutamentocompassoapi.repository.filter.CidadeFilter;

@RestController
@RequestMapping("/cidades")
public class CidadeResource {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@GetMapping
	public List<Cidade> pesquisar(CidadeFilter cidadeFilter) {
		return cidadeRepository.filtrarCidade(cidadeFilter);
	}
}
