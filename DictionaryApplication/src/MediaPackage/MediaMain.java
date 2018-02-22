/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MediaPackage;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Abo Ali
 */
public class MediaMain extends Application {
    

    @Override
    public void start(Stage primaryStage) throws IOException {
       
   
 Stage app_stage;
//File deleteFile=new File("C:\\Users\\Abo Ali\\Desktop\\ثقافة عامة\\فيلم عن حرب بيروت لمجزرة - عين الرمانة - وبداية الحرب الأهلية اللبنانية - YouTube.MP4");
//if(deleteFile.exists()){
//    deleteFile.delete();
//    System.out.println(deleteFile.getName() +"is deleted");
//}
                 try {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/MediaPackage/ObjectProfileForm.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
         app_stage = primaryStage;
        app_stage.setScene(home_page_scene);
        //app_stage.setTitle("Methods");
  
        app_stage.show();
                  
    
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
