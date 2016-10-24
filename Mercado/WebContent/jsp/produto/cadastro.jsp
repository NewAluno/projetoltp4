<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>cadastro do produto</title>
</head>
<body>

	<c:if test="${user==null && senha==null}">
    	<c:redirect url="../../../Mercado/index.jsp"/>
    </c:if>
	<center>
	<h1>cadastro de produto!!</h1>
	
	<form action="/Mercado/produto" method="post">
		<input type="hidden" name="acao" value="inserir" />
		Nome: <input type="text" name="nome"></br>
		Preço: <input type="text" name="preco"></br>
		Fornecedor: <input type="text" name="fornecedor"></br>
		<input type="submit" value="cadastrar">

	</form>	
	<c:import url="../comum/opcaoBotoesProduto.jsp" />
	</center>
</body>
</html>