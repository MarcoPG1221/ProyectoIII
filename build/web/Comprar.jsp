<%-- 
    Document   : anadirCarrito
    Created on : 28/10/2020, 05:35:12 PM
    Author     : pc
--%>

<%@page import="DAO.FacturaDAO"%>
<%@page import="model.Individual"%>
<%@page import="DAO.ClientesDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.Producto"%>
<%@page import="model.Producto"%>
<%@page import="DAO.ProductosDAO"%>
<%@page import="System.Orden"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="System.DataSistema"%>
<!DOCTYPE html>
<%
    String id = request.getParameter("id");
    String nombre = request.getParameter("nombre");
    String precio = request.getParameter("precio");
%>
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
                <li class="nav-item">
                  <a class="nav-link" href="RealizarCompra.jsp">Compra</a>
                </li>
              </ul>
            </div>
          </nav>
        <p></p>
        <br>
        <h2 align="center"  >Realizar Compra</h2>
        <br>
        <p></p>
            <% 
            DataSistema sistema = new DataSistema();
            String id_p = request.getParameter("id_p");
            String nombre_pro = request.getParameter("nombre_pro");
            String precio_pro = request.getParameter("precio_pro");
            String cantidad_pro = request.getParameter("cantidad_pro");
            String precioEnvio = request.getParameter("precioEnvio");
            String tipoEnvio = request.getParameter("tipoEnvio");
            String diaEnvio = request.getParameter("diaEnvio");
            String id_cliente = request.getParameter("id_cliente");
            if(id_p==null && nombre_pro==null && precio_pro==null && cantidad_pro==null && precioEnvio==null && 
                    tipoEnvio==null && diaEnvio==null && id_cliente==null){
            %>
            <form action="Comprar.jsp" method="POST">
            <div  align="center" class="form-group col-md-6">
              <label for="nombre">Codigo</label>
              <input type="text" class="form-control" id="id_p" name="id_p" value="<%= id%>" placeholder="Ingrese cantidad">
            </div>
            <div align="center" class="form-group col-md-6">
              <label for="nombre">Nombre Producto</label>
              <input type="text" class="form-control" id="nombre_pro" name="nombre_pro" value="<%= nombre%>" placeholder="Ingrese cantidad">
            </div>
            <div align="center" class="form-group col-md-6">
              <label for="nombre">Precio</label>
              <input type="text" class="form-control" id="precio_pro" name="precio_pro" value="<%= precio%>" placeholder="Ingrese cantidad">
            </div>
            <div align="center" class="form-group col-md-6">
              <label for="nombre">Cantidad</label>
              <input type="text" class="form-control" id="cantidad_pro" name="cantidad_pro" placeholder="Ingrese cantidad">
            </div>
            <div align="center" class="form-group col-md-6">
              <label for="apellido">Precio Envio</label>
              <input type="text" class="form-control" id="precioEnvio" name="precioEnvio" placeholder="Ingrese precio envio">
            </div>
            <div align="center" class="form-group col-md-6">
              <label for="direccion">Tipo Envio</label>
              <input type="text" class="form-control" id="tipoEnvio" name="tipoEnvio" placeholder="Ingrese tipo de envio">
            </div>
            <div align="center" class="form-group col-md-6">
              <label for="dpi">Dias de Envio</label>
              <input type="text" class="form-control" id="diaEnvio" name="diaEnvio" placeholder="ingrese los dias">
            </div>
            <div align="center" class="form-group col-md-6">
              <label for="dpi">ID Cliente</label>
              <input type="text" class="form-control" id="id_cliente" name="id_cliente" placeholder="ingrese id de cliente">
            </div>
            <div align="center" class="form-group col-md-6">    
              <button type="submit" class="btn btn-primary">Realizar Compra</button> 
            </div>
        </form>
        <%
            }else{
                //Mando a llamar las clases de DAO
                ProductosDAO productosDAO = new ProductosDAO();
                ClientesDAO clientesDAO = new ClientesDAO();
                FacturaDAO facturaDAO = new FacturaDAO();
                //Creo un arreglo de tipo lista para obtener los clientes de la base de datos
                List<Individual> clientes = clientesDAO.getDBClienteIndividual();
                int tam = clientes.size();
                //Creo un for para hacer un recorrido
                for(int i = 0; i<tam; i++){
                    //con un if valido el id del cliente
                    if(Integer.parseInt(id_cliente)==clientes.get(i).getId()){
                        String nombre_cliente = clientes.get(i).getNombres();
                        String apellido = clientes.get(i).getApellidos();
                        String direccion = clientes.get(i).getDireccion();
                        //luego guardo la informacion en la clase orden
                        Orden o = new Orden(Double.parseDouble(precioEnvio),tipoEnvio,Integer.parseInt(diaEnvio),
                                            nombre_cliente,apellido,direccion,Integer.parseInt(id_p),nombre_pro,
                                            Double.parseDouble(precio_pro),Integer.parseInt(cantidad_pro));
                        facturaDAO.saveOrden(o);
                    }
                }
        %>
            <div class="alert alert-success" role="alert">
                Se realizo correctamente compra <a href="Menu.jsp" class="alert-link">Regresar al menu</a>. 
            </div>
        <% 
            }
        %>
        
        
        
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    </body>
</html>
