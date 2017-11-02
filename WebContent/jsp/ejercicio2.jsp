<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% 
    String baseJsp = (String)request.getAttribute("baseJsp"); 
    HttpSession sesion = request.getSession();
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div  style="margin:auto;padding:5%;width: 35%;border: 3px black thin;  border-radius:20px;background: linear-gradient(to right, rgba(255, 255, 255, 1) 0, rgba(239, 239, 239, 1) 100%);">
        	<%if(sesion.getAttribute("logExito")==null){ %>
            <form  action="<%=baseJsp%>?action=botonLogin" method="POST">
                <h2>Iniciar Sesión</h2>
                <input type="text"  placeholder="usuario" name="usuario" id="usuario" required>
                <input type="password"  placeholder="contraseña" name="contra" id="contra" required>
                <button  type="submit">Login</button><label style="display:inline;margin-left: 5px; "></label>
                <input type="button" style="background-color:white;cursor:pointer; margin-left:10%;margin-top:10%;font-size: 30px;" name="volver" value="Volver al menu" onClick="window.location.href='<%=baseJsp%>'">
                
            </form>
            <%}else{ %>
            <h1>LOGUEADO CON EXITO</h1>
            <h2><a href="<%=baseJsp%>?action=cerrarSesion">cerrar sesión</a></h2>
            <%} %>
           <%--  <%
          
            if(error.equals("true")){
            	%>
            	<p style="color: red">El email o contraseña introducidos no coinciden</p>
            	<%
            }
            %> --%>
        
</div>
</body>
</html>