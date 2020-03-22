<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
</head>
<body>
	<header>
		<h1>User Management</h1>
		<h2>
			<a href="cadastro">Adicionar novo usuário</a> &nbsp;&nbsp;&nbsp; <a href="lista">Lista de Usuários</a>
		</h2>
	</header>
	
	<main>
		<table border="1">
			<caption>Lista de Usuários</caption>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Email</th>
				<th>Telefones</th>
			</tr>
			<c:forEach var="usuario" items="${listaUsuario}">
				<tr>
					<td><c:out value="${usuario.id}" /></td>
					<td><c:out value="${usuario.name}" /></td>
					<td><c:out value="${usuario.email}" /></td>
					<td><c:out value="${usuario.telefones}" /></td>
					<td><a href="edit?id=<c:out value='${usuario.id}' />">Editar</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="delete?id=<c:out value='${usuario.id}' />">Remover</a></td>
				</tr>
			</c:forEach>
		</table>
	</main>
</body>
</html>