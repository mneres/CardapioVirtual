<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">

<!-- BackGround CSS -->
    <link href="${pageContext.request.contextPath}/static/css/shop-item.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/static/css/navbar-static-top.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="${pageContext.request.contextPath}/static/js/assets/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
    <!-- MENU -->
	<nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="<%=request.getContextPath()%>" style="width: 300px">
          	<img src="${pageContext.request.contextPath}/static/img/cardapio_virtual.png" width="80" height="30"/>
          </a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <c:if test="${not empty AddressCep}">
	          <ul class="nav navbar-nav">
	          	<li>
	          		<a href="<%=request.getContextPath()%>/restaurants/listByAddress?destination=${AddressCep}&distance=10"
	          			 class="navbar-brand" style="cursor: pointer;">
	          		<span class="glyphicon glyphicon-map-marker"></span>
	                 ${AddressCep} - ${AddressLogradouro}</a>
	            	<a class="navbar-brand" href="<%=request.getContextPath()%>/changeAddress" style="text-decoration: underline">
	            		<h6>Alterar Local</h6>
	            	</a>
	            </li>
	          </ul>
          </c:if>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="<%=request.getContextPath()%>/user/addUser"><p>Cadastre-se</p></a></li>
            <li><a href="<%=request.getContextPath()%>/login/logar"><p>Entrar</p></a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>   
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${pageContext.request.contextPath}/static/js/assets/ie10-viewport-bug-workaround.js"></script>
</body>
</html>