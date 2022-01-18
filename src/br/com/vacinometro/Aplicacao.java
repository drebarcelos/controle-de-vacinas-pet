package br.com.vacinometro;

import br.com.vacinometro.projeto.Tutor;

public class Aplicacao {

	public static void main(String[] args) {
		
		Tutor tutor = new Tutor("Andressa", "87004182094");
		tutor.setNome("Gabriela");
		System.out.println(tutor);
	}

}
