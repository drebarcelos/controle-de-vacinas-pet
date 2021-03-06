package br.com.vacinometro.modelo;

import java.util.Objects;

public class Tutor {
	private String nome;
	private String cpf;
	
	public Tutor(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tutor other = (Tutor) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Nome: " + this.nome + ", cpf: " + this.cpf;
	}
}
