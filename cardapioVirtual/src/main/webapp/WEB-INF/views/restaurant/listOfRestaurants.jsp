<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- Shop Item CSS -->
    <link href="${pageContext.request.contextPath}/static/css/shop-item.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/static/css/background_default.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import = "org.cardapio.virtual.model.beans.Franchise ,java.util.*;" %>
<%@include file="../common/menu.jsp" %>
	<c:if test="${empty AddressCep}">
	   <c:redirect url="<%=request.getContextPath()%>"/>
	</c:if>
			<div class="container" style="width: 100%">
					  <form method="GET" action="listByTypeOrName" style="width: 100%">
                          		<ul class="list-group-item"  align="center" style="list-style: none;">
                          		  <h4 align="center" style="color: #8B814C; font-family: cursive;">
										Filtre sua Busca!
								  </h4>
                            	   	<li>
                            			<h5 align="left">Nome do Restaute</h5>
                            			<input type="text" name="name" value="${restaurantName}" id="name" class="form-control" placeholder="Digite o nome de um restaurante que deseja." aria-describedby="basic-addon1">
                            		</li>
                                    <li>
                                        <h5 align="left">Selecione o tipo de culinaria</h5>
                                        <select class="form-control" name="type" id="type">
                                                <option value="">Todos</option>
                                                <option>Mustard</option>
                                                <option>Ketchup</option>
                                                <option>Relish</option>
                                         </select>
                            		</li>
                            		<li>
                                        <h5 align="left">Distância</h5>
                                        <input type="text" name="distance" value="10" id="distance" class="form-control" placeholder="Valor em KM" aria-describedby="basic-addon1">
                            		</li>
                            		<br/>
                            		<li>
                            			<button type="submit" class="btn btn-default btn-success btn-lg">
										  		<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
											</button>
                            		</li>
                            	</ul>
					   </form>
					   <br />
			</div>
		<div class="container">
			<div id="products" class="row list-group">
		<%
		List<Franchise> list = (List<Franchise>)request.getAttribute("restaurants"); 
		for(Franchise f: list){
		%>
		
			<div class="item  col-xs-4 col-lg-4 grid-group-item list-group-item">
            	<div class="thumbnail">
            		<img class="group list-group-image" src="${pageContext.request.contextPath}/static/img/logo.png" alt="">
            		<div class="caption">
                    <h4 class="group inner list-group-item-heading">
                        <a href="listById?id=<%= f.getId() %>"><%= f.getCompany().getCompanyName() %></a></h4>
                    <div class="ratings">
	                   <p class="pull-right">3 reviews</p>
	                   <p>
	                      <span class="glyphicon glyphicon-star"></span>
	                      <span class="glyphicon glyphicon-star"></span>
	                      <span class="glyphicon glyphicon-star"></span>
	                      <span class="glyphicon glyphicon-star"></span>
	                      <span class="glyphicon glyphicon-star-empty"></span>                           
	                   </p>
	                </div>
                    <p>
                    	Status Atual(Aberto/Fechado)
                    	<%= f.getId() %>
                    </p>
                    <p>
                    	<%= f.getTypeFood() %>
                    </p>
                    <p class="group inner list-group-item-text">
                    <%= f.getDescriptionBusiness() %></p>
                    <div class="row">
                        <div class="col-xs-12 col-md-6">
                            <p>
                            Tempo estimado de entrega</p>
                        </div>
						<div class="col-xs-12 col-md-6">
                            <p>
                            KM de distância</p>
                        </div>
                        <div class="col-xs-12 col-md-6">
                            <p>
                            Formas de Pagamento</p>
                        </div>
                    </div>
                </div>
             </div>
           </div>
		<%
		}
		%>
	  	 </div> <!-- /product -->	
    </div> <!-- /container -->
</body>
</html>