<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
   <c:if test="${user==null && senha==null}">
    	<c:redirect url="../../../Mercado/index.jsp"/>
    </c:if>
    <input type="button" onclick="location='../../../Mercado/jsp/menuPrincipal.jsp'" value="Menu principal"><br/>
  <input type="button" onclick="location='../../../../Mercado/carro?acao=Listar'" value="Lista dos carros"><br/>
 
