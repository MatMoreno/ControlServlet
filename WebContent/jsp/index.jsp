<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
	String baseJsp = (String) request.getAttribute("baseJsp");
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/estilos.css">
</head>
<body>
<ul id="button">
<li><a href="<%=baseJsp%>?action=irEjercicio1" >Ejercicio 1</a></li>
<li><a href="<%=baseJsp%>?action=irEjercicio2" >Ejercicio 2</a></li>

</ul>
</body>
</html>