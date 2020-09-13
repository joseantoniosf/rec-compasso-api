package com.example.recrutamentocompassoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.recrutamentocompassoapi.model.Cidade;
import com.example.recrutamentocompassoapi.model.Cliente;
import com.example.recrutamentocompassoapi.model.dto.ClienteDTO;
import com.example.recrutamentocompassoapi.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente salvar(ClienteDTO clienteDTO) {
		Cliente clienteNovo = new Cliente();
		clienteNovo.setNomeCompleto(clienteDTO.getNomeCompleto());
		clienteNovo.setSexo(clienteDTO.getSexo());
		clienteNovo.setDataNascimento(clienteDTO.getDataNascimento());
		clienteNovo.setIdade(clienteDTO.getIdade());
		
		Cidade cidadeCliente = new Cidade(clienteDTO.getCidadeCodigo());
		clienteNovo.setCidade(cidadeCliente);
		
		return clienteRepository.save(clienteNovo);
	}

	public void atualizarPropriedadeNome(Long codigo, String novoNome) {
		Cliente clienteSalvo = buscarClientePeloCodigo(codigo);
		clienteSalvo.setNomeCompleto(novoNome);
		clienteRepository.save(clienteSalvo);
	}
	
	private Cliente buscarClientePeloCodigo(Long codigo) {
		Cliente clienteSalvo = clienteRepository.findById(codigo).orElse(null);
		if (clienteSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return clienteSalvo;
	}
}
