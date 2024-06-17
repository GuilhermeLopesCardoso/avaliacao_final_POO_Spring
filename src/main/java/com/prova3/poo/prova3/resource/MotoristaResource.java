package com.prova3.poo.prova3.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prova3.poo.prova3.model.Motorista;
import com.prova3.poo.prova3.services.MotoristaService;

import jakarta.validation.ConstraintViolationException;

@RestController
@RequestMapping("/motorista")
public class MotoristaResource {
	
	@Autowired
	MotoristaService motoristaservice;
	
	@GetMapping
	public String listatodas() {
		List<Motorista> motoristas = motoristaservice.listaTodosMotoristas();  
		if(motoristas.isEmpty()) {
			return "Não existe nenhum motorista cadastrado";
		} else {
			return motoristas.stream().map(Motorista::toString).collect(Collectors.joining(""));
		}
	}
	
	@GetMapping("/id/{id}")
	public String buscaPorCodigo(@PathVariable Integer id) {
		String retorno = "";
		
		try {
			Motorista motorista = motoristaservice.buscaPorCodigo(id);
			if(motorista == null) {
				retorno = "Não existe motorista cadastrado com esse código";
			} else {
				return motorista.toString();
			}
		} catch (NumberFormatException e) {
			return "O ID informado é inválido";
		}
		return retorno;
	
	}
	
	@PostMapping
	public String cadastra(@RequestBody Motorista m) {
		
		try {
			if (!motoristaservice.buscaPorCpf(m.getCpf()).isEmpty()) {
				return "Já existe um Motorista cadastrado com esse CPF, você pode alterá-lo, ou deletar e cadastrá-lo novamente.";
			} else {
				motoristaservice.insereMotorista(m);
			}
		} catch (ConstraintViolationException e) {
			return "Motorista não cadastrado pois " + e.getMessage();
		} return "Motorista cadastrado com sucesso. \n\n" + m.toString();
	}
	
	@GetMapping("/nome/{nome}")
	public String buscaPorNome(@PathVariable String nome) {
		
		List<Motorista> motorista = motoristaservice.buscaPorNome(nome);
			if(motorista.isEmpty()) {
				return "Não existe um motorista cadastrado com esse nome";
			} else {
				return motorista.stream().map(Motorista::toString).collect(Collectors.joining(""));
			}
			
	}
	
	@GetMapping("/cpf/{cpf}")
	public String buscaPorCpf(@PathVariable String cpf) {
		
		List<Motorista> motorista = motoristaservice.buscaPorCpf(cpf);
		if(motorista.isEmpty()) {
			return "Não existe um cpf cadastrado com esse número";
		} else {
			return motorista.stream().map(Motorista::toString).collect(Collectors.joining(""));
		}
	}
	
	@DeleteMapping("/id/{id}")
	public String excluiMotorista(@PathVariable Integer id) {
		try {
			Motorista m = motoristaservice.buscaPorCodigo(id);
			if(m == null) {
				return "Não existe um motorista com esse código";
			} else {
				motoristaservice.excluiMotorista(m);
				return "Motorista excluído com sucesso!";
			}
		} catch (NumberFormatException e) {
			return "Código inválido, tente novamente";
		}
	}
	
	@PutMapping("/id/{id}")
	public String alteraMotorista(@PathVariable Integer id, @RequestBody Motorista m) {
		try {
			Motorista antigo = motoristaservice.buscaPorCodigo(id);
			if(antigo == null) {
				return "Não existe um motorista com esse código";
			} else {
				if(m.getNome() != null) {
					antigo.setNome(m.getNome());
				}
				if(m.getCpf() != null) {
					antigo.setCpf(m.getCpf());
				}
				motoristaservice.alteraMotorista(antigo);
				return "Motorista alterado com sucesso: \n" + antigo.toString();
			}
		} catch (NumberFormatException e) {
			return "Código inválido, tente novamente";
		}
		
		
	}
	
}
