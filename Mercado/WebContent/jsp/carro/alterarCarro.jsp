<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar dados do produto</title>
</head>
<body>

    
   <c:if test="${user==null && senha==null}">
    	<c:redirect url="../../../Mercado/index.jsp"/>
    </c:if>
<c:set var="car" value="${carro}" />
<form action="/Mercado/carro" method="post">

		<input type="hidden" name="acao" value="Alterar" />
		<input type="hidden" name="id" value="${car.id}">
		Nome: <input type="text" name="nome" value="${car.nome}"></br>
		Pre�o: <input type="text" name="preco" value="${car.preco}"></br>
		Fornecedor: <input type="text" name="fornecedor" value="${car.fornecedor}"></br>
		<input type="submit" value="Alterar">

	</form>

	<c:import url="../comum/opcaoBotoesProduto.jsp" />
</body>
</html>