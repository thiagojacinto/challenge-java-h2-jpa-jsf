package br.thiagojacinto.sefazpe.negocio;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
}
