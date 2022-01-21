package br.com.vacinometro;

import java.util.Scanner;

import br.com.vacinometro.modelo.*;
import br.com.vacinometro.repositorio.RepositorioDePets;
import br.com.vacinometro.repositorio.RepositorioDeTutores;
import br.com.vacinometro.repositorio.RepositorioDeVacinas;
import br.com.vacinometro.repositorio.RepositorioDeVacinasCanino;
import br.com.vacinometro.repositorio.RepositorioDeVacinasFelino;

public class Vacinometro {
	private static final int OPCAO_INICIAL = 1;
	private static final int OPCAO_FINAL = 0;
	private static final Scanner SCANNER = new Scanner(System.in);
	private RepositorioDeTutores repositorioDeTutores;
	private RepositorioDePets repositorioDePets;
	private RepositorioDeVacinas repositorioDeVacinas;
	
	public Vacinometro() {
		repositorioDeTutores = new RepositorioDeTutores();
		repositorioDePets = new RepositorioDePets();
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
		System.out.println("Digite (2) para cadastrar um Pet");
		System.out.println("Digite (3) para cadastrar uma vacina");
		System.out.println("Digite (4) para buscar pets cadastrados pelo tutor");
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
				break;
			case 2:
				cadastrarPet();
				break;
			case 3:
				cadastrarVacina();
				break;
			case 4:
				imprimePetsCadastradosPeloTutor();
				break;
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
	
	private void cadastrarPet() {
		System.out.println("Digite o nome do Tutor: ");
		String nomeTutor = SCANNER.nextLine();
		
		Tutor tutorCadastrado = repositorioDeTutores.getTutorPeloNome(nomeTutor);
		
		System.out.println("Digite a especie do Pet: ");
		String especie = SCANNER.nextLine();
		
		System.out.println("Digite o nome do Pet: ");
		String nomePet = SCANNER.nextLine();
		
		System.out.println("Digite a raça do Pet: ");
		String raca = SCANNER.nextLine();
		
		System.out.println("Digite a idade do Pet: ");
		Integer idade = SCANNER.nextInt();
		
		System.out.println("Digite o peso do Pet: ");
		Double peso = SCANNER.nextDouble();
		
		Pet pet = new Pet(especie, nomePet, raca, idade, peso, tutorCadastrado);
		repositorioDePets.cadastrarPet(pet);
		
		System.out.println("Pet " + pet.getNome() + " cadastrado com sucesso!");		
	}

	private void cadastrarVacina() {
		System.out.println("Digite o nome do Pet: ");
		String nomePet = SCANNER.nextLine();
		Pet petCadastrado = repositorioDePets.getPetPeloNome(nomePet);
		
		if(petCadastrado.isFelino()) {
			repositorioDeVacinas = new RepositorioDeVacinasFelino();
			System.out.println("Vacinas disponiveis: ");
			repositorioDeVacinas.getVacinas();
			
			System.out.println("Digite o numero da vacina que deseja cadastrar: ");
			Integer numeroVacina = SCANNER.nextInt();
			SCANNER.nextLine();
			String vacinaSelecionada = repositorioDeVacinas.getVacinasPeloNumero(numeroVacina);
			
			System.out.println("Digite a data da aplicação da vacina: ");
			String dataVacina = SCANNER.nextLine();
			
			Vacina vacina = new Vacina(vacinaSelecionada, dataVacina);
			repositorioDeVacinas.adicionaVacina(petCadastrado, vacina);
			
			System.out.println(vacina.getNome() + " cadastrada com sucesso!");
		}
		if(petCadastrado.isCanino()) {
			repositorioDeVacinas = new RepositorioDeVacinasCanino();
			System.out.println("Vacinas disponiveis: ");
			repositorioDeVacinas.getVacinas();
			
			System.out.println("Digite o numero da vacina que deseja cadastrar: ");
			Integer numeroVacina = SCANNER.nextInt();
			SCANNER.nextLine();
			String vacinaSelecionada = repositorioDeVacinas.getVacinasPeloNumero(numeroVacina);
			
			System.out.println("Digite a data da aplicação da vacina: ");
			String dataVacina = SCANNER.nextLine();
			
			Vacina vacina = new Vacina(vacinaSelecionada, dataVacina);
			repositorioDeVacinas.adicionaVacina(petCadastrado, vacina);
			
			System.out.println(vacina.getNome() + " cadastrada com sucesso!");
		}
	}
	
	private void imprimePetsCadastradosPeloTutor() {
		System.out.println("Digite o nome do Tutor: ");
		String nomeTutor = SCANNER.nextLine();
		
		Tutor tutorCadastrado = repositorioDeTutores.getTutorPeloNome(nomeTutor);
		System.out.println("Pets cadastrados pelo tutor: ");
		repositorioDePets.imprimePetsCadastradosPeloTutor(tutorCadastrado);
	}
}
