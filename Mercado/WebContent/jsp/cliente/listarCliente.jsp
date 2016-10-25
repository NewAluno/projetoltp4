<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de CLiente</title>
</head>
<body>
<% 
		if(session.getAttribute("user") == null && session.getAttribute("senha") == null){
			response.sendRedirect("../../../Mercado/index.jsp");
    	}
    %>
<center>
<c:choose>
<c:when test="${clientes.size()>0}">
	
		<table border="1">
			<tr>
			<td>Nome</td>
			<td>E-mail</td>
			<td>Telefone</td>
			<td>Sexo</td>
			<td></td>
			<td></td>
			
			</tr>
			<c:forEach var="c" items="${clientes}">
			<tr>
			<td>${c.nome}</td>
			<td>${c.email}</td>
			<td>${c.telefone}</td>
			<td>${c.sexo}</td>
			<td><a href="/Mercado/cliente?acao=Consultar&id=${c.id}"/>Alterar</td>
			<td><a href="/Mercado/cliente?acao=Excluir&id=${c.id}"/>Excluir</td>
			</tr>
			</c:forEach>
		</table>

	
</c:when>	
	<c:otherwise>
	<h1> n�o exite nenhum cliente cadastrado!</h1>
	<P><input type="button" onclick="location='/Mercado/jsp/cliente/cadastroCliente.jsp'" value="Cadastar novo produto"><br/>
	</c:otherwise>
</c:choose>	
 <input type="button" onclick="location='/Mercado/jsp/menuPrincipal.jsp'" value="Voltar ao menu principal"><br/>
 </center>
</body>
</html>