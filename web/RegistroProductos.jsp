<%-- 
    Document   : RegistroProductos
    Created on : 25/10/2020, 06:45:28 PM
    Author     : pc
--%>

<%@page import="model.Producto"%>
<%@page import="DAO.ProductosDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
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
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Reportes de Ventas
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="verCompra.jsp">Cliente Individual</a>
                    <a class="dropdown-item" href="verCompraEmpresa.jsp">Cliente Empresa</a>
                  </div>
                </li>
              </ul>
            </div>
          </nav>
        <div class="form-group col-md-6">
            <h2>Registro de Producto</h2>
            <h5>Ingrese los siguientes datos:</h5>
        </div>
        <% 
            String nombres = request.getParameter("nombre");
            String precio = request.getParameter("precio");
            if(nombres==null && precio==null){
        %>
        <form action="RegistroProductos.jsp" method="POST">
            <div class="form-group col-md-6">
              <label for="nombre">Nombre:</label>
              <input type="text" class="form-control" id="nombres" name="nombre" placeholder="Ingrese nombre del producto">
            </div>
            <div class="form-group col-md-6">
              <label for="precio">Precio:</label>
              <input type="text" class="form-control" id="precio" name="precio" placeholder="Ingrese el precio">
            </div>
            <div class="form-group col-md-6">    
              <button type="submit" class="btn btn-primary">Registrar Producto</button> 
            </div>
        </form>
        <%
            }else{
                //1. Crear una instancia de ProductosDAO
                ProductosDAO productosDAO = new ProductosDAO();
                //2. Crear una instancia de Producto
                Producto p = new Producto(nombres,Double.parseDouble(precio));
                //3. Insertar en la DB la Producto
                productosDAO.saveProducto(p);
        %>
            <div class="alert alert-success" role="alert">
                Se registro correctamente el producto <a href="ReporteProductos.jsp" class="alert-link">Ver Productos Registrados</a>. 
            </div>
        <%
            }
        %>
        <form action="Menu.jsp">
          <div class="form-group col-md-6">
          <button type="submit" class="btn btn-secondary">Regresar al Menu</button>
          </div>
        </form>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    </body>
</html>
