<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de produto</title>
</head>
<body>
	<% 
		if(request.getSession().getAttribute("user") == null && request.getSession().getAttribute("senha") == null){
			response.sendRedirect("../../../Mercado/index.jsp");
    	}
    %>
<center>
<form action="/Mercado/cliente" method="post">
	<input type="hidden" name="acao" value="inserir" />
	<label>Nome: </label> <input type="text"  name="nome" /><br/>	
	<label>Email: </label><input  type="text"  name="email" /><br/>
	<label>Telefone:</label> <input type="text" name="telefone" /> <br/>
	<label>Sexo: </label><br/>
	<input type="radio" name="sexo" checked="checked" value="M" />Masculino <br/>
	<input type="radio" name="sexo"  value="F"/>Feminino<br/>
	<input type="submit" value="Cadastrar"/>
</form>
	<c:import url="../comum/opcaoBotoesCliente.jsp" />
</center>

</body>
</html>