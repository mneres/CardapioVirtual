<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../static/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="../static/css/bootstrap-theme.min.css">
<title>Editar Usuário</title>

<script src="${pageContext.request.contextPath}/static/js/myJs/addUser.js"></script>

</head>
<body>
<%@include file="../common/menu.jsp" %>
<c:if test="${empty userId}">
	<c:redirect url="${request.getContextPath()}/login/logar"/>
</c:if>

<%@page import = "org.cardapio.virtual.model.beans.User,
				  org.cardapio.virtual.model.db.dao.UserDao,
				  org.cardapio.virtual.model.db.dao.UserDaoJPA" %>
				  
<%
	String id = session.getAttribute("userId").toString();
	UserDao usDao = new UserDaoJPA();
	User us = usDao.findById(Long.parseLong(id));
%>

<div class="alert alert-info" role="alert" id="msg"></div>
<div class="container-fluid">
	<h1 align="center">Complete seu Cadastro!</h1>
	<div style="margin-left: 100px; margin-right: 100px; margin-top: 30px">
		<form method="post" modelAttribute="User" action="edit">
			<p align="center" ><b>Dados Pessoais</b></p>
			
			<br>	
			<label for="email">E-mail:</label>
			<input type="text" name="email" id="email" class="form-control" 
				placeholder="E-mail" aria-describedby="basic-addon1" disabled="true" value="<%= us.getEmail()%>">
			
			<br>	
			<label for="name">Nome:</label>
			<input type="text" name="name" id="name" class="form-control" 
				placeholder="Name" aria-describedby="basic-addon1" value="<%= us.getName()%>">
			
			<br>	
			<label for="phone">Telefone:</label>
			<input type="text" name="phone" id="phone" class="form-control" 
				placeholder="Phone" aria-describedby="basic-addon1" value="<%= us.getPhone()%>">
			
			<br>	
			<label for="secondPhone">Telefone Secundário:</label>
			<input type="text" name="secondPhone" id="secondPhone" class="form-control"
				placeholder="Telefone Secundário" aria-describedby="basic-addon1" value="<%= us.getSecondPhone()%>">
			
			<br>	
			<label for="dateBirth">Data de Nascimento:</label>
			<input type="text" name="dateBirth" id="dateBirth" class="form-control" 
				placeholder="Data de nascimento" aria-describedby="basic-addon1" value="<%= us.getDateBirth()%>">
			
			<br>	
			<label for="cpf">CPF:</label>
			<input type="text" name="cpf" id="cpf" class="form-control" 
				placeholder="CPF" aria-describedby="basic-addon1" value="<%= us.getCpf()%>">
			
			<br/><p align="center" ><b>Endereço</b></p>
			
			<br>	
			<label for="street">Rua:</label>
			<input type="text" name="street" id="street" class="form-control" 
				placeholder="Rua" aria-describedby="basic-addon1" value="<%= us.getAddress().getStreet()%>">
			
			<br>	
			<label for="ad_number">Número:</label>
			<input type="text" name="ad_number" id="ad_number" class="form-control" 
				placeholder="Número" aria-describedby="basic-addon1" value="<%= us.getAddress().getAd_number()%>">
			
			<br>	
			<label for="neighborhood">Bairro:</label>
			<input type="text" name="neighborhood" id="neighborhood" class="form-control" 
				placeholder="Bairro" aria-describedby="basic-addon1" value="<%= us.getAddress().getNeighborhood()%>">
			
			<br>	
			<label for="code">CEP:</label>
			<input type="text" name="code" id="code" class="form-control" 
				placeholder="cep" aria-describedby="basic-addon1" value="<%= us.getAddress().getCode()%>">
			
			<br>	
			<label for="city">Cidade:</label>
			<input type="text" name="city" id="city" class="form-control" 
				placeholder="Cidade" aria-describedby="basic-addon1" value="<%= us.getAddress().getCity()%>">
			
			<br><br>	
			<input type="button" class="btn btn-primary" style="width: 100%" value="Cadastrar"
					 onclick="editUser();"/>
		</form>
	</div>
</div>
</body>
</html>