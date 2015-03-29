<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Insert title here</title>

<script src="${pageContext.request.contextPath}/static/js/myJs/addEvaluation.js"></script>

</head>
<body>
<c:if test="${empty userId}">
	<c:redirect url="${request.getContextPath()}/login/logar"/>
</c:if>

<%@page import = "org.cardapio.virtual.model.beans.Product,
				  org.cardapio.virtual.model.db.dao.ProductDao,
				  org.cardapio.virtual.model.db.dao.ProductDaoJPA" %>
<%
	String id = (String) request.getAttribute("idProd");
	ProductDao pDao = new ProductDaoJPA();
	Product prod = pDao.findById(Long.parseLong(id));
%>

<%@include file="../../common/menu.jsp" %>
	<div class="alert alert-info" role="alert" id="msg"></div>
	<div class="container">
		<div class="alert alert-danger" role="alert" align="center"  style="background-color: #EEEED1">
			Produto: 
			<%= prod.getDescription() %><br/>
		</div>
	</br>
	<label for="evaluation">Nota:</label>
		<form>
			<select class="form-control" name="evaluation" id="evaluation">
			  <option value="0" selected></option>
			  <option value="1">1</option>
			  <option value="2">2</option>
			  <option value="3">3</option>
			  <option value="4">4</option>
			  <option value="5">5</option>
			</select>
			</br>
			<label for="comment">Comentário:</label>
			<textarea class="form-control"  placeholder="Deixe seu comentário" name="comment" id="comment" rows="3"></textarea>
			</br>	
			
			<input type="button" class="btn btn-primary" style="width: 100%" value="Cadastrar"
					 onclick="addEvaluation(${userId}, ${idProd});"/>
		</form>	
	</div>
</body>
</html>