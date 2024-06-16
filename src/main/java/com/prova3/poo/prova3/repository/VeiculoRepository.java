package com.prova3.poo.prova3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prova3.poo.prova3.model.Motorista;
import com.prova3.poo.prova3.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer>{
	
	public List<Veiculo> findByMarcavei(String marcavei);
	
	public List<Veiculo> findByAnofab(Integer anofab);
	
	public List<Veiculo> findByPlacavei(String placavei);
	
	public List<Veiculo> findByMotorista(Motorista motorista);
	
}