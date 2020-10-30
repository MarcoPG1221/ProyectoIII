
package System;

import DAO.SQL;
import model.Producto;
import java.text.SimpleDateFormat;
import java.util.Date;
import utils.Utilerias;

public class Orden {
    private SQL sql = new SQL();
    private int id;
    private int id_cliente;
    private String nombre;
    private String apellido;
    private String direccion;
    private String contacto;
    private itemOrden1 item1;
    private itemOrden1 item2;
    private Date fechaOrden;
    private double precioEnvio;
    private double total;
    private String tipoEnvio;
    private String estado_Compra= "activo";
    private String estado;
    private int diasEnvio;
    private Producto pro;
    private int codigo;
    private String nombre_pro;
    private Double precio_pro;
    private int cantidad;
    
    //Creamos un primer constructor con solo el id, total y fechaOrden
    public Orden(){
        this.id = sql.id_incrementableFactura();
        this.fechaOrden = new Date();
    }
    //Constructor para guardar los valores en la Base de Datos de cliente individual
    public Orden(double precioEnvio, String tipoEnvio, int diasEnvio,
            String nombre, String apellidos, String direccion, int codigo, String nombre_pro,
            Double precio_pro, int cantidad, double total){
        this(); //llamada al contructor sin parametros
        this.precioEnvio = precioEnvio;
        this.tipoEnvio = tipoEnvio;
        this.diasEnvio = diasEnvio;
        this.nombre = nombre;
        this.apellido = apellidos;
        this.direccion = direccion;
        this.codigo = codigo;
        this.nombre_pro = nombre_pro;
        this.precio_pro = precio_pro;
        this.cantidad = cantidad;
        this.total = total;
    }
    //Constructor para guardar los valores en la Base de Datos de cliente empresa
    public Orden(double precioEnvio, String tipoEnvio, int diasEnvio,
            String nombre, String apellidos, String direccion,String contacto, int codigo, String nombre_pro,
            Double precio_pro, int cantidad, double total){
        this.id = sql.id_incrementableFactura1();
        this.fechaOrden = new Date();
        this.precioEnvio = precioEnvio;
        this.tipoEnvio = tipoEnvio;
        this.diasEnvio = diasEnvio;
        this.nombre = nombre;
        this.apellido = apellidos;
        this.direccion = direccion;
        this.contacto = contacto;
        this.codigo = codigo;
        this.nombre_pro = nombre_pro;
        this.precio_pro = precio_pro;
        this.cantidad = cantidad;
        this.total = total;
        
    }
    
    //Constructor para devolver los valores de la Base de Datos de cliente Individual
    public Orden(int id, Date pFecha, double precioEnvio, String tipoEnvio, int diasEnvio,
            String nombre, String apellidos, String direccion, String estado, int codigo, String nombre_pro,
            Double precio_pro, int cantidad, double total, int id_cliente){
        this.id = id;
        this.fechaOrden = pFecha;
        this.precioEnvio = precioEnvio;
        this.tipoEnvio = tipoEnvio;
        this.diasEnvio = diasEnvio;
        this.nombre = nombre;
        this.apellido = apellidos;
        this.direccion = direccion;
        this.estado_Compra = estado;
        this.codigo = codigo;
        this.nombre_pro = nombre_pro;
        this.precio_pro = precio_pro;
        this.cantidad = cantidad;
        this.total = total;
        this.id_cliente = id_cliente;
    }
    //Constructor para devolver los valores de la Base de Datos de cliente empresa
    public Orden(int id, Date pFecha, double precioEnvio, String tipoEnvio, int diasEnvio,
            String nombre, String apellidos, String direccion, String contacto, String estado, int codigo, String nombre_pro,
            Double precio_pro, int cantidad, double total, int id_cliente){
        this.id = id;
        this.fechaOrden = pFecha;
        this.precioEnvio = precioEnvio;
        this.tipoEnvio = tipoEnvio;
        this.diasEnvio = diasEnvio;
        this.nombre = nombre;
        this.apellido = apellidos;
        this.direccion = direccion;
        this.contacto = contacto;
        this.estado_Compra = estado;
        this.codigo = codigo;
        this.nombre_pro = nombre_pro;
        this.precio_pro = precio_pro;
        this.cantidad = cantidad;
        this.total = total;
        this.id_cliente = id_cliente;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    
    
    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public double getPrecioEnvio() {
        return precioEnvio;
    }

    public void setPrecioEnvio(double precioEnvio) {
        this.precioEnvio = precioEnvio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getTipoEnvio() {
        return tipoEnvio;
    }

    public void setTipoEnvio(String tipoEnvio) {
        this.tipoEnvio = tipoEnvio;
    }

    public String getEstado() {
        return estado_Compra;
    }

    public void setEstado(String estado) {
        this.estado_Compra = estado;
    }

    public int getDiasEnvio() {
        return diasEnvio;
    }

    public void setDiasEnvio(int diasEnvio) {
        this.diasEnvio = diasEnvio;
    }

    public Producto getPro() {
        return pro;
    }

    public void setPro(Producto pro) {
        this.pro = pro;
    }
       
    public double getTotalOrden(){
        return total;
    }

    public int getId() {
        return id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre_pro() {
        return nombre_pro;
    }

    public void setNombre_pro(String nombre_pro) {
        this.nombre_pro = nombre_pro;
    }

    public Double getPrecio_pro() {
        return precio_pro;
    }

    public void setPrecio_pro(Double precio_pro) {
        this.precio_pro = precio_pro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public String fechaSeteada(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String Fechaformateada = sdf.format(fechaOrden);
        return Fechaformateada;
    }
    
}
