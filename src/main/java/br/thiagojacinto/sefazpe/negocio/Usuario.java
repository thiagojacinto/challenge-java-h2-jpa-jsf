package br.thiagojacinto.sefazpe.negocio;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	// Atributos
		private String nome;
		private String email;
		private String senha;
		
		private List<String> telefones;
		
		// Construtores:
		
		// 1. construtor com parametros
		public Usuario(String nome, String email, String senha, 
				Integer ddd, String numero, String tipo) {
			
			this.nome = nome;
			this.email = email;
			this.senha = senha;
			
			/*
			 * TODO: 	Inserir método para formar um item de `telefones` 
			 * 			com as informações inseridas;
			 */
			this.telefones = new ArrayList<String>();
			adicionarTelefone(ddd, numero, tipo);

		}
		
		// 2. construtor vazio
		public Usuario() {
			
			this.nome = "VAZIO";
			this.email = "VAZIO";
			this.senha = "VAZIO";
			
			this.telefones = new ArrayList<String>();
		}
		
		
		// Métodos
		
		// Criar item na lista `telefones` com cada `ddd` + `número`
		public void adicionarTelefone(Integer DDD, String numero, String tipo) {
			
			// Formatando a String com a seguinte ordem "0" + DDD + numero + "," + tipo:
			String adicionar = String.format("0%d %s,%s", DDD, numero, tipo);
			
			telefones.add(adicionar);
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
