/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FxmlFiles;

import DictionaryApplication.Dictionary;
import DictionaryApplication.Generator;
import DictionaryApplication.SuperType;
import static FxmlFiles.FXMLNewObjectController.classMap;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
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
public class Start extends Application {
    
       public static Map<String,HashMap<String,SuperType>> pool = new HashMap<String, HashMap<String,SuperType>>();
   public static Map<String,Dictionary<SuperType>> dictionaries=new HashMap<String,Dictionary<SuperType>>();

   public void start(Stage stage) throws Exception {
           URLClassLoader classLoader = new URLClassLoader(new URL[]{new File("./").toURI().toURL()});
       
           List<String> classNames = Generator.getClassNames();
        classNames = Generator.getClassNames();
        for(String className:classNames){
            pool.put(className,new HashMap<String,SuperType>());
          Class<?> c = classLoader.loadClass("UserClasses1." + className);
          classMap.put(className, c);
            //dictionaries.put(className,new Dictionary<SuperType>());
        }
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/simple.css");
      
                
        stage.setScene(scene);
       // stage.setTitle("Dictionary Generator Application ");
        stage.show();
    }
    public static Map<String,HashMap<String,SuperType>> tmpPool=null ;
   public static Map<String,Dictionary<SuperType>> tmpDictionaries=null;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
