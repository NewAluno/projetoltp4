
<%@page import="br.com.entidade.Carro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de todos os produtos!</title>
</head>
<body>
<c:if test="${user==null && senha==null}">
    	<c:redirect url="../../../LojaDeCarro/index.jsp"/>
    </c:if>
<center>
<c:choose>
<c:when test="${Lista.size()>0}">
	<h1> Lista dos carros cadastrados</h1>
	<table border="1">
		<tr>
			<td>Nome do produto</td>
			<td>Pre�o</td>
			<td>Fornecedor</td>
			<td></td>
			<td></td>
		</tr>
	

	<c:forEach var="l" items="${Lista}">
	<tr>
		<td>${l.nome}</td>
		<td>${l.preco}</td>
		<td>${l.fornecedor}</td>
		<td><a href="/LojaDeCarro/carro?acao=ConsultarProduto&id=${l.id}"/>Alterar</td>
		<td><a href="/LojaDeCarro/carro?acao=Excluir&id=${l.id}"/>Excluir</td>
	</tr>
	
	</c:forEach>
	</table>
	 
	 </c:when>

<c:otherwise>
	<h1>Nenhum produto cadastrado no sistema!</h1>
	<P><input type="button" onclick="location='/LojaDeCarro/jsp/carro/cadastro.jsp'" value="Cadastar novo produto"><br/>
</c:otherwise>
</c:choose>
	<p><input type="button" onclick="location='/LojaDeCarro/jsp/menuPrincipal.jsp'" value="Voltar ao menu principal"><br/>
</center>
</body>
</html>