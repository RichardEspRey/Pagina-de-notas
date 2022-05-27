<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.proyectoparaya.UsuarioAtributos"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Nueva Nota</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="CSS/html.css">
    <link rel="shortcut icon" href="icono.png">
</head>
<STYLE>A {text-decoration: none;} </STYLE>
<body>
       <% ArrayList<UsuarioAtributos> listausuarios = (ArrayList<UsuarioAtributos>)request.getAttribute("listausuarios"); %>
         <% String variable = (String)request.getAttribute("variable"); %>
      
     
       
      
      
    
    <nav>
        <div class="navbar">
            <div class="PrimerMenu">
                <a class="botones" href="inicio.jsp">Inicio </a>
                <a class="botones" href="MisNotas.jsp">Mis notas </a>
                <a class="botones" href="NuevaNota.jsp">Nueva nota</a>
                <a class="botones" href="Perfil.jsp">Mi perfil</a>
            </div>
       
          
              <input class="Busqueda" type="search" placeholder="Busqueda">
            <button class="BuscarBtn">Buscar</button>
            <a class="botones" href="index.html">Cerrar Sesion</a>
        
           
            
        </div>
       
    

        
        <form action="CreacionNotas" method="POST" class="NuevaNotaForm" onsubmit="return crear();">
            <c:forEach items="${listausuarios}" var="usuarios">
  
           
          <h1>${usuarios.nombre}</h1>
            
          
      
    </c:forEach>
        
          <input class="cajas" type="text" name="titulo" placeholder="Titulo">
            <input class="cajas" type="text" name="hashtag" placeholder="hashtag">
            <input class="cajas" type="text" name="nota" placeholder="Contenido de nota">
            <button class="BtnNota" type="submit" onclick='crear'>Enviar</button>
        </form>

    </nav>
</body>
</html>