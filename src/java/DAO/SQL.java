/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utils.BasedeDatos;

/**
 *
 * @author pc
 */
public class SQL {
    
    public int id_incrementableClienteIndividual(){
        int id = 1;
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = BasedeDatos.conn.createStatement();
            String consulta = " SELECT MAX(id) FROM individuales;";
            rs = statement.executeQuery(consulta);
            while(rs.next()){
               id = rs.getInt(1) + 1;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally{
            try{
                statement.close();
                rs.close();
            }catch(Exception e){
                
            }
        }
        return id;
    }
    
    public int id_incrementableClienteEmpresa(){
        int id = 1;
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = BasedeDatos.conn.createStatement();
            String consulta = " SELECT MAX(id) FROM empresa;";
            rs = statement.executeQuery(consulta);
            while(rs.next()){
               id = rs.getInt(1) + 1;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally{
            try{
                statement.close();
                rs.close();
            }catch(Exception e){
                
            }
        }
        return id;
    }
}
