package br.com.vacinometro;

import java.util.Scanner;

import br.com.vacinometro.modelo.Tutor;
import br.com.vacinometro.repositorio.RepositorioDeTutores;

public class Aplicacao {
	private static Scanner SCANNER = new Scanner(System.in);

	public static void main(String[] args) {
		
		Tutor tutor1 = new Tutor("Andressa", "87004182094");
		System.out.println(tutor1);
		
		Tutor tutor2 = new Tutor("Gabriela", "87004182094");
		System.out.println(tutor2);
		
		RepositorioDeTutores repositorioDeTutores = new RepositorioDeTutores();
		repositorioDeTutores.cadastarTutor(tutor1);
		repositorioDeTutores.cadastarTutor(tutor2);
		
		System.out.println("Tutores: " + repositorioDeTutores.getTutores());
		
		System.out.println("Digite o nome do tutor que deseja buscar: ");
		String nome = SCANNER.nextLine();
		System.out.println("Tutor selecionado: " + repositorioDeTutores.getTutorPeloNome(nome));
	}

}
