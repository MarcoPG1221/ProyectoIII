/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Producto;
import utils.BasedeDatos;

/**
 *
 * @author pc
 */
public class ProductosDAO {
    /**
     * Método para mostrar un registro tipo cliente en la base de datos
     * @return 
     */
    public List<Producto> getDBProductos(){
        List<Producto> producto = new ArrayList<>();
        try {
            Statement statement = BasedeDatos.conn.createStatement();
            String consulta = " SELECT id,nombre,precio"+
                              " FROM productos";
            ResultSet rs = statement.executeQuery(consulta);
            while(rs.next()){
                producto.add(new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getDouble("precio")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return producto;
    }
    /**
     * Método para guardar un registro tipo cliente en la base de datos
     * @param producto
     * @return 
     */
    public boolean saveProducto(Producto producto){
        try {
            Statement statement = BasedeDatos.conn.createStatement();
            String dml = "INSERT INTO productos(id,nombre,precio) VALUES("+
                    producto.getId() + ",'" + producto.getNombreProducto()+ "'," + producto.getPrecio() + ")";
            System.out.println("Producto almacenado correctamente en la base de datos");
            statement.executeUpdate(dml);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }    
    
    /**
     * Método para eliminar un registro tipo cliente en la base de datos
     * @param buscar
     */
    public boolean deleteProducto(int buscar){
        try {
            Statement statement = BasedeDatos.conn.createStatement();
            statement.executeUpdate(String.format("delete from productos where id = %d;",buscar));
            System.out.println("Producto Eliminado exitosamente");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
     * Método para modificar un registro tipo Producto en la base de datos
     * @param nombre
     * @param precio
     * @param buscar
     */
    public boolean updateProducto(String nombre, double precio, int buscar){
        try {
            Statement statement = BasedeDatos.conn.createStatement();
            statement.executeUpdate(String.format("update productos set nombre = %s,"
                    + "precio = %f where id = %d;","'"+nombre+"'",precio,buscar));
            System.out.println("Se han actualizado los datos exitosamente");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
