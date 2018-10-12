<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<c:if test="${not empty usuarioLogado}">
	Usuario logado: ${usuarioLogado.email }<br/>
</c:if>
<c:if test="${empty usuarioLogado}">
	Usuario Invalido<br/>
</c:if>

</body>
</html>