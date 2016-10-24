<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu principal do sistema</title>
</head>
<body>
	<c:if test="${user==null && senha==null}">
    	<c:redirect url="../../Mercado/index.jsp"/>
    </c:if>
<center>
	<h2>Produto</h2>
	<a href="../../../Mercado/jsp/produto/cadastro.jsp">Cadastro de produto</a><br/>
	<a href="/Mercado/produto?acao=Listar"> Lista dos produtos</a>
	
	<h2>Cliente</h2>
	<a	href="../Mercado/jsp/cliente/cadastroCliente.jsp">Cadastro de cliente</a><br/>
	<a href="/Mercado/cliente?acao=Listar">Lista de clientes</a>
	
	<h2>Venda</h2>
	<a href="/Mercado/jsp/venda/vendaMenu.jsp">Realizer uma venda</a>

</center>

</body>
</html>