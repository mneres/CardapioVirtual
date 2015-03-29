<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Home</title>
</head>
<body>
<%@include file="../common/menu.jsp" %>
<c:if test="${empty userId}">
	<c:redirect url="${request.getContextPath()}/login/logar"/>
</c:if>

<%@page import = "org.cardapio.virtual.model.beans.User,
 				  org.cardapio.virtual.model.beans.Product,
 				  org.cardapio.virtual.model.beans.Company,
				  org.cardapio.virtual.model.db.dao.UserDao,
				  org.cardapio.virtual.model.db.dao.UserDaoJPA,
				  org.cardapio.virtual.model.db.dao.RecomendationDao,
				  org.cardapio.virtual.model.db.dao.RecomendationDaoJDBC,
				  java.util.List" %>
<%
	String id = session.getAttribute("userId").toString();
	UserDao usDao = new UserDaoJPA();
	User us = usDao.findById(Long.parseLong(id));
	RecomendationDao pdao = new RecomendationDaoJDBC();
	List<Product>lst = pdao.recomendation(Long.parseLong(id));
%>

	<div class="alert alert-warning" role="alert">
		<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
		Já completou seu Cadastro?&nbsp; 
		<a class="btn btn-warning" href="../user/editUser" role="button">Clique aqui para Editar seu Perfil</a>
	</div>
	
	<div class="container">
		<div class="row">
            <div class="col-xs-12 col-md-3" align="left">
            	Utilize seu endereço cadastrado para Busca!
            	<a href="../searchAddress?cep=<%=us.getAddress().getCode() %>">CEP: <%=us.getAddress().getCode() %></a>
            </div>
        </div>
        </br>
  		<p><h3 align="center">Recomendamos para Você: </h3></p>
		</br>
		<div class="row">
		<%
			for(Product e:lst){
				Company c = pdao.CompanylistByProduct(e.getId());
		%>
			<div class="col-xs-6 col-sm-4" style="border: 5px solid #ccc; height: 150px">
				<p align="center" style="font-size: 14px"><a href="#"><%=e.getDescription() %></a></p>
				<p><b>Ingredientes: </b><%=e.getIngredients() %></p>
				<p><b>Preço: </b> <%=e.getPrice() %></p>
				<p><b>Empresa: </b> <%=c.getCompanyName() %></p>
			</div>
		<%	
			}
		%>
		</div>
	</div>
</body>
</html>