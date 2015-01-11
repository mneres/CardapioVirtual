<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cardápio Virtual</title>
</head>
<body>
<%@include file="common/menu.jsp" %>
	     <div class="container">
	     	<div class="">
			  <h3 align="center" style="color: #8B814C; font-family: cursive;">
				Diga-nos sua localização, para facilitar <br/> sua busca por um Restaurante!
			  </h3>
			  <br />
				  <form method="GET" action="searchAddress">
					  <input type="text" name="cep" id="cep" class="form-control" placeholder="Digite seu CEP: Ex.: 99999-999" aria-describedby="basic-addon1">
					  <div style="width: 100%; margin-top: 5px" align="center"> 
						<input type="submit" name="enviar" value="Buscar Endereço" class="btn btn-default btn-success" style="width: 100%" />
					  </div>
				  </form>
			</div>
          </div>
          
          <br/><br/><br/><br/>
          
					<div class="container-fluid">
                          <ul class="list-inline"  align="center">
                            <li>
								<div align="center" class="thumbnail">
									<img src="${pageContext.request.contextPath}/static/img/p1.png" alt="" width="100px" height="100px"> 
									<p><br/>Defina um Local para Busca</p>
	                 	    	</div>
                            </li>
                            <li>
								<div align="center" class="thumbnail">
									<img src="${pageContext.request.contextPath}/static/img/p2.png" alt="" width="100px" height="100px">
									<p><br/>Escolha um Restaurante</p>
	                 	 		</div>
                            </li>
                            <li>
								<div align="center" class="thumbnail">
									<img src="${pageContext.request.contextPath}/static/img/p3.png" alt="" width="100px" height="100px">
									<p>Escolha e Adicione produtos <br/> em sua Bandeja</p>
								</div>
                            </li>
                            <li>
								<div align="center" class="thumbnail">
									<img src="${pageContext.request.contextPath}/static/img/p4.png" alt="" width="100px" height="100px">
									<p><br/>Defina a Forma de Pagamento</p>
								</div>
                            </li>
                            <li>
								<div align="center" class="thumbnail">
									<img src="${pageContext.request.contextPath}/static/img/p5.png" alt="" width="100px" height="100px">
									<p><br/>Selecione Local para Entrega</p>
								</div>
                            </li>
                          </ul>
                  </div><!--/container-->
</body>
</html>