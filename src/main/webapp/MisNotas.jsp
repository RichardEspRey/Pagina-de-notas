<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.proyectoparaya.Notas"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="/DataTables/datatables.css">
 <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.12.1/datatables.min.css"/>
 
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.12.1/datatables.min.js"></script>


    <script type="text/javascript">
        $(document).ready(function () {
            $('#tabla_notas').DataTable();
            });
    </script>

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
            <a class="botones" href="index.html">Cerrar sesion</a>
        
           
            
        </div>
      
 

    </nav>
    <div class="tabla">
          <form action="VerNotas" method="POST"  onsubmit="return ver();">
          
         
            <button class="BtnNota" type="submit" onclick='ver'>Actualizar</button>
         
        </form>
  
          <table id="tabla_notas" class="display">
            <thead>
                <tr>
                    <td>ID</td>
                    <td>Titulo</td>
                    <td>Text</td>
                    <td>Fecha Creacion</td>
                    <td>hashtag</td>
                    <td>Eliminado</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach  items="${notaslist}" var="nota">
                    <tr>
                         <td>${nota.id}</td>
                        <td>${nota.titulo}</td>
                         <td>${nota.texto}</td>
                          <td>${nota.fecha}</td>
                         <td>${nota.hashtag}</td>
                          <td>${nota.eliminado}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    
    <div class="eliminarNota">
        <form action="eliminarNota" method="POST" class="NuevaNotaForm" onsubmit="return crear();">
            <p>Inserte el Id de la nota que dese eliminar</p>
          <input class="cajas" type="text" name="NotaEliminar" placeholder="ID de nota" >
          <button class="BtnNota" type="submit" onclick='crear'>Eliminar</button>
        </form>
        
        
    
        <form action="editarNota" method="POST" class="editarNota" onsubmit="return crear();">
            <p>Inserte el Id de la nota que dese editar</p>
          <input class="cajas" type="text" name="NotaEditar" placeholder="ID de nota" >
          <button class="BtnNota" type="submit" onclick='crear'>Editar</button>
        </form>
        
        
    </div>
       
</body>

</html>