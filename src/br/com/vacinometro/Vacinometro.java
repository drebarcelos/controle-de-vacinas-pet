package br.com.vacinometro;

import java.util.Scanner;

import br.com.vacinometro.modelo.*;
import br.com.vacinometro.repositorio.*;

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
			opcao = capturaOpcaoDigitada();
			SCANNER.nextLine();
			executaOpcaoEscolhida(opcao);
		}	
	}

	private void imprimeMenu() {
		System.out.println("Digite (0) para sair do MENU");
		System.out.println("Digite (1) para cadastrar um Tutor");
		System.out.println("Digite (2) para cadastrar um Pet");
		System.out.println("Digite (3) para cadastrar uma vacina");
		System.out.println("Digite (4) para visualizar pets cadastrados pelo tutor");
		System.out.println("Digite (5) para visualizar a carteira de vacinação do seu pet");
	}
	
	private int capturaOpcaoDigitada() {
		return SCANNER.nextInt();
	}
	
	private void executaOpcaoEscolhida(int opcao) {
		try {
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
					visualizarPetsCadastradosPeloTutor();
					break;
				case 5:
					visualizarCarteiraDeVacinacaoDoPet();
					break;
				default:
					opcaoInvalida();
					break;
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return;
		}
	}
	
	private void sair() {
		System.out.println("Programa finalizado com sucesso!");
		System.exit(OPCAO_FINAL);
	}
	
	private void cadastrarTutor() {
		String nome = capturaNomeDoTutor();
		
		System.out.println("Digite o cpf do tutor: ");
		String cpf = SCANNER.nextLine();
		
		Tutor tutor = new Tutor(nome, cpf);
		repositorioDeTutores.cadastarTutor(tutor);
		
		System.out.println("Tutor " + tutor.getNome() + " cadastrado com sucesso!");
	}
	
	private void cadastrarPet() {
		String nomeTutor = capturaNomeDoTutor();	
		Tutor tutorCadastrado = buscaTutorPeloNome(nomeTutor);
		
		Integer opcaoEspecie = capturaOpcaoDeEspecieDoPet();
		SCANNER.nextLine();
		String especie = Pet.retornaEspeciePet(opcaoEspecie);
		
		String nomePet = capturaNomeDoPet();
		
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
		String nomePet = capturaNomeDoPet();
		Pet petCadastrado = buscaPetPeloNome(nomePet);
		
		if(petCadastrado.isFelino()) {
			repositorioDeVacinas = new RepositorioDeVacinasFelino();
			buscaEImprimeVacinasDisponiveis();
			
			selecionaVacina(petCadastrado);
		}
		if(petCadastrado.isCanino()) {
			repositorioDeVacinas = new RepositorioDeVacinasCanino();
			buscaEImprimeVacinasDisponiveis();
			
			selecionaVacina(petCadastrado);
		}
	}
	
	private void visualizarPetsCadastradosPeloTutor() {
		String nomeTutor = capturaNomeDoTutor();
		Tutor tutorCadastrado = buscaTutorPeloNome(nomeTutor);
		
		buscaEImprimePetsCadastradosPeloTutor(tutorCadastrado);
	}
	
	private void visualizarCarteiraDeVacinacaoDoPet() {
		String nomePet = capturaNomeDoPet();		
		Pet petCadastrado = buscaPetPeloNome(nomePet);
		
		buscaEImprimeVacinasCadastradas(petCadastrado);
	}
	
	private void opcaoInvalida() {
		System.out.println("Opção inválida! Digite novamente");
	}
	
	private String capturaNomeDoTutor() {
		System.out.println("Digite o nome do tutor: ");
		return SCANNER.nextLine();
	}
	
	private String capturaNomeDoPet() {
		System.out.println("Digite o nome do Pet: ");
		return SCANNER.nextLine();
	}
	
	private Integer capturaNumeroVacina() {
		System.out.println("Digite o numero da vacina que deseja cadastrar: ");
		return SCANNER.nextInt();
	}
	
	private String capturaDataDaAplicacaoDaVacina() {
		System.out.println("Digite a data da aplicação da vacina: ");
		return SCANNER.nextLine();
	}
	
	private Integer capturaOpcaoDeEspecieDoPet() {
		System.out.println("Digite a especie do Pet entre as opções: ");
		System.out.println("1- Felino \n2- Canino");
		return SCANNER.nextInt();
	}
	
	private Tutor buscaTutorPeloNome(String nomeTutor) {
		return repositorioDeTutores.getTutorPeloNome(nomeTutor);
	}
	
	private Pet buscaPetPeloNome(String nomePet) {
		return repositorioDePets.getPetPeloNome(nomePet);
	}
	
	private String buscaVacinaPeloNumero(Integer numeroVacina) {
		return repositorioDeVacinas.getVacinasPeloNumero(numeroVacina);
	}
	
	private void buscaEImprimeVacinasDisponiveis() {
		System.out.println("Vacinas disponiveis: ");
		repositorioDeVacinas.getVacinas();
	}
	
	private void buscaEImprimePetsCadastradosPeloTutor(Tutor tutorCadastrado) {
		System.out.println("Pets cadastrados pelo tutor: ");
		repositorioDePets.imprimePetsCadastradosPeloTutor(tutorCadastrado);
	}
	
	private void buscaEImprimeVacinasCadastradas(Pet petCadastrado) {
		System.out.println("Lista de vacinas cadastradas: ");
		petCadastrado.getListaVacinas().forEach(System.out::println);
	}
	
	private void selecionaVacina(Pet petCadastrado) {
		Integer numeroVacina = capturaNumeroVacina();
		SCANNER.nextLine();
		String vacinaSelecionada = buscaVacinaPeloNumero(numeroVacina);
		
		String dataVacina = capturaDataDaAplicacaoDaVacina();
		
		Vacina vacina = new Vacina(vacinaSelecionada, dataVacina);
		repositorioDeVacinas.adicionaVacina(petCadastrado, vacina);
		
		System.out.println(vacina.getNome() + " cadastrada com sucesso!");
	}
}
