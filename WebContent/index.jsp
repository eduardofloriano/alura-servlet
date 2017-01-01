<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	Bem vindo ao nosso gerenciador de empresas<c:if test="${not empty usuarioLogado}">, ${usuarioLogado.email}</c:if>.
	<br />
	<form action="executa" method="POST">
		Nome: <input type="text" name="nome" /> <br /> <input type="submit"
			value="Enviar" />
			<input type="hidden" name="tarefa" value="AdicionaEmpresa" />
	</form>


	<form action="executa" method="POST">
		Email: <input type="email" name="email" /> Senha: <input
			type="password" name="senha" /> <input type="submit" value="login" />
			<input type="hidden" name="tarefa" value="Login" />
	</form>

	<form action="executa" method="POST">
		<input type="submit" value="Deslogar" />
		<input type="hidden" name="tarefa" value="Logout" />
	</form>
</body>
</html>