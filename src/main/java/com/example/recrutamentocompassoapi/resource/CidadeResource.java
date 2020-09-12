package com.example.recrutamentocompassoapi.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.recrutamentocompassoapi.event.RecursoCriadoEvent;
import com.example.recrutamentocompassoapi.model.Cidade;
import com.example.recrutamentocompassoapi.model.dto.CidadeDTO;
import com.example.recrutamentocompassoapi.repository.CidadeRepository;
import com.example.recrutamentocompassoapi.repository.filter.CidadeFilter;
import com.example.recrutamentocompassoapi.service.CidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeResource {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private CidadeService cidadeService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	@GetMapping
	public List<Cidade> pesquisar(CidadeFilter cidadeFilter) {
		return cidadeRepository.filtrarCidade(cidadeFilter);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Cidade> buscarPeloCodigo(@PathVariable Long codigo) {
		Cidade cidadeEncontrada = cidadeRepository.findById(codigo).orElse(null);
		
		if (cidadeEncontrada != null) {
			return ResponseEntity.ok(cidadeEncontrada);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<Cidade> criar(@Valid @RequestBody CidadeDTO cidadeDTO, HttpServletResponse response) {
		Cidade cidadeSalva = cidadeService.salvar(cidadeDTO);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, cidadeSalva.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(cidadeSalva);
	}
}
