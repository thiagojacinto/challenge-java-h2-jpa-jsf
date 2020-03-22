<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Gestão dos Usuários</title>
</head>
<body>
	<header>
		<h1>Gestão dos Usuários</h1>
		<h2>
			<a href="new">Add New usuario</a> &nbsp;&nbsp;&nbsp; <a href="list">List
				All Users</a>

		</h2>
	</header>
	
	<main>
	
		<c:if test="${usuario != null}">
			<c:out value="${acao = 'atualizar'}">
			</c:out>
		</c:if>
		
		<c:if test="${usuario == null}">
			<c:out value="${acao = 'adicionar'}">
			</c:out>
		</c:if>
		
		<form action="${acao }" method="post">
			<table border="1">
			
					<c:if test="${usuario != null}">
            				<h2>Editar usuário:</h2>
     </c:if>
    
					<c:if test="${usuario == null}">
            		<h2>Cadastrar novo usário</h2>
     </c:if>
				

					<c:if test="${usuario != null}">
						<input type="hidden" name="id"
							value="<c:out value='${usuario.id}' />" />
					</c:if>
						<tr>
							<th>Nome:</th>
							<td><input type="text" name="name" size="45"
								value="<c:out value='${usuario.name}' />" /></td>
						</tr>
						<tr>
							<th>Email:</th>
							<td><input type="text" name="email" size="45"
								value="<c:out value='${usuario.email}' />" /></td>
						</tr>
						<tr>
							<th>Senha:</th>
							<td><input type="text" name="country" size="15"
								value="<c:out value='${usuario.senha}' />" /></td>
						</tr>
						<tr>
							<th>DDD:</th>
							<td><input type="text" name="ddd" size="3"
								value="<c:out value='${usuario.ddd}' />" /></td>
						</tr>
						<tr>
							<th>Telefone:</th>
							<td><input type="text" name="ddd" size="15"
								value="<c:out value='${usuario.telefone}' />" /></td>
						</tr>
						<tr>
							<th>Tipo:</th>
							<td><input type="text" name="tipo" size="15"
								value="<c:out value='${usuario.tipo}' />" /></td>
						</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="Save" /></td>
					</tr>
					
				</table>
			</form>
			
	</main>
</body>
</html>