package br.com.vacinometro.repositorio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import br.com.vacinometro.modelo.Pet;
import br.com.vacinometro.modelo.Vacina;

public class RepositorioDeVacinasFelino implements RepositorioDeVacinas {
	private File arquivoDeVacinasFelino;
	
	public RepositorioDeVacinasFelino() {
		arquivoDeVacinasFelino = new File("resources/arquivoDeVacinasFelino.txt");
	}

	@Override
	public void adicionaVacina(Pet pet, Vacina vacina) {
		 pet.getListaVacinas().add(vacina);
	}

	@Override
	public void getVacinas() {
		try {
			InputStream fis = new FileInputStream("resources/arquivoDeVacinasFelino.txt");
	        Reader isr = new InputStreamReader(fis);
	        BufferedReader br = new BufferedReader(isr);
	
	        String linha = br.readLine();
	
	        while(linha != null) {
	        	System.out.println(linha);
	        	linha = br.readLine();
	        }
	        br.close();
	        isr.close();
	        fis.close();
		} catch(IOException e) {
			throw new RuntimeException("Erro ao listar todas as vacinas!", e);
		}		
	}

	@Override
	public String getVacinasPeloNumero(Integer numeroVacina) {
		try {
			InputStream fis = new FileInputStream("resources/arquivoDeVacinasFelino.txt");
	        Reader isr = new InputStreamReader(fis);
	        BufferedReader br = new BufferedReader(isr);
	
	        String linha = br.readLine();
	
	        while(linha != null) {
	        	String[] split = linha.split("-");
                
                String numero = split[0];
                String vacina = split[1];
                
                if(numero.equals(numeroVacina.toString())) {
                	return vacina;
                }
                
                linha = br.readLine();
	        }
	        br.close();
	        isr.close();
	        fis.close();
		} catch(IOException e) {
			throw new RuntimeException("Erro ao listar todas as vacinas!", e);
		}
		throw new RuntimeException("Vacina n�o encontrada!");
	}
}
