<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Home</title>
</head>
<body>
<c:if test="${empty userName}">
	<c:redirect url="index"/>
</c:if>
	<h1>Bem vindo ${userName} ao cadastro de usuários!</h1>
	<a href="logout">Logout</a>
	<br>
</body>
</html>