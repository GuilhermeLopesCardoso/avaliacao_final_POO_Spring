package com.prova3.poo.prova3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova3.poo.prova3.model.Motorista;
import com.prova3.poo.prova3.model.Veiculo;
import com.prova3.poo.prova3.repository.VeiculoRepository;

@Service
public class VeiculoService {

	@Autowired
	VeiculoRepository veiculorepository;
	
	public Veiculo insereVeiculo(Veiculo v) {
		return veiculorepository.save(v);
	}
	
	public Veiculo alteraVeiculo(Veiculo v) {
		return veiculorepository.save(v);
	}
	
	public Veiculo buscaPorCodigo(Integer id) {
		return veiculorepository.findById(id).orElse(null);
	}
	
	public void excluiVeiculo(Veiculo v) {
		veiculorepository.delete(v);
	}
	
	public List<Veiculo> listaTodosVeiculos() {
		return veiculorepository.findAll();
	}
	
	public List<Veiculo> buscaPorMarca(String marcavei) {
		return veiculorepository.findByMarcavei(marcavei);
	}
	
	public List<Veiculo> buscaPorAno(Integer anofab) {
		return veiculorepository.findByAnofab(anofab);
	}
	
	public List<Veiculo> buscaPorMotorista(Motorista motorista) {
		return veiculorepository.findByMotorista(motorista);
	}
	
}