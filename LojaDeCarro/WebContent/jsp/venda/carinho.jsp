<%@page import="br.com.entidade.Cliente"%>
<%@page import="br.com.entidade.Venda"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>carinho de compras</title>
</head>
<body>
	<c:if test="${user==null && senha==null}">
		<c:redirect url="../../../Mercado/index.jsp" />
	</c:if>
	<% Venda v = (Venda)request.getSession().getAttribute("venda");%>
	<%	Cliente  c =   v.getCliente(); 	%>
	
	<table border="1">
			<tr>
			<td>Nome</td>
			<td>E-mail</td>
			<td>Telefone</td>
			<td>Sexo</td>
			<td></td>
			<td></td>
			
			</tr>
			
			<tr>
			
			<td><a><%= c.getNome() %></a></td>
			<td><a><%= c.getEmail() %></a></td>
			<td><a><%= c.getTelefone() %></a></td>
			<td><a><%= c.getSexo() %></a></td>
			<td><a href="/Mercado/cliente?acao=Consultar&id=${c.id}"/>Alterar</td>
			<td><a href="/Mercado/cliente?acao=Excluir&id=${c.id}"/>Excluir</td>
			</tr>
			
		</table>
</body>
</html>