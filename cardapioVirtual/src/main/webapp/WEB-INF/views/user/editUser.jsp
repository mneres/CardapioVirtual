<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../static/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="../static/css/bootstrap-theme.min.css">
<title>Editar Usuário</title>
</head>
<body>
	<h1 align="center">Edit de Usuário</h1>
	<div style="margin-left: 100px; margin-right: 100px; margin-top: 30px">
		<form method="post" modelAttribute="User" action="add">
			<br>	
			<label for="email">E-mail:</label>
			<input type="text" name="email" id="email" class="form-control" placeholder="E-mail" aria-describedby="basic-addon1">
			
			<br>	
			<label for="password">Senha:</label>
			<input type="text" name="password" id="password" class="form-control" placeholder="Senha" aria-describedby="basic-addon1">
			
			<br>	
			<label for="RepeatPassword">Repetir Senha:</label>
			<input type="text" name="RepeatPassword" id="RepeatPassword" class="form-control" placeholder="Repetir Senha" aria-describedby="basic-addon1">
				
			<br><br>	
			<input type="submit" class="btn btn-primary" style="width: 100%" value="Cadastrar"/>
		</form>
	</div>
</body>
</html>