<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login do ususario</title>
</head>
<body>
<center>
<!-- mundaças no repoitorio... -->
<h1>Bem vindo!!!</h1>
<form action="../Mercado/login" method="post">
	<input type="hidden" name="acao" value="Logar"/>
	<td> Usuario <input type="text" name="user" /></td><br><br>
	<td> Senha <input type="password" name="senha" /></td>
	<br><br>
	<input type="submit" value="Login" />
	<h1>.....</h1>
	</div>	
	</form>
</center>
</body>
</html>