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
                <a class="botones" href="inicio.jsp">Inicio </a>
                <a class="botones" href="MisNotas.jsp">Mis notas </a>
                <a class="botones" href="NuevaNota.jsp">Nueva nota</a>
                <a class="botones" href="Perfil.jsp">Mi perfil</a>
            </div>
       
          
              <input class="Busqueda" type="search" placeholder="Busqueda">
            <button class="BuscarBtn">Buscar</button>
            <a class="botones" href="index.html">Cerrar Sesion</a>
        
           
            
        </div>
       
    

        
        <form action="ActualizarP" method="POST" class="NuevaNotaForm" onsubmit="return crear();">
         
               
           

   
         <button class="BtnNota" type="submit" onclick='crear'>Actualizar</button>
         <p>Nombre: 
             <c:forEach items="${listausuarios}" var="usuarios">
              
                 <a>${usuarios.nombre}</a>
             </c:forEach>
         </p>

         <p>Apellidos: 
             <c:forEach items="${listausuarios}" var="usuarios">
                 <a>${usuarios.apellidos}</a>
             </c:forEach>
         </p>

         <p>Fecha de nacimiento: 
             <c:forEach items="${listausuarios}" var="usuarios">
                 <a>${usuarios.fecha_Nacimiento}</a>
             </c:forEach>
         </p>
            <p>Correo:
                <c:forEach items="${listausuarios}" var="usuarios">
                 <a>${usuarios.correo}</a>
             </c:forEach>
            </p>
            <p>Nombre de usuario: 
                <c:forEach items="${listausuarios}" var="usuarios">
                 <a>${usuarios.nombreUsuario}</a>
             </c:forEach>
            </p>
            <p>Contra:
             <c:forEach items="${listausuarios}" var="usuarios">
                 <a>${usuarios.contra}</a>
             </c:forEach>
            </p>
            <p>Fecha de creacion:
             <c:forEach items="${listausuarios}" var="usuarios">
                 <a>${usuarios.fecha_Creacion}</a>
             </c:forEach>
            </p>
            
        </form>
        <form action="editarP" method="POST" onsubmit="return editar();">

           <button class="BtnNota" type="submit" onclick='editar'>Editar</button>
            </form>

    </nav>
</body>
</html>