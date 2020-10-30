/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import System.Orden;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.BasedeDatos;

/**
 *
 * @author pc
 */
public class FacturaDAO {
    
    /**
     * Método para obtener todos los registros de la base de datos como objetos
     * @return List de Cliente
    */
    public List<Orden> getDBOrdenes(){
        List<Orden> ordenes = new ArrayList<>();
        try {
            Statement statement = BasedeDatos.conn.createStatement();
            String consulta = " SELECT id_factura, fecha, precio_envio, tipo_envio, dias_envio,"+
                              " nombre_cliente, apellido_cliente, direccion_cliente, estado,"
                            + " codigo_producto, nombre_producto, precio_producto, cantidad, precio_final,"
                            + " fk_id_cliente FROM factura";
            ResultSet rs = statement.executeQuery(consulta);
            while(rs.next()){
                ordenes.add(new Orden(rs.getInt("id_factura"),rs.getDate("fecha"),rs.getDouble("precio_envio"),
                rs.getString("tipo_envio"),rs.getInt("dias_envio"),rs.getString("nombre_cliente"),
                rs.getString("apellido_cliente"),rs.getString("direccion_cliente"),rs.getString("estado"),
                rs.getInt("codigo_producto"),rs.getString("nombre_producto"),rs.getDouble("precio_producto"),
                rs.getInt("cantidad"),rs.getDouble("precio_final"),rs.getInt("fk_id_cliente")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ordenes;
    }
    
    
    public List<Orden> getDBOrdenes1(){
        List<Orden> ordenes = new ArrayList<>();
        try {
            Statement statement = BasedeDatos.conn.createStatement();
            String consulta = " SELECT id_factura, fecha, precio_envio, tipo_envio, dias_envio,"+
                              " nombre_cliente, apellido_cliente, direccion_cliente,contacto, estado,"
                            + " codigo_producto, nombre_producto, precio_producto, cantidad, precio_final,"
                            + " fk_id_cliente FROM factura1";
            ResultSet rs = statement.executeQuery(consulta);
            while(rs.next()){
                ordenes.add(new Orden(rs.getInt("id_factura"),rs.getDate("fecha"),rs.getDouble("precio_envio"),
                rs.getString("tipo_envio"),rs.getInt("dias_envio"),rs.getString("nombre_cliente"),
                rs.getString("apellido_cliente"),rs.getString("direccion_cliente"),rs.getString("contacto"),
                rs.getString("estado"),rs.getInt("codigo_producto"),rs.getString("nombre_producto"),
                rs.getDouble("precio_producto"),rs.getInt("cantidad"),rs.getDouble("precio_final"),
                rs.getInt("fk_id_cliente")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ordenes;
    }
    
    public boolean saveOrden(Orden orden, int id_cl){
        try {
            Statement statement = BasedeDatos.conn.createStatement();
            String dml = "INSERT INTO factura(id_factura,fecha,precio_envio,tipo_envio"
                    + ",dias_envio,nombre_cliente,apellido_cliente,direccion_cliente,estado"
                    + ",codigo_producto,nombre_producto,precio_producto,cantidad,precio_final,fk_id_cliente) VALUES("+
                    orden.getId() + ",'" + orden.fechaSeteada()+ "'," 
                    + orden.getPrecioEnvio() + ",'" 
                    + orden.getTipoEnvio() + "',"
                    + orden.getDiasEnvio() + ",'" 
                    + orden.getNombre() + "','" 
                    + orden.getApellido() + "','"
                    + orden.getDireccion() + "','"
                    + orden.getEstado() + "',"
                    + orden.getCodigo() + ",'"
                    + orden.getNombre_pro() + "',"
                    + orden.getPrecio_pro() + "," 
                    + orden.getCantidad() + "," 
                    + orden.getTotalOrden() + ","
                    + id_cl + ")";
            System.out.println("Cliente Almacenado correctamente a la Base de Datos");
            System.out.println(dml);
            statement.executeUpdate(dml);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    
    public boolean saveOrdenEmpresa(Orden orden, int id_cl){
        try {
            Statement statement = BasedeDatos.conn.createStatement();
            String dml = "INSERT INTO factura1(id_factura,fecha,precio_envio,tipo_envio"
                    + ",dias_envio,nombre_cliente,apellido_cliente,direccion_cliente,contacto,estado"
                    + ",codigo_producto,nombre_producto,precio_producto,cantidad,precio_final,fk_id_cliente) VALUES("+
                    orden.getId() + ",'" + orden.fechaSeteada()+ "'," 
                    + orden.getPrecioEnvio() + ",'" 
                    + orden.getTipoEnvio() + "',"
                    + orden.getDiasEnvio() + ",'" 
                    + orden.getNombre() + "','" 
                    + orden.getApellido() + "','"
                    + orden.getDireccion() + "','" 
                    + orden.getContacto() + "','"
                    + orden.getEstado() + "',"
                    + orden.getCodigo() + ",'"
                    + orden.getNombre_pro() + "',"
                    + orden.getPrecio_pro() + "," 
                    + orden.getCantidad() + "," 
                    + orden.getTotalOrden() + ","
                    + id_cl + ")";
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
     * @return 
     */
    public boolean deleteCompra(int buscar){
        try {
            Statement statement = BasedeDatos.conn.createStatement();
            statement.executeUpdate(String.format("delete from factura where id_factura = %d;",buscar));
            System.out.println("Compra Eliminada exitosamente");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean deleteCompraEmpresa(int buscar){
        try {
            Statement statement = BasedeDatos.conn.createStatement();
            statement.executeUpdate(String.format("delete from factura1 where id_factura = %d;",buscar));
            System.out.println("Compra Eliminada exitosamente");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
