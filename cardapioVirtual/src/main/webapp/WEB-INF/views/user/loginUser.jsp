<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Cadastro de Usuário</title>
</head>
<body>
<%@include file="../common/menuFixed.jsp" %>
	<h1 align="center">Logar</h1>
	<div style="margin-left: 100px; margin-right: 100px; margin-top: 30px">
		<form method="post" action="doLogin">
			<br>	
			<label for="email">E-mail:</label>
			<input type="text" name="email" id="email" class="form-control" placeholder="E-mail" aria-describedby="basic-addon1">
			
			<br>	
			<label for="password">Senha:</label>
			<input type="password" name="password" id="password" class="form-control" placeholder="Senha" aria-describedby="basic-addon1">

			<br><br>	
			<input type="submit" class="btn btn-primary" style="width: 100%" value="Cadastrar"/>
		</form>
	</div>
</body>
</html>