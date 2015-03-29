<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<c:if test="${empty userId}">
	<c:redirect url="${request.getContextPath()}/login/logar"/>
</c:if>
<%@include file="../../common/menu.jsp" %>
<%@page import = "org.cardapio.virtual.model.beans.Product,
				  org.cardapio.virtual.model.beans.EvaluationProduct,
				  org.cardapio.virtual.model.db.dao.ProductDao,
				  org.cardapio.virtual.model.db.dao.ProductDaoJPA,
				  org.cardapio.virtual.model.db.dao.EvaluationProductDao,
				  org.cardapio.virtual.model.db.dao.EvaluationProductDaoJPA" %>
				  
	<div class="container" align="left">
		<div style="color: #FFD700; font-size: 20px">
<%
	String id = (String) request.getAttribute("idProd");
	ProductDao pDao = new ProductDaoJPA();
	Product prod = pDao.findById(Long.parseLong(id));
	
	EvaluationProductDao evaDao = new EvaluationProductDaoJPA();
%>	
	<div class="alert alert-danger" role="alert" align="center"  style="background-color: #EEEED1; font-size: 20px">
		Produto: 
		<%= prod.getDescription() %><br/>
	</div>
	<br/>
<%	
	for(EvaluationProduct e:evaDao.findByProduct(prod)){
		String us = new String();
		if(e.getUser().getName().equals("")){
			us = e.getUser().getEmail();
		}else{
			us = e.getUser().getName();
		}
%>
		<p style="color: #000; text-decoration: underline"><%= us %></p>
	<%
		if(e.getEvaluation() == 5){
	%>
			<span class="glyphicon glyphicon-star"></span>
            <span class="glyphicon glyphicon-star"></span>
            <span class="glyphicon glyphicon-star"></span>
            <span class="glyphicon glyphicon-star"></span>
            <span class="glyphicon glyphicon-star"></span>
    <%
		}else if(e.getEvaluation() == 4){
	%>
			<span class="glyphicon glyphicon-star"></span>
            <span class="glyphicon glyphicon-star"></span>
            <span class="glyphicon glyphicon-star"></span>
            <span class="glyphicon glyphicon-star"></span>
            <span class="glyphicon glyphicon-star-empty"></span> 
    <%
		}else if(e.getEvaluation() == 3){
	%>
			<span class="glyphicon glyphicon-star"></span>
            <span class="glyphicon glyphicon-star"></span>
            <span class="glyphicon glyphicon-star"></span>
            <span class="glyphicon glyphicon-star-empty"></span> 
            <span class="glyphicon glyphicon-star-empty"></span> 
    <%
		}else if(e.getEvaluation() == 2){
	%>
			<span class="glyphicon glyphicon-star"></span>
            <span class="glyphicon glyphicon-star"></span>
            <span class="glyphicon glyphicon-star-empty"></span> 
            <span class="glyphicon glyphicon-star-empty"></span> 
            <span class="glyphicon glyphicon-star-empty"></span> 
    <%		
		}else if(e.getEvaluation() == 1){
	%>
			<span class="glyphicon glyphicon-star"></span>
            <span class="glyphicon glyphicon-star-empty"></span> 
            <span class="glyphicon glyphicon-star-empty"></span> 
            <span class="glyphicon glyphicon-star-empty"></span> 
            <span class="glyphicon glyphicon-star-empty"></span> 
    <%		
		}
	%>
		<br/>
		<p style="color: #000; font-size: 14px">Comentário: <%= e.getComment() %></p>
		<p style="color: #000; font-size: 14px">Data: <%= e.getData() %></p>
		<hr size="5"/>
<%
	}
%>
		</div>
	</div>
</body>
</html>