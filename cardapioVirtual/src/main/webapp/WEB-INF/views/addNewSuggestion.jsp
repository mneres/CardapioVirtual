<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adding new Suggestion</title>
</head>
<body>

	${msg}

	<center>		
		<form:form method="post" modelAttribute="addSug" action="addSuggestion">
			<form:label path="">Título</form:label>
			<form:input path="title" />
			
			</br>
			<form:label path="description">Descrição de sugestão</form:label>
			<form:input path="description" />
			
			</br>
			<form:label path="email">E-mail para contato</form:label>
			<form:input path="email" />
			
			</br>
			<input type="submit" />
		</form:form>
		
	</center>
</body>
</html>