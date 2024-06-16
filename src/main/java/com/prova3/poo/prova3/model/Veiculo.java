package com.prova3.poo.prova3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	@NotNull(message = "Marca não pode ser nulo\n")
	private String marcavei;
	
	@Column
	@NotNull(message = "Placa não pode ser nulo\n")
	private String placavei;
	
	@Column
	@NotNull(message = "Ano de Fabricação não pode ser nulo\n")
	private Integer anofab;
	
	@ManyToOne
	private Motorista motorista;

	
	@Override
	public String toString() {
		return "Código=" + id + ",\n" +
			   "Marca=" + marcavei + ",\n" +
			   "Placa=" + placavei + "\n" +
			   "Ano fabricação=" + anofab + ",\n" +
			   "Motorista=" + motorista + ",\n\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarcavei() {
		return marcavei;
	}

	public void setMarcavei(String marcavei) {
		this.marcavei = marcavei;
	}

	public String getPlacavei() {
		return placavei;
	}

	public void setPlacavei(String placavei) {
		this.placavei = placavei;
	}

	public Integer getAnofab() {
		return anofab;
	}

	public void setAnofab(Integer anofab) {
		this.anofab = anofab;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
	
	
	
}
