package utils;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
 
public class RenderView {
    
    public void AbrirVentanaClientes(String nombre, String titulo){
        Pane root = null;
        try {
            root = (Pane) FXMLLoader.load(RenderView.class.getResource("/view/"+nombre+".fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void cerrarVentana(Node nodo){
        Stage stg = (Stage) nodo.getScene().getWindow();
        stg.close();
    }
 
}