package br.thiagojacinto.sefazpe.persistencia;

import java.util.ArrayList;
import java.util.List;

import br.thiagojacinto.sefazpe.negocio.Utilidades;


public class Usuario {

	// Atributos

	private String nome;
	private String email;
	private String senha;

	private List<String> telefones;	// Implementar como ArrayList por ser dinâmico.

	// Construtores:

	// 1. construtor com parametros
	public Usuario(String nome, String email, String senha, 
			Integer ddd, String numero, String tipo) {

		this.nome = nome;
		this.email = email;
		this.senha = senha;

		this.telefones = new ArrayList<String>();
		Utilidades.adicionarTelefone(telefones, ddd, numero, tipo);

	}

	// 2. construtor vazio
	public Usuario() {

		this.nome = "VAZIO";
		this.email = "VAZIO";
		this.senha = "VAZIO";

		this.telefones = new ArrayList<String>();
	}

	// Getters & Setters

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public List<String> getTelefones() {
		return telefones;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setTelefones(List<String> telefones) {
		this.telefones = telefones;
	}



}
