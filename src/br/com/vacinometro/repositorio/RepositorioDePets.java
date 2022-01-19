package br.com.vacinometro.repositorio;

import br.com.vacinometro.modelo.Pet;

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
}
