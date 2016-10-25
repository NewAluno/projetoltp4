<%@page import="br.com.entidade.Venda"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>realizer a venda!!</title>
</head>
<body>

    <c:if test="${user==null && senha==null}">
    	<c:redirect url="../../../Mercado/index.jsp"/>
    </c:if>
     <c:set var="car" value="${venda.carinho}"/>
<center>
<c:choose>
	<c:when test="${venda.cliente eq null}">
    <P><input type="button" onclick="location='/Mercado/venda?acao=BuscarCliente'" value="Escolher Cliente!"><br/>
    </c:when>
    <c:otherwise>
      <P>  <input type="button" onclick="location='/Mercado/venda?acao=BuscarCliente'" value="Alterar Cliente!"><br/>    
    </c:otherwise>
</c:choose>   


		<P><input type="button" onclick="location='/Mercado/venda?acao=ListarProduto'" value="Adicionar Produto ao carinho"><br/>
		<P><input type="button" onclick="location='/Mercado/venda?acao=BuscarCarinho'" value="Visualizar Carinho"><br/>



	


</center>


</body>
</html>