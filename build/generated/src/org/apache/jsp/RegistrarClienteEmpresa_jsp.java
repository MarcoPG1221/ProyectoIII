package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Empresa;
import model.Cliente;
import DAO.ClientesDAO;

public final class RegistrarClienteEmpresa_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">\n");
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
      out.write("                  <a class=\"nav-link\" href=\"index.html\">Inicio <span class=\"sr-only\">(current)</span></a>\n");
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
      out.write("            <h2>Registro de Cliente Empresa</h2>\n");
      out.write("            <h5>Ingrese los siguientes datos:</h5>\n");
      out.write("        </div>\n");
      out.write("        ");
 
            String nombres = request.getParameter("nombre");
            String apellidos = request.getParameter("apellido");
            String direccion = request.getParameter("direccion");
            String contacto = request.getParameter("contacto");
            if(nombres==null && apellidos==null && direccion == null && contacto == null){
        
      out.write("\n");
      out.write("        <form action=\"RegistrarClienteEmpresa.jsp\" method=\"POST\">\n");
      out.write("            <div class=\"form-group col-md-6\">\n");
      out.write("              <label for=\"nombre\">Nombres:</label>\n");
      out.write("              <input type=\"text\" class=\"form-control\" id=\"nombres\" name=\"nombre\" placeholder=\"Ingrese sus nombres\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group col-md-6\">\n");
      out.write("              <label for=\"apellido\">Apellidos:</label>\n");
      out.write("              <input type=\"text\" class=\"form-control\" id=\"apellidos\" name=\"apellido\" placeholder=\"Ingrese sus apellidos\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group col-md-6\">\n");
      out.write("              <label for=\"direccion\">Direccion:</label>\n");
      out.write("              <input type=\"text\" class=\"form-control\" id=\"direccion\" name=\"direccion\" placeholder=\"Ingrese su direccion\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group col-md-6\">\n");
      out.write("              <label for=\"contacto\">Contacto:</label>\n");
      out.write("              <input type=\"text\" class=\"form-control\" id=\"contacto\" name=\"contacto\" placeholder=\"Ingrese su documento de idenficacion\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group col-md-6\">  \n");
      out.write("              <button type=\"submit\" class=\"btn btn-primary\">Registrar Cliente</button> \n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("        ");

            }else{
                //1. Crear una instancia de ClientesDAO
                ClientesDAO clientesDAO = new ClientesDAO();
                //2. Crear una instancia de Cliente
                Cliente c = new Empresa(nombres,apellidos,direccion,contacto);
                //3. Insertar en la DB la Cliente
                clientesDAO.saveClienteEmpresa((Empresa) c );
        
      out.write("\n");
      out.write("            <div class=\"alert alert-success\" role=\"alert\">\n");
      out.write("                Se registro correctamente el cliente <a href=\"ReporteClienteEmpresa.jsp\" class=\"alert-link\">Ver Clientes Registrados</a>. \n");
      out.write("            </div>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("        <form action=\"index.html\">\n");
      out.write("          <div class=\"form-group col-md-6\">\n");
      out.write("          <button type=\"submit\" class=\"btn btn-secondary\">Regresar al Menu</button>\n");
      out.write("          </div>\n");
      out.write("        </form>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\" integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js\" integrity=\"sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s\" crossorigin=\"anonymous\"></script>\n");
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
