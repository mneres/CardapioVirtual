<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<link rel="stylesheet" type="text/css" href="../static/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="../static/css/bootstrap-theme.min.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adding new Suggestion</title>
</head>
<body>
	<center>		
		<form:form method="post" modelAttribute="User" action="add">
			<form:label path="email">E-mail</form:label>
			<form:input path="email" />
			
			</br>
			<form:label path="name">Nome</form:label>
			<form:input path="name" />

			</br>
			<form:label path="phone">Telefone</form:label>
			<form:input path="phone" />

			</br>
			<form:label path="secondPhone">Telefone 2</form:label>
			<form:input path="secondPhone" />

			</br>
			<form:label path="dateBirth">Data de nascimento</form:label>
			<form:input path="dateBirth" />

			</br>
			<form:label path="cpf">CPF</form:label>
			<form:input path="cpf" />
			
			</br>
			<form:label path="password">Senha</form:label>
			<form:input path="password" />

			</br>
			<h1>Endereço:</h1>

			</br>
			<form:label path="street">Rua</form:label>
			<form:input path="street" />

			</br>
			<form:label path="number">Número</form:label>
			<form:input path="number" />

			</br>
			<form:label path="neighborhood">Bairro</form:label>
			<form:input path="neighborhood" />

			</br>
			<form:label path="code">CEP</form:label>
			<form:input path="code" />

			</br>
			<form:label path="city">Cidade</form:label>
			<form:input path="city" />
			
			</br>
		
			<input type="submit" class="btn btn-danger"/>
			<button type="button" class="btn btn-danger">Action</button>
		</form:form>
		
	</center>
</body>
</html>