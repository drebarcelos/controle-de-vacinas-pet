package br.com.vacinometro;

import java.util.Scanner;

import br.com.vacinometro.modelo.*;
import br.com.vacinometro.repositorio.RepositorioDeTutores;

public class Vacinometro {
	private static final int OPCAO_INICIAL = 1;
	private static final int OPCAO_FINAL = 0;
	private static final Scanner SCANNER = new Scanner(System.in);
	private RepositorioDeTutores repositorioDeTutores;
	
	public Vacinometro() {
		repositorioDeTutores = new RepositorioDeTutores();
	}
	
	public void iniciar() {
		int opcao = OPCAO_INICIAL;
		
		while(opcao != OPCAO_FINAL) {
			imprimeMenu();
			opcao = pegaOpcaoDigitada();
			SCANNER.nextLine();
			executaOpcaoEscolhida(opcao);
		}
		
	}

	private void imprimeMenu() {
		System.out.println("Digite (0) para sair do MENU");
		System.out.println("Digite (1) para cadastrar um Tutor");
	}
	
	private int pegaOpcaoDigitada() {
		return SCANNER.nextInt();
	}
	
	private void executaOpcaoEscolhida(int opcao) {
		switch(opcao) {
			case 0:
				sair();
				break;
			case 1:
				cadastrarTutor();
		}
	}
	
	private void sair() {
		System.out.println("Programa finalizado com sucesso!");
		System.exit(OPCAO_FINAL);
	}
	
	private void cadastrarTutor() {
		System.out.println("Digite o nome do tutor: ");
		String nome = SCANNER.nextLine();
		
		System.out.println("Digite o cpf do tutor: ");
		String cpf = SCANNER.nextLine();
		
		Tutor tutor = new Tutor(nome, cpf);
		repositorioDeTutores.cadastarTutor(tutor);
		
		System.out.println("Tutor " + tutor.getNome() + " cadastrado com sucesso!");
	}

}
