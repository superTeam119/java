/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 *
 * @author user
 */


public class FXMLDocumentController implements Initializable {
    
    @FXML
    //private Label label;
    public void close(ActionEvent event) throws IOException {
    
        Platform.exit();
        System.exit(0);
    }
   
    
    public void generate(ActionEvent event) throws IOException{
    
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLNewClass.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.setTitle("Java Class");
        app_stage.show();
        
    
    }
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
