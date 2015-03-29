<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<!-- BackGround CSS -->
<link href="${pageContext.request.contextPath}/static/css/background.css" rel="stylesheet">
<title>Cardápio Virtual</title>
</head>
<body>
<%@include file="../../common/menuFixed.jsp" %>
	<div class="container-fluid">
		<div class="row vertical-offset-100">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h10 class="panel-title">Bem-Vindo ao Cardápio Virtual - Área para Empresas</h10>
					</div>
						<div class="panel-body">
							<form method="post" action="doLogin">
								<br>	
								<label for="email">E-mail:</label>
								<input type="text" name="email" id="email" class="form-control" placeholder="E-mail" aria-describedby="basic-addon1">
								
								<br>	
								<label for="password">Senha:</label>
								<input type="password" name="password" id="password" class="form-control" placeholder="Senha" aria-describedby="basic-addon1">
					
								<br><br>	
								<input type="submit" class="btn btn-primary" style="width: 100%" value="Entrar"/>
							</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>