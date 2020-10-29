/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

/**
 *
 * @author pc
 */
public class itemOrden1 {
    private int noLinea;
    private int cantidad;
    private static int siguienteNoLinea = 1;
    private double producto;

    public itemOrden1(){
        this.noLinea = siguienteNoLinea++;
    }
    
    public itemOrden1(int pCantidad, double pldProducto) {
        this();
        this.cantidad = pCantidad;
        this.producto = pldProducto;
    }

    //Creamos los metodos getters y setters
    public int getNoLinea() {
        return noLinea;
    }

    public void setNoLinea(int noLinea) {
        this.noLinea = noLinea;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public double getTotalOrden(){
        return (cantidad * producto);
    }
}
