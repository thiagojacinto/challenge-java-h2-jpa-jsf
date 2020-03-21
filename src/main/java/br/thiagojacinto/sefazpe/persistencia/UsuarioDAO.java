package br.thiagojacinto.sefazpe.persistencia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.thiagojacinto.sefazpe.negocio.Usuario;

public class UsuarioDAO {

	/*
	 * 		Gerenciador de comunicação com a database.
	 */

	// GET ALL - getResultsList();
	@SuppressWarnings("unchecked")	// Esconder warning.
	public List<Usuario> mostrarTodos() {
		
		Transaction transaction = null;
		List<Usuario> listaDeUsuarios = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// Começa a transação:
			transaction = session.beginTransaction();
			
			// Hibernate para pegar todos os resultados:
			listaDeUsuarios = session.createQuery("from Usuario").getResultList();
			
			System.out.println("-> Usuarios encontrados? " + listaDeUsuarios.toString());
			// e `commita` essa mudança na sessão:
			transaction.commit();

		} catch (Exception e) {

			e.printStackTrace();

			if (transaction != null) {
				transaction.rollback();
			}
		}

		return listaDeUsuarios;
	}

	// GET - get()
	public Usuario procurar(int id) {
		Transaction transaction = null;
		Usuario usuario = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// Começa a transação:
			transaction = session.beginTransaction();
			// na sessão, proucra o usuario e salva na variavel local:
			usuario = session.get(Usuario.class, id);
			System.out.println("-> Usuario encontrado? " + usuario.toString());
			// e `commita` essa mudança na sessão:
			transaction.commit();

		} catch (Exception e) {

			e.printStackTrace();

			if (transaction != null) {
				transaction.rollback();
			}
		}

		return usuario;
	}

	// POST - save()
	public void adicionar(Usuario usuario) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// Começa a transação:
			transaction = session.beginTransaction();
			// na sessão, salva o usuario:
			session.save(usuario);
			System.out.println("-> Usuario salvo.");
			// e `commita` essa mudança na sessão:
			transaction.commit();

		} catch (Exception e) {

			e.printStackTrace();

			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	// PUT - update()
	public void atualizar(Usuario usuario) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// Começa a transação:
			transaction = session.beginTransaction();
			// na sessão, ATUALIZA o usuario:
			session.update(usuario);
			System.out.println("-> Usuario atualizado.");
			// e `commita` essa mudança na sessão:
			transaction.commit();

		} catch (Exception e) {

			e.printStackTrace();

			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	// DELETE - delete()
	public void deletar(int id) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// Começa a transação:
			transaction = session.beginTransaction();
			// primeiro, procurar o usuário dentro do repositório:
			Usuario procurado = session.get(Usuario.class, id);
			// verifica se existe (NÃO nulo)
			if (procurado != null ) {
				// por fim, na sessão, DELETE o usuario:
				session.delete(procurado);
				System.out.println("-> Usuario deletado.");
			}
			// e `commita` essa mudança na sessão:
			transaction.commit();

		} catch (Exception e) {

			e.printStackTrace();

			if (transaction != null) {
				transaction.rollback();
			}
		}
	}



}
