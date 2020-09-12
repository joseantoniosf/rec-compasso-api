package com.example.recrutamentocompassoapi.repository.cidade;

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

import com.example.recrutamentocompassoapi.model.Cidade;
import com.example.recrutamentocompassoapi.model.Estado;
import com.example.recrutamentocompassoapi.repository.filter.CidadeFilter;

public class CidadeRepositoryImpl implements CidadeRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Cidade> filtrarCidade(CidadeFilter cidadeFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Cidade> criteria = builder.createQuery(Cidade.class);
		
		Root<Cidade> root = criteria.from(Cidade.class);
		
		Predicate[] predicates = criarRestricoes(cidadeFilter, builder, root);
		criteria.where(predicates);
		criteria.orderBy(builder.asc(root.get("nome")));
		
		TypedQuery<Cidade> query = manager.createQuery(criteria);
		
		return query.getResultList();
	}

	private Predicate[] criarRestricoes(CidadeFilter cidadeFilter, CriteriaBuilder builder, Root<Cidade> root) {
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if (!StringUtils.isEmpty(cidadeFilter.getNome())) {
			predicates.add(builder.like(
					builder.lower(root.get("nome")), "%" + cidadeFilter.getNome().toLowerCase() + "%"));
		}
		
		if (!StringUtils.isEmpty(cidadeFilter.getEstado())) {
			Estado estado = new Estado(cidadeFilter.getEstado());
			predicates.add(builder.equal(root.get("estado"), estado));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
