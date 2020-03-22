package br.thiagojacinto.sefazpe.cliente;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.thiagojacinto.sefazpe.negocio.Usuario;
import br.thiagojacinto.sefazpe.persistencia.UsuarioDAO;

/*
 * 		Esse servlet funciona como um controller, 
 * 		lidando com os requests para a aplicação
 */

@WebServlet("/")
public class UsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private UsuarioDAO usuarioDAO;
	
	public void init() {
		// Instancia do DAO
		usuarioDAO = new UsuarioDAO();
	}
	
	protected void doPost(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException {
		doGet(requisicao, resposta);
	}
	
	protected void doGet(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException {
		// caminho da URI
		String acao = requisicao.getServletPath();
		
		try {
			
			switch (acao) {
			
			case "/cadastro":
				novoFormCadastro(requisicao, resposta);
				break;
				
			case "/adicionar":
				adicionar(requisicao, resposta);
				break;
			
			case "/remover":
				remover(requisicao, resposta);
				break;
			
			case "/editar":
				editar(requisicao, resposta);
				break;
			
			case "/atualizar":
				atualizar(requisicao, resposta);
				break;
			
			default:
				listarTodos(requisicao, resposta);
				break;
			}
			
		} catch (Exception e) {
			throw new ServletException(e);
		} 
	}

	private void listarTodos(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException{
		List<Usuario> listaDeUsuarios = usuarioDAO.mostrarTodos();
		requisicao.setAttribute("listaDeUsuarios", listaDeUsuarios);
		// TODO: direcionar o dispacher para algum lugar
		RequestDispatcher dispatcher = requisicao.getRequestDispatcher("lista-usuarios.jsp");
		dispatcher.forward(requisicao, resposta);
		
	}

	private void atualizar(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException {
		// Utilizar os dados vindos da requisição:
		String nome = requisicao.getParameter("nome");
		String email = requisicao.getParameter("email");
		String senha = requisicao.getParameter("senha");
		Integer ddd = Integer.parseInt(requisicao.getParameter("ddd"));
		String numero = requisicao.getParameter("numero");
		String tipo = requisicao.getParameter("tipo");
		
		Usuario usuario = new Usuario(nome, email, senha, ddd, numero, tipo);
		usuarioDAO.atualizar(usuario);
		resposta.sendRedirect("lista");
		
	}

	private void editar(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException {
		int idProcurado = Integer.parseInt(requisicao.getParameter("id"));
			
		Usuario procurado = usuarioDAO.procurar(idProcurado);
		//TODO: direcionar o dispacher EDITAR para algum lugar
		RequestDispatcher dispatcher = requisicao.getRequestDispatcher("form-cadastro.jsp");
		requisicao.setAttribute("usuario", procurado);
		dispatcher.forward(requisicao, resposta);
	}

	private void remover(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException {
		int idProcurado = Integer.parseInt(requisicao.getParameter("id"));
		
		usuarioDAO.deletar(idProcurado);
		resposta.sendRedirect("lista");
		
	}

	private void adicionar(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException {
		// Utilizar os dados vindos da requisição:
		String nome = requisicao.getParameter("nome");
		String email = requisicao.getParameter("email");
		String senha = requisicao.getParameter("senha");
		Integer ddd = Integer.parseInt(requisicao.getParameter("ddd"));
		String numero = requisicao.getParameter("numero");
		String tipo = requisicao.getParameter("tipo");

		Usuario usuario = new Usuario(nome, email, senha, ddd, numero, tipo);
		usuarioDAO.adicionar(usuario);
		resposta.sendRedirect("lista");
		
	}

	private void novoFormCadastro(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = requisicao.getRequestDispatcher("form-cadastro.jsp");
		dispatcher.forward(requisicao, resposta);
		
	}
	
}
