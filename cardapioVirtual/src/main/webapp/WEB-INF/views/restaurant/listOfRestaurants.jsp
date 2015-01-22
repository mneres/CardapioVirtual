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
<%@page import = "org.cardapio.virtual.model.beans.Franchise ,java.util.*;" %>
<%@include file="../common/menu.jsp" %>
	<br/><br/><br/><br/><br/>
	    <div class="container-fluid" style="background-color: #f8f8f8 ;border-top: 1px solid #ccc; border-bottom: 1px solid #ccc;">
			<div class="container">
				  <h4 align="center" style="color: #8B814C; font-family: cursive;">
						Busque um restaurante aqui!
				  </h4>
				  <br />
					  <form method="GET" action="listByTypeOrName">
					  		<div class="container-fluid">
                          		<ul class="list-inline"  align="center">
                            		<li>
                            			<input type="text" name="name" value="${restaurantName}" id="name" class="form-control" placeholder="Digite o nome de um restaurante que deseja." aria-describedby="basic-addon1">
                            		</li>
                            		<li>
                            			<input type="text" name="type" value="${restaurantType}" id="type" class="form-control" placeholder="Digite o tipo de culinaria" aria-describedby="basic-addon1">
                            		</li>
                            	</ul>
                            </div>
						  
						  <div style="margin-top: 5px" align="center"> 
							</br>
							<button type="submit" class="btn btn-default btn-success btn-lg">
						  		Buscar &nbsp;<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
							</button>
						  </div>
					   </form>
					   <br />
			</div>
		</div>	
		<div class="container">
		<%
		List<Franchise> list = (List<Franchise>)request.getAttribute("restaurants"); 
		for(Franchise f: list){
		%>
			<div class="row">
				<div class="col-md-3" align="center">
					<div class="col-md-12">
						&nbsp;
					</div>
					<div class="col-md-12">
						<div class="thumbnail">
							<a href="#"><img src="${pageContext.request.contextPath}/static/img/logo.png" alt="" width="180px" height="195px"></a>
						</div>
					</div>
				</div>
				<div class="col-md-9" style="font-size: 12px">
					<h3 href="#"><%= f.getCompany().getCompanyName() %></h3>
					<div class="col-md-12">Status Atual(Aberto/Fechado)</div>
					<div class="col-md-12"><%= f.getTypeFood() %></div>	
					<div class="col-md-12"><%= f.getDescriptionBusiness() %></div>
					<div class="col-md-12">Tempo estimado de entrega</div>
					<div class="col-md-12">KM de distância</div>
					<div class="col-md-12">Nota do restaurante</div>
					<div class="col-md-12">Formas de Pagamento</div>
				</div>
			</div>
			<hr size="3">
		<%
		}
		%>

	
	  	
    </div> <!-- /container -->
</body>
</html>