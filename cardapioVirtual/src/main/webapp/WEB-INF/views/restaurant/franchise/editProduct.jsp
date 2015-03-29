<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="${pageContext.request.contextPath}/static/js/myJs/addProduct.js"></script>

<script>
	window.onbeforeunload = function () {
		window.opener.location.reload();
	}
</script>
	
</head>
<body>
<%@page import = "org.cardapio.virtual.model.beans.Franchise, org.cardapio.virtual.model.beans.Product, org.cardapio.virtual.model.beans.Menu,
					org.cardapio.virtual.model.db.dao.MenuDao, org.cardapio.virtual.model.db.dao.MenuDaoJPA,
					org.cardapio.virtual.model.db.dao.FranchiseDao, org.cardapio.virtual.model.db.dao.FranchiseDaoJPA,
					org.cardapio.virtual.model.db.dao.ProductDao, org.cardapio.virtual.model.db.dao.ProductDaoJPA,
					java.util.*;" %>
<%@include file="../../common/menuFixed.jsp" %>
	<div class="alert alert-info" role="alert" id="msg"></div>
	<%! Product p = new Product(); %>
	<%
		String prod = request.getAttribute("product").toString();
	 	List<Menu> lst = new ArrayList<Menu>();
	 	
		if(!prod.isEmpty()){
			ProductDao pdao = new ProductDaoJPA();
			p = pdao.findById(Long.parseLong(prod));
		}
	%>
	<div class="container">
		<form method="POST" modelAttribute="Product" action="../menu/addProd">
			<br/>	
			<label for="description">Descrição</label>
			<input type="text" value="<%=p.getDescription()%>" name="description" id="description" class="form-control" placeholder="description" aria-describedby="basic-addon1">
			
			<br>	
			<label for="ingredients">Ingredientes</label>
			<input type="text" value="<%=p.getIngredients()%>" name="ingredients" id="ingredients" class="form-control" placeholder="Ingredientes" aria-describedby="basic-addon1">
			
			<br>	
			<label for="price">Preço</label>
			<input type="text" value="<%=p.getPrice()%>" name="price" id="price" class="form-control" placeholder="Preço" aria-describedby="basic-addon1">
				
			<br><br>	
			<input type="button" class="btn btn-primary" style="width: 100%" value="Cadastrar" onclick="editProduct(<%=p.getId()%>);"/>
		</form>	
	</div>
</body>
</html>