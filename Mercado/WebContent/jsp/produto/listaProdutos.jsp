
<%@page import="br.com.entidade.Produto"%>
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
    	<c:redirect url="../../../Mercado/index.jsp"/>
    </c:if>
<center>
<c:choose>
<c:when test="${Lista.size()>0}">
	<marquee><h1> Lista de todos os produtos cadastrdos</h1></marquee>
	<table border="1">
		<tr>
			<td>Nome do produto</td>
			<td>Preço</td>
			<td>Fornecedor</td>
			<td></td>
			<td></td>
		</tr>
	

	<c:forEach var="l" items="${Lista}">
	<tr>
		<td>${l.nome}</td>
		<td>${l.preco}</td>
		<td>${l.fornecedor}</td>
		<td><a href="/Mercado/produto?acao=ConsultarProduto&id=${l.id}"/>Alterar</td>
		<td><a href="/Mercado/produto?acao=Excluir&id=${l.id}"/>Excluir</td>
	</tr>
	
	</c:forEach>
	</table>
	 
	 </c:when>

<c:otherwise>
	<h1>Nenhum produto cadastrado no sistema!</h1>
	<input type="button" onclick="location='/Mercado/jsp/produto/cadastro.jsp'" value="Cadastar novo produto"><br/>
</c:otherwise>
</c:choose>
	<input type="button" onclick="location='/Mercado/jsp/menuPrincipal.jsp'" value="Voltar ao menu principal"><br/>
</center>
</body>
</html>