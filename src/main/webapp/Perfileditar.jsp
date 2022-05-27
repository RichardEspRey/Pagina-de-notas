<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.proyectoparaya.UsuarioAtributos"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Perfil</title>
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
         <% String variable = (String)request.getAttribute("Perfilusu"); %>
      
     
       
      
      
    
    <nav>
        <div class="navbar">
            <div class="PrimerMenu">
                <a class="botones" href="inicio.html">Inicio </a>
                <a class="botones" href="MisNotas.jsp">Mis notas </a>
                <a class="botones" href="NuevaNota.jsp">Nueva nota</a>
                <a class="botones" href="#">Mi perfil</a>
            </div>
       
          
              <input class="Busqueda" type="search" placeholder="Busqueda">
            <button class="BuscarBtn">Buscar</button>
            <a class="botones" href="#">Opciones</a>
        
           
            
        </div>
       
    

        
        <form action="guardarP" method="POST" class="NuevaNotaForm" onsubmit="return crear();">
         
         <button class="BtnNota" type="submit" onclick='crear'>Guardar</button>
         <p>Nombre: 
             <c:forEach items="${listausuarios}" var="usuarios">
                    
                 <input type="text" name="nombre" value="${usuarios.nombre}">
             
             </c:forEach>
         </p>

         <p>Apellidos: 
             <c:forEach items="${listausuarios}" var="usuarios">
               <input type="text"   name="apellidos" value="${usuarios.apellidos}">
             </c:forEach>
         </p>

         <p>Fecha de nacimiento: 
             <c:forEach items="${listausuarios}" var="usuarios">
                 <input type="text" name="fecha" value="${usuarios.fecha_Nacimiento}">
               
             </c:forEach>
         </p>
            <p>Correo:
                <c:forEach items="${listausuarios}" var="usuarios">
               <input type="text" name="correo" value="${usuarios.correo}">
             </c:forEach>
            </p>
            <p>Nombre de usuario: 
                <c:forEach items="${listausuarios}" var="usuarios">
           <input type="text" name="user" value="${usuarios.nombreUsuario}">
             </c:forEach>
            </p>
            <p>Contra:
             <c:forEach items="${listausuarios}" var="usuarios">
               <input type="text" name="contra" value="${usuarios.contra}">
             </c:forEach>
            </p>
         
            </p>
           
        </form>
         
        

    </nav>
</body>
</html>