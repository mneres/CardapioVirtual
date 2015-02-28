<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="../common/menuFixed.jsp" %>
<c:choose>
    <c:when test="${not empty error}">
       	${error}
    </c:when>
    <c:when test="${not empty error}">
       	${error}
    </c:when>
    <c:when test="${not empty cep}">
    	<div class="container">
	    	<form method="GET" action="saveAddress" modelAttribute="Cep">
	    		<label for="cep">CEP:</label>
	    		<input type="text" name="cep" id="cep" value="${cep}" class="form-control">
	    		
	    		<label for="bairro">Bairro:</label>
	    		<input type="text" name="bairro" id="bairro" value="${bairro}" class="form-control">
	    		
	    		<label for="logradouro">Rua:</label>
	    		<input type="text" name="logradouro" id="logradouro" value="${logradouro}" class="form-control">
	    		
	    		<label for="localidade">Cidade:</label>
	    		<input type="text" name="localidade" id="localidade" value="${localidade}" class="form-control">
	    		
	    		<label for="numero">Número:</label>
	    		<input type="text" name="numero" id="numero" class="form-control">
		        <br/>
		        <div align="center">
		        	<button type="button" onclick="history.go(-1);" class="btn btn-info">Voltar</button>
		        	<input type="submit" name="Enviar" value ="Enviar" class="btn btn-primary" /> 
		        </div>        
	    	</form>
    	</div>
    </c:when>
    <c:otherwise>
        Null
    </c:otherwise>
</c:choose>

</body>
</html>