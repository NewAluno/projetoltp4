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
    
<center>
<c:choose>
	<c:when test="${venda.cliente eq null}">
    <input type="button" onclick="location='/Mercado/venda?acao=BuscarCliente'" value="Escolher Cliente!"><br/>
    </c:when>
    <c:otherwise>
        <input type="button" onclick="location='/Mercado/venda?acao=BuscarCliente'" value="Alterar Cliente!"><br/>    
    </c:otherwise>
</c:choose>   

<c:choose>
	<c:when test="${venda.carinho.size() ne 0}">
	    <input type="button" onclick="location='/Mercado/venda?acao=BuscarProduto'" value="Adicionar Produto ao carinho"><br/>
	</c:when>
	<c:otherwise>
		<input type="button" onclick="location='/Mercado/venda?acao=BuscarProduto'" value="Adicionar Produto ao carinho"><br/>
		<input type="button" onclick="location='/Mercado/venda?acao=BuscarCarinho'" value="Visualizar Carinho"><br/>
	</c:otherwise>
</c:choose>

<c:if test="${venda.carinho.sizer()>0 and venda.cliente ne null }">
			<input type="button" onclick="location='/Mercado/venda?acao=Vender'" value="Realizar Venda!"><br/>
	
</c:if>

</center>


</body>
</html>