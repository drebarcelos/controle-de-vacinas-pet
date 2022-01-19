package br.com.vacinometro;

import java.util.Scanner;

import br.com.vacinometro.modelo.Tutor;
import br.com.vacinometro.repositorio.RepositorioDeTutores;

public class Aplicacao {
	private static Scanner SCANNER = new Scanner(System.in);

	public static void main(String[] args) {
		new Vacinometro().iniciar();
	}

}
