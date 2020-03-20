package br.thiagojacinto.sefazpe.negocio;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.thiagojacinto.sefazpe.persistencia.Usuario;
import br.thiagojacinto.sefazpe.persistencia.UsuarioDAO;

@RequestScoped
@Path("usuarios")
@Produces(MediaType.APPLICATION_JSON)	// Configura a saída para JSON
@Consumes(MediaType.APPLICATION_JSON)	// e a entrada também como JSON
public class UsuarioResource {
	
	@Inject
	UsuarioDAO usuarioDAO;	// Injeção do DAO
	
	@GET
	public Response mostrarTodos() {
		return Response.ok(usuarioDAO.mostrarTodos()).build();
	}
	
	@GET
	@Path("{id}")	// Usa o caminho id + requisição tipo GET
	public Response procurarPorId(@PathParam("id") int id) {
		
		Usuario procurado = usuarioDAO.procurarPorId(id);
		
		return Response.ok(procurado).build();
		
	}
	
	@PUT
	@Path("{id}")
	public Response atualizar(@PathParam("id") int id, Usuario usuario) {
		
		// Procurar o usuario:
		Usuario procurado = usuarioDAO.procurarPorId(id);
		
		// Alterar os valores de seus atributos:
		procurado.setEmail(usuario.getEmail());
		procurado.setId(usuario.getId());
		procurado.setNome(usuario.getNome());
		procurado.setSenha(usuario.getSenha());
		procurado.setTelefonesString(usuario.getTelefonesString());
		
		usuarioDAO.atualizar(procurado);
		
		return Response.ok().build();
	}
	
	@POST
	public Response criar(Usuario usuario) {
		usuarioDAO.criar(usuario);
		
		return Response.ok().build();
	}
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") int id) {
		Usuario procurado = usuarioDAO.procurarPorId(id);
		
		usuarioDAO.remover(procurado);
		
		return Response.ok().build();
	}
	
}
