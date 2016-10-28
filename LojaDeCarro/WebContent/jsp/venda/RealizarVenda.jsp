<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Realizar venda!!!</title>
</head>
<body>
<center>
<p><a> Escolhar um cliente</a>
<p><select name="idCliente">
		<c:forEach var="c" items="${clientes}">
			<option value="${c.id}" ${cliente.id == c.id ? 'selected' : ' ' }>
			<c:out value="${c.nome}"/> 
			</option>
		</c:forEach>
	</select>
<p><a> Escolhar um carro</a>	
	<p><select name="IdCarro">
	 <c:forEach var="car" items="${carros}">
	 <option value="${car.id}" ${carro.id == car.id ? 'selected' : '' }>
	 <c:out value="${car.nome}" />
	 </option>
	 </c:forEach>
	</select>
	
</center>
</body>
</html>