/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FxmlFiles;

import DictionaryApplication.Dictionary;
import static FxmlFiles.DictionaryStart.*;
import static FxmlFiles.DictionaryStart.pool;
import DictionaryApplication.SuperType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    //@FXML
    //private Label label;
    public void close(ActionEvent event) throws IOException {
             

        Platform.exit();
        System.exit(0);
    }
   
    public void load(ActionEvent event) throws FileNotFoundException, IOException, ClassNotFoundException{
    URLClassLoader classLoader = new URLClassLoader(new URL[]{new File("./").toURI().toURL()});
        File f=new File(".\\xml\\pool.xml");
    FileInputStream ff=new FileInputStream(f);
    ObjectInputStream fff=new ObjectInputStream(ff);
    pool=(HashMap<String, HashMap<String,SuperType>>)fff.readObject();
    File s=new File(".\\xml\\dictionaries.xml");
    FileInputStream ss=new FileInputStream(s);
    ObjectInputStream sss=new ObjectInputStream(ss);
    dictionaries=(HashMap<String,Dictionary<SuperType>>)sss.readObject();
    sss.close();
    fff.close();//catch(Exception ex){System.out.println(ex.getMessage());}
    }
    public void save(ActionEvent event) throws FileNotFoundException, IOException{URLClassLoader classLoader = new URLClassLoader(new URL[]{new File("./").toURI().toURL()});
    File f=new File(".\\xml\\pool.xml");
    FileOutputStream ff=new FileOutputStream(f);
    ObjectOutputStream fff=new ObjectOutputStream(ff);
    fff.writeObject(pool);
    fff.close();
    File s=new File(".\\xml\\dictionaries.xml");
    FileOutputStream ss=new FileOutputStream(s);
    ObjectOutputStream sss=new ObjectOutputStream(ss);
    sss.writeObject(dictionaries);
    sss.close();
    }
    
      public void AddMedia(ActionEvent event) throws IOException{
     
      Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLMedia.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.setTitle("Java Class");
        app_stage.show();
     
     }
    public void generate(ActionEvent event) throws IOException{
    
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLNewClass.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.setTitle("Java Class");
        app_stage.show();
        
    
    }
   public void viewObject(ActionEvent event) throws IOException{
   
       Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLDictionary.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.setTitle("Java Class");
        app_stage.show();
   
   }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        try {
//            // TODO
//            //URLClassLoader   classLoader = new URLClassLoader(new URL[]{new File("./").toURI().toURL()});
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }    
    
}
