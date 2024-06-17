
package com.prova3.poo.prova3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova3.poo.prova3.model.Motorista;
import com.prova3.poo.prova3.repository.MotoristaRepository;

@Service
public class MotoristaService {

	@Autowired
	MotoristaRepository motoristarepository;
	
	public Motorista insereMotorista(Motorista m) {
		return motoristarepository.save(m);
	}
	
	public Motorista alteraMotorista(Motorista m) {
		return motoristarepository.save(m);
	}
	
	public Motorista buscaPorCodigo(Integer id) {
		return motoristarepository.findById(id).orElse(null);
	}
	
	public void excluiMotorista(Motorista m) {
		motoristarepository.delete(m);
	}
	
	public List<Motorista> listaTodosMotoristas() {
		return motoristarepository.findAll();
	}
	
	public List<Motorista> buscaPorNome(String nome) {
		return motoristarepository.findByNome(nome);
	}
	
	public List<Motorista> buscaPorCpf(String cpf) {
		return motoristarepository.findByCpf(cpf);
	}

}
