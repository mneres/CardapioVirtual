<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- Shop Item CSS -->
    <link href="${pageContext.request.contextPath}/static/css/shop-item.css" rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import = "org.cardapio.virtual.model.beans.Franchise, 
					org.cardapio.virtual.model.beans.Menu, 
					org.cardapio.virtual.model.beans.Product,
					java.util.List" %>
<%@include file="../common/menu.jsp" %>

<%
	Franchise f = (Franchise)request.getAttribute("restaurant");
	List<Menu> listMenu = (List<Menu>)request.getAttribute("menu");
%>
<div class="container">
	<div class="well" style="background-color: #EEEED1">
		<div class="row">
			<div class="col-md-4">
				<div class="media">
  					<div class="media-left media-middle">
  					<div class="thumbnail">
            			<img class="media-object"
            				src="${pageContext.request.contextPath}/static/img/logo.png" 
            				alt="">
            		</div>
            		</div>
            	</div>
			</div>
			<div class="col-md-4">
				<h1 align="center"><%= f.getCompany().getCompanyName() %></h1>
			</div>	
			<div class="col-md-4">
				Coisas
			</div>
		</div>	
		
	</div>
<%
	for(Menu menu: listMenu){		
%>
	<div class="alert alert-danger" role="alert" align="center"  style="background-color: #EEEED1">
      <p><strong><%=menu.getName()%></strong></p>
    </div>
	<%
		for (Product p : menu.getProduct()){
	%>
		<div class="row">
			<div class="col-md-8" style="font-size: 12px">
				<h3><%= p.getDescription() %></h3>
				<div class="col-md-12"><%= p.getIngredients() %></div>	
			</div>
			<div class="col-md-2">
				<div class="col-md-12">Preço<br/><%= p.getPrice() %></div>
			</div>
			<div class="col-md-2">
				<button type="button" class="btn btn-default" title="Adicionar produto ao carrinho" 
						aria-label="Left Align" style="color:#00CD00">
				  <span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
				</button>
				<button type="button" class="btn btn-default"  title="Ver comentários sobre o produto" 
						aria-label="Left Align" style="color:#4169E1">
				  <span class="glyphicon glyphicon-comment" aria-hidden="true"></span>
				</button>
			</div>
		</div>
		<hr size="1" style="border-top: 1px solid #ccc"/>
	<%}
}%>
</div>

</body>
</html>