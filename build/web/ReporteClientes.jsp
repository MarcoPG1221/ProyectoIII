<%-- 
    Document   : ReporteClientes
    Created on : 24/10/2020, 04:15:11 PM
    Author     : pc
--%>

<%@page import="model.Individual"%>
<%@page import="java.util.List"%>
<%@page import="model.Cliente"%>
<%@page import="DAO.ClientesDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
            <a class="navbar-brand" href="#">Auto Partes</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
              <ul class="navbar-nav">
                <li class="nav-item active">
                  <a class="nav-link" href="Menu.jsp">Inicio <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                  <a class="nav-link" href="catalogo.jsp">Catalogo <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Registro de Clientes
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="RegistrarClienteIndividual.jsp">Individual</a>
                    <a class="dropdown-item" href="RegistrarClienteEmpresa.jsp">Empresa</a>
                  </div>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="RegistroProductos.jsp">Registro Productos</a>
                </li>
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Reportes
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="ReporteClientes.jsp">Cliente Individual</a>
                    <a class="dropdown-item" href="ReporteClienteEmpresa.jsp">Cliente Empresa</a>
                    <a class="dropdown-item" href="ReporteProductos.jsp">Productos</a>
                  </div>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">Compra</a>
                </li>
              </ul>
            </div>
          </nav>
        <div class="form-group col-md-6">
            <h2>Clientes registrados tipo Individual:</h2>
        </div>
        <form action="ReporteClientes.jsp" method="POST">
        <div class="form-group col-md-6">
        <table class="table table-striped">
            <thead class="thead-dark">
              <tr>
                <th scope="col">#</th>
                <th scope="col">Código</th>
                <th scope="col">Nombre</th>
                <th scope="col">Apellido</th>
                <th soope="col">Direccion</th>
                <th scope="col">DPI</th>
              </tr>
            </thead>
            <tbody>
              <%
              //1. Crear una instancia DAO correpondiente a las Clientes
              ClientesDAO clientesDAO = new ClientesDAO();
              
              //2. Obtener todas las Clientes de la base de datos
              List<Individual> clientes = clientesDAO.getDBClienteIndividual();
              //3. Iterar todas las clientes
              int i=0;
              for( Individual cliente : clientes){
              //4. Pintar el HTML que correponde a cada cliente
                i++;
              %>
              <tr>
                <th scope="row"><%=i%></th>
                <td><%=cliente.getId() %></td>
                <td><%=cliente.getNombres() %></td>
                <td><%=cliente.getApellidos() %></td>
                <td><%=cliente.getDireccion() %></td>
                <td><%=cliente.getDPI() %></td>
              </tr>
              <% 
               }
              %>              
            </tbody>
          </table>
        </div>
        <%
            String codigo = request.getParameter("c");
            if(codigo == null){
        %> 
        
            <div class="form-group col-md-2">
              <label for="c">Eliminar cliente:</label>
              <input type="text" class="form-control" id="c" name="c" placeholder="Ingrese codigo">
            </div>
            <div class="form-group col-md-6">
                <button type="submit" class="btn btn-primary">Eliminar</button> 
            </div>
        </form>
        <%
            }else{
                clientesDAO.deleteClienteIndividual(Integer.parseInt(codigo));
        %>
            <div class="alert alert-success" role="alert">
                Se elimino correctamente el cliente <a href="ReporteClientes.jsp" class="alert-link">Actualizar</a>. 
            </div>
        <% 
            }
        %>    
        <div class="form-group col-md-6">
            <form action="Menu.jsp">
              <button type="submit" class="btn btn-secondary">Regresar Menu</button>
            </form>
        </div>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
