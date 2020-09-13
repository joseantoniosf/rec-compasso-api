package com.example.recrutamentocompassoapi.repository.cliente;

import java.util.List;

import com.example.recrutamentocompassoapi.model.Cliente;
import com.example.recrutamentocompassoapi.repository.filter.ClienteFilter;

public interface ClienteRepositoryQuery {
	
	public List<Cliente> filtrarCliente(ClienteFilter clienteFilter);

}
