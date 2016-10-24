<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>venda!</title>
</head>
<body>
	<c:if test="${user==null && senha==null}">
		<c:redirect url="../../../Mercado/index.jsp" />
	</c:if>
	<center>
		<p>
			<c:out value="${msg}"></c:out>
			<br />
		<P>
			<input type="button"
				onclick="location='/Mercado/venda?acao=BuscarCliente'"
				value="Escolher outro cliente" />
		<p>
			<input type="button"
				onclick="location='/Mercado/jsp/venda/vendaMenu.jsp'"
				value="Menu venda">
	</center>
</body>
</html>