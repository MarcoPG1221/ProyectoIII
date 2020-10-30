package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import System.Orden;
import java.util.List;
import DAO.FacturaDAO;

public final class verCompra_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar navbar-dark bg-dark\">\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\">Auto Partes</a>\n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNavDropdown\" aria-controls=\"navbarNavDropdown\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("              <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("            </button>\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarNavDropdown\">\n");
      out.write("              <ul class=\"navbar-nav\">\n");
      out.write("                <li class=\"nav-item active\">\n");
      out.write("                  <a class=\"nav-link\" href=\"Menu.jsp\">Inicio <span class=\"sr-only\">(current)</span></a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item active\">\n");
      out.write("                  <a class=\"nav-link\" href=\"catalogo.jsp\">Catalogo <span class=\"sr-only\">(current)</span></a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item dropdown\">\n");
      out.write("                  <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdownMenuLink\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                    Registro de Clientes\n");
      out.write("                  </a>\n");
      out.write("                  <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\">\n");
      out.write("                    <a class=\"dropdown-item\" href=\"RegistrarClienteIndividual.jsp\">Individual</a>\n");
      out.write("                    <a class=\"dropdown-item\" href=\"RegistrarClienteEmpresa.jsp\">Empresa</a>\n");
      out.write("                  </div>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                  <a class=\"nav-link\" href=\"RegistroProductos.jsp\">Registro Productos</a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item dropdown\">\n");
      out.write("                  <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdownMenuLink\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                    Reportes\n");
      out.write("                  </a>\n");
      out.write("                  <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\">\n");
      out.write("                    <a class=\"dropdown-item\" href=\"ReporteClientes.jsp\">Cliente Individual</a>\n");
      out.write("                    <a class=\"dropdown-item\" href=\"ReporteClienteEmpresa.jsp\">Cliente Empresa</a>\n");
      out.write("                    <a class=\"dropdown-item\" href=\"ReporteProductos.jsp\">Productos</a>\n");
      out.write("                  </div>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                  <a class=\"nav-link\" href=\"#\">Compra</a>\n");
      out.write("                </li>\n");
      out.write("              </ul>\n");
      out.write("            </div>\n");
      out.write("          </nav>\n");
      out.write("        <div class=\"form-group col-md-6\">\n");
      out.write("            <h2>Clientes registrados tipo Individual:</h2>\n");
      out.write("        </div>\n");
      out.write("        <form action=\"ReporteClientes.jsp\" method=\"POST\">\n");
      out.write("        <div class=\"form-group col-md-6\">\n");
      out.write("        <table class=\"table table-striped\">\n");
      out.write("            <thead class=\"thead-dark\">\n");
      out.write("              <tr>\n");
      out.write("                <th scope=\"col\">#</th>\n");
      out.write("                <th scope=\"col\">ID_factura</th>\n");
      out.write("                <th scope=\"col\">Precio de Envio</th>\n");
      out.write("                <th scope=\"col\">Tipo Envio</th>\n");
      out.write("                <th soope=\"col\">Dias Envio</th>\n");
      out.write("                <th scope=\"col\">Nombre_Cliente</th>\n");
      out.write("                <th scope=\"col\">Apellido_Cliente</th>\n");
      out.write("                <th scope=\"col\">Direccion_Cliente</th>\n");
      out.write("                <th scope=\"col\">Estado</th>\n");
      out.write("              </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("              ");

              //1. Crear una instancia DAO correpondiente a las Clientes
              FacturaDAO facturaDAO = new FacturaDAO();
              
              //2. Obtener todas las Clientes de la base de datos
              List<Orden> orden1 = facturaDAO.getDBOrdenes();
              //3. Iterar todas las clientes
              int i=0;
              for( Orden o : orden1){
              //4. Pintar el HTML que correponde a cada cliente
                i++;
              
      out.write("\n");
      out.write("              <tr>\n");
      out.write("                <th scope=\"row\">");
      out.print(i);
      out.write("</th>\n");
      out.write("                <td>");
      out.print(o.getId() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print(o.getPrecioEnvio() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print(o.getTipoEnvio() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print(o.getDiasEnvio() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print(o.getNombre() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print(o.getApellido() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print(o.getDireccion() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print(o.getEstado() );
      out.write("</td>\n");
      out.write("              </tr>\n");
      out.write("              ");
 
               }
              
      out.write("              \n");
      out.write("            </tbody>\n");
      out.write("          </table>\n");
      out.write("        </div>\n");
      out.write("        ");

            String codigo = request.getParameter("c");
            if(codigo == null){
        
      out.write(" \n");
      out.write("        \n");
      out.write("            <div class=\"form-group col-md-2\">\n");
      out.write("              <label for=\"c\">Eliminar cliente:</label>\n");
      out.write("              <input type=\"text\" class=\"form-control\" id=\"c\" name=\"c\" placeholder=\"Ingrese codigo\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group col-md-6\">\n");
      out.write("                <button type=\"submit\" class=\"btn btn-primary\">Eliminar</button> \n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("        ");

            }else{
                facturaDAO.deleteCompra(Integer.parseInt(codigo));
        
      out.write("\n");
      out.write("            <div class=\"alert alert-success\" role=\"alert\">\n");
      out.write("                Se elimino correctamente el cliente <a href=\"ReporteClientes.jsp\" class=\"alert-link\">Actualizar</a>. \n");
      out.write("            </div>\n");
      out.write("        ");
 
            }
        
      out.write("    \n");
      out.write("        <div class=\"form-group col-md-6\">\n");
      out.write("            <form action=\"Menu.jsp\">\n");
      out.write("              <button type=\"submit\" class=\"btn btn-secondary\">Regresar Menu</button>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.4.1.slim.min.js\" integrity=\"sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\" integrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\" integrity=\"sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
