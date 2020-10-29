package DAO;

import utils.BasedeDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
import model.Empresa;
import model.Individual;

/**
 * Esta clase nos presenta los mecanismo para acceder a la base de datos
 * y manejar la información de la tabla carrera
 */
public class ClientesDAO {

    /**
     * Método para obtener todos los registros de la base de datos como objetos
     * @return List de Cliente
    */
    public List<Individual> getDBClienteIndividual(){
        List<Individual> clienteIndividual = new ArrayList<>();
        try {
            Statement statement = BasedeDatos.conn.createStatement();
            String consulta = " SELECT id, nombres, apellidos, direccion, dpi"+
                              " FROM individuales";
            ResultSet rs = statement.executeQuery(consulta);
            while(rs.next()){
                clienteIndividual.add(new Individual(rs.getInt("id"),rs.getString("nombres"),rs.getString("apellidos"),
                rs.getString("direccion"),rs.getString("dpi")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return clienteIndividual;
    }
    
    public List<Empresa> getDBClienteEmpresa(){
        List<Empresa> clienteEmpresa = new ArrayList<Empresa>();
        try {
            Statement statement = BasedeDatos.conn.createStatement();
            String consulta = " SELECT id, nombres, apellidos, direccion, contacto"+
                              " FROM empresa";
            ResultSet rs = statement.executeQuery(consulta);
            while(rs.next()){
                clienteEmpresa.add(new Empresa(rs.getInt("id"),rs.getString("nombres"),rs.getString("apellidos"),
                rs.getString("direccion"),rs.getString("contacto")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return clienteEmpresa;
    }
    /**
     * Método que sirve para guardar un registro de tipo cliente en la base de datos
     * @param individual
     * @return 
     */
    public boolean saveClienteIndividual(Individual individual){
        try {
            Statement statement = BasedeDatos.conn.createStatement();
            String dml = "INSERT INTO individuales(id,nombres,apellidos,direccion,dpi) VALUES("+
                        individual.getId() + ",'" + individual.getNombres() + "','" + individual.getApellidos() + 
                    "','" + individual.getDireccion() + "','" + individual.getDPI() + "')";
            System.out.println("Cliente Almacenado correctamente a la Base de Datos");
            statement.executeUpdate(dml);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    
    public boolean saveClienteEmpresa(Empresa empresa){
        SQL sql = new SQL();
        int i = sql.id_incrementableClienteEmpresa();
        try {
            Statement statement = BasedeDatos.conn.createStatement();
            String dml = "INSERT INTO empresa(id,nombres,apellidos,direccion,contacto) VALUES("+
                        i + ",'" + empresa.getNombres() + "','" + empresa.getApellidos() + 
                    "','" + empresa.getDireccion() + "','" + empresa.getContacto() + "')";
            System.out.println("Cliente Almacenado correctamente a la Base de Datos");
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
    public boolean deleteClienteIndividual(int buscar){
        try {
            Statement statement = BasedeDatos.conn.createStatement();
            statement.executeUpdate(String.format("delete from individuales where id = %d;",buscar));
            System.out.println("Cliente Eliminado exitosamente");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean deleteClienteEmpresa(int buscar){
        try {
            Statement statement = BasedeDatos.conn.createStatement();
            statement.executeUpdate(String.format("delete from empresa where id = %d;",buscar));
            System.out.println("Cliente Eliminado exitosamente");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    /**
     * Método para modificar un registro tipo cliente en la base de datos
     * @param nombres
     * @param apellidos
     * @param direccion
     * @param dpi
     * @param buscar
     */
    public boolean updateClienteIndividual(String nombres, String apellidos, String direccion, String dpi, int buscar){
        try {
            Statement statement = BasedeDatos.conn.createStatement();
            statement.executeUpdate(String.format("update individuales set nombres = %s, apellidos = %s,"
                    + "direccion = %s, dpi = %s where id = %d;","'"+nombres+"'","'"+apellidos+"'",
                    "'"+direccion+"'","'"+dpi+"'",buscar));
            System.out.println("Se han actualizado los datos exitosamente");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public boolean updateClienteEmpresa(String nombres, String apellidos, String direccion, String contacto, int buscar){
        try {
            Statement statement = BasedeDatos.conn.createStatement();
            statement.executeUpdate(String.format("update empresa set nombres = %s, apellidos = %s,"
                    + "direccion = %s, contacto = %s where id = %d;","'"+nombres+"'","'"+apellidos+"'",
                    "'"+direccion+"'","'"+contacto+"'",buscar));
            System.out.println("Se han actualizado los datos exitosamente");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    /*
    verificar en base de datos que se encuentre un producto
    select *
    from productos where id = 7691;
    */
}
