package br.com.vacinometro.repositorio;

import br.com.vacinometro.modelo.Tutor;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeTutores {
	private List<Tutor> tutores;
	
	
	public RepositorioDeTutores() {
		tutores = new ArrayList<Tutor>();
	}
	
	public void cadastarTutor(Tutor tutor) {
		this.tutores.add(tutor);
	}
	
	public List<Tutor> getTutores(){
		return tutores;
	}
	
	public Tutor getTutorPeloNome(String nome) {
		for (Tutor tutor : tutores) {
			if(tutor.getNome().equals(nome)) {
				return tutor;
			}
		}
		throw new RuntimeException("Tutor não encontrado!");
	}
}
