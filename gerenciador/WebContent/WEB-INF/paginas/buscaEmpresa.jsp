<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Busca Empresa</title>
</head>
<body>
Resultado da busca:

<!--tag ul = para exibir em lista, forEach = var(varialvel "empresa") items(Item da requisição passada como empresa)-->
<ul>
<c:forEach var="empresa" items="${empresas }" >
<!--Exibindo id e nome da empresa dentro do for -->
	<li>${empresa.getId() }: ${empresa.nome }</li>

</c:forEach >

</ul>
</body>
</html>