<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Erro</title>
</head>
<body>
	<header>
		<h1>Erro encontrado:</h1>
		<h2><%= exception.getMessage() %><br />
		</h2>
	</header>
</body>
</html>