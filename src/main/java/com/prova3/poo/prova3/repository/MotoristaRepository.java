package com.prova3.poo.prova3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prova3.poo.prova3.model.Motorista;

public interface MotoristaRepository extends JpaRepository<Motorista, Integer>{

	public List<Motorista> findByNome(String nome);
	
}
