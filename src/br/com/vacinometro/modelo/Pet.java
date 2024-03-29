package br.com.vacinometro.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pet {
	private static final int OPCAO_ESPECIE_FELINO = 1;
	private static final int OPCAO_ESPECIE_CANINO = 2;
	private static final String FELINO = "Felino";
	private static final String CANINO = "Canino";
	private String especie;
	private String nome;
	private String raca;
	private Integer idade;
	private Double peso;
	private Tutor tutor;
	private List<Vacina> listaVacinas;
	
	public Pet(String especie, String nome, String raca, Integer idade, Double peso, Tutor tutor) {
		this.especie = especie;
		this.nome = nome;
		this.raca = raca;
		this.idade = idade;
		this.peso = peso;
		this.tutor = tutor;
		listaVacinas = new ArrayList<Vacina>();
	}
	
	public Boolean isFelino() {
		if(this.especie.equals(FELINO)) {
			return true;
		} return false;
	}
	
	public Boolean isCanino() {
		return !isFelino();
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
	
	public Tutor getTutor() {
		return tutor;
	}
	
	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
	
	public List<Vacina> getListaVacinas() {
		return listaVacinas;
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
		return "\nNome: " + this.nome + "\nEspecie: " + this.especie + "\nRaca: " + this.raca + "\nIdade: " + this.idade + 
				"\nPeso: " + this.peso;
	}
	
	public static String retornaEspeciePet(Integer opcaoEspecie) {
		if(opcaoEspecie.equals(OPCAO_ESPECIE_FELINO)) {
			return FELINO;
		}
		if(opcaoEspecie.equals(OPCAO_ESPECIE_CANINO)) {
			return CANINO;
		}
		throw new RuntimeException("Especie n�o encontrada!");	
	}
}
