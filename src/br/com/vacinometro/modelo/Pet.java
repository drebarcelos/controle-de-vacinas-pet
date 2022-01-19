package br.com.vacinometro.modelo;

import java.util.Objects;

public class Pet {
	private String especie;
	private String nome;
	private String raca;
	private Integer idade;
	private Double peso;
	
	public Pet(String especie, String nome, String raca, Integer idade, Double peso) {
		this.especie = especie;
		this.nome = nome;
		this.raca = raca;
		this.idade = idade;
		this.peso = peso;
	}
	
	public String getEspecie() {
		return especie;
	}
	
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getRaca() {
		return raca;
	}
	
	public void setRaca(String raca) {
		this.raca = raca;
	}
	
	public Integer getIdade() {
		return idade;
	}
	
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	public Double getPeso() {
		return peso;
	}
	
	public void setPeso(Double peso) {
		this.peso = peso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idade, nome, peso, raca);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pet other = (Pet) obj;
		return Objects.equals(idade, other.idade) && Objects.equals(nome, other.nome)
				&& Objects.equals(peso, other.peso) && Objects.equals(raca, other.raca);
	}

	@Override
	public String toString() {
		return "Nome: " + this.nome + ", raca: " + this.raca + ", idade: " + this.idade + ", peso: " + this.peso;
	}
}
