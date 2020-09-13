package com.example.recrutamentocompassoapi.repository.cliente;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.example.recrutamentocompassoapi.model.Cliente;
import com.example.recrutamentocompassoapi.repository.filter.ClienteFilter;

public class ClienteRepositoryImpl implements ClienteRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Cliente> filtrarCliente(ClienteFilter clienteFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
		
		Root<Cliente> root = criteria.from(Cliente.class);
		
		Predicate[] predicates = criarRestricoes(clienteFilter, builder, root);
		criteria.where(predicates);
		criteria.orderBy(builder.asc(root.get("nomeCompleto")));
		
		TypedQuery<Cliente> query = manager.createQuery(criteria);
		
		return query.getResultList();
	}

	private Predicate[] criarRestricoes(ClienteFilter clienteFilter, CriteriaBuilder builder, Root<Cliente> root) {
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if (!StringUtils.isEmpty(clienteFilter.getNome())) {
			predicates.add(builder.like(
					builder.lower(root.get("nomeCompleto")), "%" + clienteFilter.getNome().toLowerCase() + "%"));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
