
package System;

import DAO.ClientesDAO;
import DAO.FacturaDAO;
import model.Producto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Empresa;
import model.Individual;

/**
 *
 * @author pc
 */
public class DataSistema {
    
    public static List<Cliente> clienteIndividual;
    public static List<Cliente> clienteEmpresa;
    public static List<Producto> productos;
    public static List<Producto> productos1;
    public static List<Orden> orden;
    public static Producto pro;
    public static ItemOrden item;
    public static int id_cliente;
    public static String nombre;
    public static String apellido;
    public static String direccion;
    FacturaDAO factura = new FacturaDAO();
    
    public DataSistema(){
        clienteIndividual = new ArrayList();
        ClientesDAO cli = new ClientesDAO();
        Cliente c = new Individual("Rogelio","Garcia","9 Ave. 0-32 z 1","3048142560110");
        Cliente c1 = new Individual("Violeta","Garcia","2 Ave. 2-52 z 9","3048865910110");
        Cliente c2 = new Individual("Vinicio","Solorzano","8 Calle 5-32 z 10","3048524360110");
        Cliente c3 = new Individual("Armando","Gonzales","1 Calle 8-69 z 1","3048896530110");
        //cli.saveClienteIndividual((Individual) c);
        //cli.saveClienteIndividual((Individual) c1);
        //cli.saveClienteIndividual((Individual) c2);
        //cli.saveClienteIndividual((Individual) c3);
        
        clienteEmpresa = new ArrayList();
        
        Cliente e = new Empresa ("Marina","Gonzalez","12 Ave. 5-32 z 12","85413696");
        Cliente e1 = new Empresa("Calos","Garcia","2 Calle 23-52 z 18","86301457");
        Cliente e2 = new Empresa("Martin","Solorzano","4 Calle 2-09 z 5","54123201");
        Cliente e3 = new Empresa("Fernanda","Lopez","3 Calle 6-19 z 12","85420147");
        //cli.saveClienteEmpresa((Empresa) e);
        //cli.saveClienteEmpresa((Empresa) e1);
        //cli.saveClienteEmpresa((Empresa) e2);
        //cli.saveClienteEmpresa((Empresa) e3);
        
        productos = new ArrayList();
        /*
        Producto producto6 = new Producto("Tubo de Escape",1250);
        Producto producto7 = new Producto("Escobilla Limpiaparabrisas",150.50);
        productos.add(producto6);
        productos.add(producto7);
        */
        orden = new ArrayList();
    }
    
    public void addClienteIndividual(Individual i){
        //Registramos al Cliente
        clienteIndividual.add(i);     
        JOptionPane.showMessageDialog(null,"Cliente Registrado");
    }
    
    public void addClienteEmpresa(Empresa e){
        //Registramos al Cliente
        clienteEmpresa.add(e);
        JOptionPane.showMessageDialog(null,"Cliente Registrado");
    }
    
    //Metodo para agregar los productos al ArrayList productos
    public void addProductos(Producto p){
        productos.add(p);     
        JOptionPane.showMessageDialog(null,"Producto Registrado");
    }
    
    public boolean BuscarClientes(int buscar){
        int tam = clienteIndividual.size();
        int tamano = clienteEmpresa.size();
        for(int i = 0; i < tam; i++ ){
            if(buscar == clienteIndividual.get(i).getId()){
                //guardamos las los datos del arreglo clienteIndividual en nuevas variables
                id_cliente = clienteIndividual.get(i).getId();
                nombre = clienteIndividual.get(i).getNombres();
                apellido = clienteIndividual.get(i).getApellidos();
                direccion = clienteIndividual.get(i).getDireccion();
                
                JOptionPane.showMessageDialog(null,"Cliente Registrado Tipo Individual");
                return true;
            }
        }
        
        for(int j = 0; j < tamano ; j++){
            if(buscar == clienteEmpresa.get(j).getId()){
                //guardamos las los datos del arreglo clienteIndividual en nuevas variables
                id_cliente = clienteEmpresa.get(j).getId();
                nombre = clienteEmpresa.get(j).getNombres();
                apellido = clienteEmpresa.get(j).getApellidos();
                direccion = clienteEmpresa.get(j).getDireccion();
                JOptionPane.showMessageDialog(null,"Cliente Registrado Tipo Empresa");
                return true;
            }
        }
        return false;
    }
    
    public void agregarProductosaCarrito(int idP, int cantidad){
        int tam = productos.size();
        for(int i = 0; i < tam; i++ ){
            if(idP == productos.get(i).getId()){
                //inicializamos el producto
                pro = new Producto();
                //luego guardamos los datos del producto
                pro.setId(productos.get(i).getId());
                pro.setNombreProducto(productos.get(i).getNombreProducto());
                pro.setPrecio(productos.get(i).getPrecio());
                productos1.add(pro);
            }
        }
    }
    
    public boolean addOrden(int idP,int cantidad, Date fecha, double precioEnvio, String tipoEnvio, int diasEnvio){
        
        int tam = productos.size();
        for(int i = 0; i < tam; i++ ){
            if(idP == productos.get(i).getId()){
                //inicializamos el producto
                pro = new Producto();
                //luego guardamos los datos del producto
                pro.setId(productos.get(i).getId());
                pro.setNombreProducto(productos.get(i).getNombreProducto());
                pro.setPrecio(productos.get(i).getPrecio());
                //con la clase item enviaremos el precio del producto y la cantidad para calcular el precio final
                item = new ItemOrden(cantidad, productos.get(i).getPrecio());
                //Creamos una clase Orden la cual nos almacenara todos los datos de las ordenes de compra
                Orden o = new Orden(fecha,precioEnvio,tipoEnvio,diasEnvio,nombre,apellido,direccion,pro,item);
                factura.saveOrden(o);
                orden.add(o);
                JOptionPane.showMessageDialog(null,"Compra Realizada con Exito");
                return true;
            }
        }
        return false;
    }
    
    public boolean BorrarCompra(int buscarCompra){
        int tam = orden.size();
        for(int i = 0; i < tam; i++){
            if(buscarCompra == orden.get(i).getId()){
                orden.remove(i);
                return true;
            }
        }
        return false;
    }

    //Declaramos los metodos setter
    public void setClienteIndividual(List<Cliente> clienteIndividual) {
        DataSistema.clienteIndividual = clienteIndividual;
    }

    public void setClienteEmpresa(List<Cliente> clienteEmpresa) {
        DataSistema.clienteEmpresa = clienteEmpresa;
    }

    public void setProductos(List<Producto> productos) {
        DataSistema.productos = productos;
    }

    public void setOrden(List<Orden> orden) {
        DataSistema.orden = orden;
    }
    
    //Declaramos los Gettes para devolver valores
    public List<Cliente> getClienteIndividual() {
        return clienteIndividual;
    }

    public List<Cliente> getClienteEmpresa() {
        return clienteEmpresa;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public List<Orden> getOrden() {
        return orden;
    }   
    
}//fin clase