package com.prova3.poo.prova3.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Motorista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	@NotNull(message = "nome não pode ser nulo \n")
	private String nome;
	
	@Column
	@NotNull(message = "CPF não pode ser nulo \n")
	private String cpf;
	

	@Override
	public String toString() {
		return "Código=" + id + ",\n" +
			   "Nome=" + nome + ",\n" +
			   "CPF=" + cpf + "\n\n";
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Motorista(Integer id, @NotNull(message = "Nome não pode ser nulo") String nome,
			@NotNull(message = "CPF não pode ser nulo") String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public Motorista() {
		
	}
	
}
