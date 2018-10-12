<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/>

<c:if test="${not empty usuarioLogado}">
	Voce esta logado como: ${usuarioLogado.email }<br/>
</c:if>

<!-- formulario para cadastrar nova empresa, a acao neste formulario ira chamar a pagina 'novaEmpresa' -->
<!-- informando que o metodo que sera usado é o 'POST' -->
<form action="executar" method="POST">
	<!-- textfield para escrever o nome da empresa -->
	Nome: <input type="text" name="nome">
	<input type ="hidden" name = "tarefa" value ="NovaEmpresa" />
	<!-- Botal para cadastrar nova empresa -->
	<input type = "submit" value="Enviar">
</form>

<form action="executar" method="POST">
	E-mail: <input type="email" name="email"/>
	Senha:  <input type="password" name="senha"/>
	<input type ="hidden" name="tarefa" value = "Login" />
	<input type="submit" value="Enviar"/>
</form>

<form action = "executar" method = "POST" >
	<input type = "hidden" name="tarefa" value = "Logout" />
	<input type = "submit" value="Deslogar" />
</form>

</body>
</html>