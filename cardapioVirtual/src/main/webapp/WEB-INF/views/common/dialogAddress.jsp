<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<a class="" href="<%=request.getContextPath()%>/changeAddress" style="color: #ff0000; text-size: 7px">
            <span class="glyphicon glyphicon-flag"></span>
                 ${AddressCep} - ${AddressLogradouro}
            <p><h6>Clique aqui para Alterar o Local</h6></p>
       </a>
</body>
</html>