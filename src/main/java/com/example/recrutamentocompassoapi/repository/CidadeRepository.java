package com.example.recrutamentocompassoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.recrutamentocompassoapi.model.Cidade;
import com.example.recrutamentocompassoapi.repository.cidade.CidadeRepositoryQuery;

public interface CidadeRepository extends JpaRepository<Cidade, Long>, CidadeRepositoryQuery {

}
