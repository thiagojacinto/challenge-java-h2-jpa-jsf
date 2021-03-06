package br.thiagojacinto.sefazpe.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * @author: Thiago Jacinto
 */

@Entity
@Table(name = "usuarios")
public class Usuario {

	// Atributos
	
	// JPA -> É necessário um atributo para o índice
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "nome")
	private String nome;
	@Column(name = "email")
	private String email;
	@Column(name = "senha")
	private String senha;
	
	private List<String> telefones;	// Implementar como ArrayList por ser dinâmico.
	
	@Column(name = "telefones")
	private String telefonesString;

	// Construtores:

	// 1. construtor com parametros
	public Usuario(String nome, String email, String senha, 
			Integer ddd, String numero, String tipo) {

		this.nome = nome;
		this.email = email;
		this.senha = senha;

		this.telefones = new ArrayList<String>();
		Utilidades.adicionarTelefone(telefones, ddd, numero, tipo);
		
		this.telefonesString = Utilidades.stringifyLista(telefones);

	}

	// 2. construtor vazio
	public Usuario() {
		
	}

	// Getters & Setters
	
	public int getId() {
		return id;
	}

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
	
	public String getTelefonesString() {
		return telefonesString;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public void setTelefonesString(String telefonesString) {
		this.telefonesString = telefonesString;
	}

	// Override toString
	@Override
	public String toString() {
		return "Usuario [id = " + id 
				+ ", nome = " + nome 
				+ ", email = " + email 
				+ ", senha = " + senha 
				+ ", telefones = " + telefonesString 
				+ " ]";
	}
	
	

}
