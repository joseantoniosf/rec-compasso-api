package com.example.recrutamentocompassoapi.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.recrutamentocompassoapi.event.RecursoCriadoEvent;
import com.example.recrutamentocompassoapi.model.Cliente;
import com.example.recrutamentocompassoapi.model.dto.ClienteDTO;
import com.example.recrutamentocompassoapi.repository.ClienteRepository;
import com.example.recrutamentocompassoapi.repository.filter.ClienteFilter;
import com.example.recrutamentocompassoapi.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Cliente> pesquisar(ClienteFilter clienteFilter) {
		return clienteRepository.filtrarCliente(clienteFilter);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Cliente> buscarPeloCodigo(@PathVariable Long codigo) {
		Cliente clienteEncontrado = clienteRepository.findById(codigo).orElse(null);
		
		if (clienteEncontrado != null) {
			return ResponseEntity.ok(clienteEncontrado);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Cliente> criar(@Valid @RequestBody ClienteDTO clienteDTO, HttpServletResponse response) {
		Cliente clienteSalvo = clienteService.salvar(clienteDTO);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, clienteSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
	}

	@DeleteMapping("/{codigo}")
	public void remover(@PathVariable Long codigo) {
		clienteRepository.deleteById(codigo);
	}

	@PutMapping("/{codigo}/nome")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void alterarNome(@PathVariable Long codigo, @RequestBody String novoNome) {
		clienteService.atualizarPropriedadeNome(codigo, novoNome);
	}
}
