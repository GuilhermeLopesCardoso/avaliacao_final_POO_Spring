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
import com.prova3.poo.prova3.model.Veiculo;
import com.prova3.poo.prova3.services.MotoristaService;
import com.prova3.poo.prova3.services.VeiculoService;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/veiculo")
public class VeiculoResource {
	
	@Autowired
	VeiculoService veiculoservice;
	
	@Autowired
	MotoristaService motoristaservice;

	@GetMapping
	public String listaTodas() {
		List<Veiculo> veiculos = veiculoservice.listaTodosVeiculos();
		if(veiculos.isEmpty()) {
			return "Não existe nenhum veículo cadastrado";
		} else {
			return veiculos.stream().map(Veiculo::toString).collect(Collectors.joining(""));
		}
	}

	
	@PostMapping
	public String cadastra(@Valid @RequestBody Veiculo v) {
		try {
			if(!veiculoservice.buscaPorPlaca(v.getPlacavei()).isEmpty()) {
				return "Já existe um veículo cadastrado com essa placa";
			} else {
				veiculoservice.insereVeiculo(v);
				return "Veículo cadastrado com sucesso";
			}
		} catch (ConstraintViolationException e) {
			return "Veículo não pode ser cadastrado";
		}
	}
	
	@PutMapping("/id/{id}")
	public String altera(@PathVariable Integer id, @RequestBody Veiculo v) {
		try {
			Veiculo antigo = veiculoservice.buscaPorCodigo(id);            
			if(antigo == null) {
                return "Não existe um veículo com esse código";
            } else {
            	if (v.getMarcavei()!=null) {
                    antigo.setMarcavei(v.getMarcavei());
            	}
            	if(v.getMotorista()!=null) {
            		antigo.setMotorista(v.getMotorista());
            	}
            	if(v.getPlacavei()!=null) {
            		antigo.setPlacavei(v.getPlacavei());
            	}
                if(v.getAnofab()!=null) {
                    antigo.setAnofab(v.getAnofab());
                }
                veiculoservice.alteraVeiculo(antigo);
                return "Veículo alterado com sucesso: \n" + antigo.toString();
            }
        } catch (NumberFormatException e) {
            return "Código inválido, tente novamente";
        }
	}
	
	
	@GetMapping("/id/{id}")
	public String buscarPorCodigo(@PathVariable Integer id) {		
		try {
			Veiculo veiculo = veiculoservice.buscaPorCodigo(id);
			if(veiculo == null) {
				return "Não existe nenhum veículo cadastrado com esse código";
			}else {
				return veiculo.toString();
			}
		} catch (NumberFormatException e) {
			return "Código informado invalido";
		}
	}	
	
	@DeleteMapping("/id/{id}")
	public String deletaVeiculo(@PathVariable Integer id) {
		try {
			Veiculo veiculo = veiculoservice.buscaPorCodigo(id);
			if(veiculo == null) {
				return "Não existe nenhum veículo cadastrado com esse código";
			}else {
				veiculoservice.excluiVeiculo(veiculo);
				return "Veiculo excluído com sucesso" ;
			}
		} catch (NumberFormatException e) {
			return "Código informado invalido";
		}
	}	
	@GetMapping("/marca/{marcavei}")
	public String buscaPorMarca(@PathVariable String marcavei) {
		List<Veiculo> veiculos = veiculoservice.buscaPorMarca(marcavei);
		if (veiculos.isEmpty()) {
			return "Não existem veículos cadastrados com essa marca";
		}else {
			return veiculos.stream().map(Veiculo::toString).collect(Collectors.joining(""));
		}
	}	
	@GetMapping("/ano/{anofab}")
	public String buscarPorAno(@PathVariable Integer anofab) {
		List<Veiculo> veiculos = veiculoservice.buscaPorAno(anofab);
		if (veiculos.isEmpty()) {
			return "Não existem veículos cadastrados com esse ano de fabricação";
		}else {
			return veiculos.stream().map(Veiculo::toString).collect(Collectors.joining(""));
		}
	}
	
	@GetMapping("/placa/{placavei}")
	public String buscaPorPlaca(@PathVariable String placavei) {
		List<Veiculo> veiculos = veiculoservice.buscaPorPlaca(placavei);
		if(veiculos.isEmpty()) {
			return "Não existe nenhum veículo cadastrado com essa placa";
		} else {
			return veiculos.stream().map(Veiculo::toString).collect(Collectors.joining(""));
		}
	}
	
	@GetMapping("/motorista/{id}")
	public String buscaPorMotorista(@PathVariable Integer id) {
		Motorista motorista = motoristaservice.buscaPorCodigo(id);
		List<Veiculo> veiculos = veiculoservice.buscaPorMotorista(motorista);
		if(veiculos.isEmpty()) {
			return "Não existem veículos cadastrados para esse motorista";
		} else {
			return veiculos.stream().map(Veiculo::toString).collect(Collectors.joining(""));
		}
	}
}