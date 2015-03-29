<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/static/js/myJs/addProduct.js"></script>
<script>
	
	function addProduct(id){
		var h = 550;
		var w = 700;
		openWindow("../franchise/addProduct?idfranchise=" + id, h, w);
	}
	
	function listEvaluation(id){
		var h = 500;
		var w = 700;
		openWindow("../restaurants/listEvaluation?idProd=" + id, h, w);
	}

	
	function editProduct(id, prod){
		var h = 550;
		var w = 700;
		openWindow("../franchise/editProduct?idfranchise="+id+"&product="+prod, h, w);
	}
	
	function addMenu(id){
		var h = 300;
		var w = 700;
		openWindow("../franchise/addMenu?idfranchise=" + id, h, w);
	}

	function openWindow(page, h, w){
		LeftPosition = (screen.width) ? (screen.width-w)/2 : 0;
		TopPosition = (screen.height) ? (screen.height-h)/2 : 0;
		settings = 'height='+h+',width='+w+',top='+TopPosition+',left='+LeftPosition+',scrollbars=0,resizable';
		myWindow = window.open(page, 
				"myWindow", settings);
	}
</script>
</head>
<body>
<%@page import = "org.cardapio.virtual.model.beans.Franchise, 
					org.cardapio.virtual.model.beans.Menu, 
					org.cardapio.virtual.model.beans.Product,
					java.util.List" %>
<%@include file="../../common/menuFranchise.jsp" %>

<c:if test="${not empty msg}">
	<div class="msg" role="alert">${msg}</div>
</c:if>

<%
	Franchise f = (Franchise)request.getAttribute("franchise");
	List<Menu> listMenu = (List<Menu>)request.getAttribute("menu");
%>
<div id="wrapper">
        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                     <a class="navbar-brand" href="<%=request.getContextPath()%>" style="width: 300px">
			          	<img src="${pageContext.request.contextPath}/static/img/cardapio_virtual.png" width="80" height="30"/>
			         </a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><%= f.getCompany().getCompanyName() %><b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="logoff">Sair</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li class="active">
                        <a href="index.html">Página Principal</a>
                    </li>
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo">
                        Editar Dados</a>
                        <ul id="demo" class="collapse">
                            <li>
                                <a onclick="addMenu(<%= f.getId()%>)">Adicionar Menu</a>
                            </li>
                            <li>
                                <a onclick="addProduct(<%= f.getId()%>)">Adicionar Produtos</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="charts.html"></i>Avaliações</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">
            <div class="container-fluid" style="background-color: #fff">
            	<div class="well" style="background-color: #EEEED1">
            		<div class="row">
            			<div class="col-md-4">
            				<div class="media">
              					<div class="media-left media-middle">
              					<div class="thumbnail">
                        			<img class="media-object"
                        				src="${pageContext.request.contextPath}/static/img/logo.png" 
                        				alt="">
                        		</div>
                        		</div>
                        	</div>
            			</div>
            			<div class="col-md-4">
            				<h1 align="center"><%= f.getCompany().getCompanyName() %></h1>
            			</div>	
            			<div class="col-md-4">
            				Coisas
            			</div>
            		</div>	
		
	           </div>
                <div style="width: 100%" align="center">
                	<p>
                		<a class="btn btn-primary" onclick="addMenu(<%= f.getId()%>)" role="button">Adicionar Menu</a>
                        <a class="btn btn-primary" onclick="addProduct(<%= f.getId()%>)" role="button">Adicionar Produto</a>
                    </p>
                </div>
				<%
					for(Menu menu: listMenu){		
				%>
					<div class="alert alert-danger" role="alert" align="center"  style="background-color: #EEEED1">
				      <div class="row">
					      <p><strong><%=menu.getName()%></strong></p>
						<a class="btn btn-primary" role="button" 
							onclick="">
							<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
						</a>
						<a class="btn btn-primary" role="button" 
							onclick="">
							<span class="glyphicon glyphicon-minus-sign" aria-hidden="true"></span>
						</a>
				      </div>
				    </div>
					<%
						for (Product p : menu.getProduct()){
					%>
						<div class="row">
							<div class="col-md-7" style="font-size: 12px">
								<h3><%= p.getDescription() %></h3>
								<div class="col-md-12"><%= p.getIngredients() %></div>	
							</div>
							<div class="col-md-2">
								<div class="col-md-12">Preço<br/><%= p.getPrice() %></div>
							</div>
							<div class="col-md-3">
								<a class="btn btn-primary" role="button" 
									onclick="editProduct(<%=menu.getFranchise().getId()%>,<%=p.getId()%>);">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
								</a>
								<a class="btn btn-primary" role="button" 
									onclick="removeProduct(<%=menu.getId()%>,<%=p.getId()%>);">
									<span class="glyphicon glyphicon-minus-sign" aria-hidden="true"></span>
								</a>
								<a class="btn btn-primary" role="button" onclick="listEvaluation(<%= p.getId() %>);">
									<span class="glyphicon glyphicon-comment" aria-hidden="true"></span>
								</a>
							</div>
						</div>
						<hr size="1" style="border-top: 1px solid #ccc"/>
					<%}
				}%>
        </div>
    </div>
</div>
</body>
</html>