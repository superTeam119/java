/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FxmlFiles;

import DictionaryApplication.Dictionary;
import DictionaryApplication.Generator;
import UserClasses.superDictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Abo Ali
 */
public class DictionaryStart extends Application {
       public static Map<String, superDictionary> pool = new HashMap<String, superDictionary>();
   public static Map<String,Dictionary> dictionaries=new HashMap<String,Dictionary>();

   public void start(Stage stage) throws Exception {
           List<String> classNames = Generator.getClassNames();
        classNames = Generator.getClassNames();
        for(String className:classNames)
            dictionaries.put(className,new Dictionary<superDictionary>());
    
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/simple.css");
      
                
        stage.setScene(scene);
       // stage.setTitle("Dictionary Generator Application ");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
