package br.thiagojacinto.sefazpe.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UsuarioDAO {
	
	// Injeção do `EntityManager`
	
	@PersistenceContext(unitName = "restapi_sefazpe")
	EntityManager entityManager;
	
	// Métodos de acesso aos dados
	
	public List mostrarTodos() {
		
		return entityManager.createNamedQuery(
				"Usuario.mostrarTodos", Usuario.class).getResultList();
				
	}
	
	public Usuario procurarPorId(int id) {
		
		return entityManager.find(Usuario.class, id);
	}
	
	public void atualizar(Usuario usuario) {
		
		entityManager.merge(usuario);
	}
	
	public void criar(Usuario usuario) {
		
		entityManager.persist(usuario);
	}
	
	public boolean verificarExistencia(Usuario usuario) {
		
		return entityManager.contains(usuario);
	}
	
	public void remover(Usuario usuario) {
		
		// Verifica a existencia do usuario
		if (!verificarExistencia(usuario)) {
			// Inclui uma instancia do usuario a ser deletado no contexto de persistencia
			usuario = entityManager.merge(usuario);
		}
		
		// Por fim, deleta o usuario:
		entityManager.remove(usuario);
		
	}
	
	
}
