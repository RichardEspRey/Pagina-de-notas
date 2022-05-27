<%@page import="com.mycompany.proyectoparaya.Notas"%>
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
       <% ArrayList<Notas> notaslist = (ArrayList<Notas>)request.getAttribute("notaslist"); %>       
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
       
    

        
      <form action="guardarNota" method="POST" class="NuevaNotaForm" onsubmit="return editar();">
         
       
         <p>Titulo 
             <c:forEach items="${notaslist}" var="notas">
                    
                 <input type="text" name="titulo" value="${notas.titulo}">
             
             </c:forEach>
         </p>

         <p>Texto 
             <c:forEach items="${notaslist}" var="notas">
              <input type="text" name="text" value="${notas.texto}">
             </c:forEach>
             
         </p>
          <p>Hashtag 
             <c:forEach items="${notaslist}" var="notas">
              <input type="text" name="hashtag" value="${notas.hashtag}">
             </c:forEach>
             
         </p>

          <button class="BtnNota" type="submit" onclick='editar'>Guardar</button>
           
        </form>

    </nav>
</body>
</html>