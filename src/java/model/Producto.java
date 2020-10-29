
package model;

import DAO.SQL;
import utils.Utilerias;

public class Producto {
    private SQL sql = new SQL();
    private int id;
    private String nombreProducto;
    private double precio;

    //Creamos un constructor vacio y uno con parámetros
    public Producto(){
        this.id = sql.id_incrementableProducto();
    }
    
    public Producto(String nombreProducto, double precio) {
        this(); //llamada al contructor sin parametros
        this.nombreProducto = nombreProducto;
        this.precio = precio;
    }
    
    public Producto(int id, String nombreProducto, double precio) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
    }
    
    
    public Producto(String nombreProducto){
        this();
        this.nombreProducto = nombreProducto;
    }
    //Creamos los metodos getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    //Declaramos un metodo toString para devolver los valores ingresados
    public String toString(){
        return "["+Utilerias.getNombreProducto()+"]\t" + "id: "+id+"\t\tNombre: "+nombreProducto+"\t\tPrecio: Q. "+precio;
    }
    
}
