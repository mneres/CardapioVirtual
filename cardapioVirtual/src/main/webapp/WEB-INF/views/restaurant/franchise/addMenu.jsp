<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="${pageContext.request.contextPath}/static/js/myJs/addMenu.js"></script>

</head>
<body>
<%@include file="../../common/menuFixed.jsp" %>
<div class="alert alert-info" role="alert" id="msg"></div>
	 <div class="container">
		<form method="POST">
			<%
				String f = request.getAttribute("franchise").toString();
			%>
			<label for="name">Nome do Menu</label>
			<input type="text" name="name" id="name" class="form-control" placeholder="Name of Menu" aria-describedby="basic-addon1">
			<br/>
			<input type="button" class="btn btn-primary" style="width: 100%" value="Cadastrar" onclick="addNewMenu(<%=f%>);"/>
		</form>
	</div>
</body>
</html>