package br.com.vacinometro.modelo;

import java.util.Objects;

public class Vacina {
	private String nome;
	private String data;
	
	public Vacina(String nome, String data) {
		this.nome = nome;
		this.data = data;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vacina other = (Vacina) obj;
		return Objects.equals(data, other.data) && Objects.equals(nome, other.nome);
	}
	
	@Override
	public String toString() {
		return "Nome: " + this.nome + " - Data da aplicaçao: " + this.data;
	}
}
