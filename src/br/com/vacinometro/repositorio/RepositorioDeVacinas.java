package br.com.vacinometro.repositorio;

import br.com.vacinometro.modelo.Pet;
import br.com.vacinometro.modelo.Vacina;

public interface RepositorioDeVacinas {
	
	void adicionaVacina(Pet pet, Vacina vacina);
	
	void getVacinas();
	
	String getVacinasPeloNumero(Integer numeroVacina);
}
