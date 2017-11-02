<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@page import="java.util.ArrayList"%>

 <%     String baseJsp = (String)request.getAttribute("baseJsp"); 
 HttpSession sesion = request.getSession();
      ArrayList<String> lista=(ArrayList<String>) sesion.getAttribute("arrayL");
      pageContext.setAttribute("arrayL", lista);
  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="    background: linear-gradient(to right, rgba(255, 255, 255, 1) 0, rgba(10, 239, 50, 1) 100%);">
<div  style="margin:auto;padding:5%;width: 35%;border: 3px black thin;  border-radius:20px;">
<h1>Enlaces</h1>
<ul>
 <c:forEach items="${arrayL}" var="list">
         <li type="circle"><a style="font-size: 30px;text-decoration: none;color:blue" href="${list} "> ${list} </a></li>
</c:forEach>
<input type="button" style="background-color:white;cursor:pointer; margin-left:10%;margin-top:10%;font-size: 30px;" name="volver" value="Volver al menu" onClick="window.location.href='<%=baseJsp%>'">
</div>





</ul>
</body>
</html>