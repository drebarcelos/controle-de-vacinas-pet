package br.com.vacinometro.repositorio;

import br.com.vacinometro.modelo.Pet;
import br.com.vacinometro.modelo.Tutor;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDePets {
	private List<Pet> pets;
	
	public RepositorioDePets() {
		pets = new ArrayList<Pet>();
	}
	
	public void cadastrarPet(Pet pet) {
		this.pets.add(pet);
	}
	
	public List<Pet> getTodosPets() {
		return pets;
	}
	
	public Pet getPetPeloNome(String nome) {
		for (Pet pet : pets) {
			if(pet.getNome().equals(nome)) {
				return pet;
			}
		}
		throw new RuntimeException("Pet não encontrado!");
	}
	
	public void imprimePetsCadastradosPeloTutor(Tutor tutor) {
		for (Pet pet : pets) {
			if(pet.getTutor().equals(tutor)) {
				System.out.println(pet);
			}
		}
	}
}
