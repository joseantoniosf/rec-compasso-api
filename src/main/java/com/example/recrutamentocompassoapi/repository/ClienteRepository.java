package com.example.recrutamentocompassoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.recrutamentocompassoapi.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
