/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Import_Export;

import MediaPackage.MediaMain;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Abo Ali
 */
public class main extends Application {

     @Override
    public void start(Stage primaryStage) throws IOException {
       
                 try {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource(".\\src\\Import_Export\\ImportForm.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
         primaryStage = primaryStage;
        primaryStage.setScene(home_page_scene);
        primaryStage.setTitle("Import Form");
  
        primaryStage.show();
                  
    
                 } catch (IOException ex) {
                     Logger.getLogger(MediaMain.class.getName()).log(Level.SEVERE, null, ex);
                 }
     
       
   
     
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
