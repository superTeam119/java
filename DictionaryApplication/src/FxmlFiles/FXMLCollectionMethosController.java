/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FxmlFiles;

import DictionaryApplication.Dictionary;
import DictionaryApplication.Generator;
import static FxmlFiles.FXMLNewObjectController.dictionaries;
import static FxmlFiles.FXMLNewObjectController.pool;
import UserClasses.superDictionary;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Issa
 */
public class FXMLCollectionMethosController implements Initializable {

    /**
     * Initializes the controller class.
     */
@FXML
private ComboBox classNames;
@FXML
private ComboBox method;
@FXML
private ListView oListView;
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       // oListView.setItems((ObservableList) Generator.getClassObject(classNames.getValue().toString(), pool));
         classNames.getItems().addAll(Generator.getClassNames());       
       
    }   
   
     public void Back(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLFriendsEnemy.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        //app_stage.setTitle("Methods");
        app_stage.show();

    }
     public void fillList(ActionEvent event){
         oListView.getItems().addAll( Generator.getClassObject(classNames.getValue().toString(), pool)); 
     }
 public void resultMethod(ActionEvent event) throws IOException {
       ObservableList<String> selectedItems =  oListView.getSelectionModel().getSelectedItems();
                        List<superDictionary> oArrayList=new ArrayList<superDictionary>();
                        for(String s : selectedItems){
                         oArrayList.add( pool.get(s));
                        }
                        Method m= null;
                       superDictionary[]  oArray=(superDictionary[]) oArrayList.toArray();
                       Class<?>[] oClass= null;
                       for(int j=0; j< oArray.length; j++)
                           oClass[j]= oArray[j].getClass();
                       String oMethod=method.getValue().toString();
                        try {
                            m=Dictionary.class.getMethod(oMethod, oClass);
                        } catch (NoSuchMethodException ex) {
                            Logger.getLogger(FXMLCollectionMethosController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SecurityException ex) {
                            Logger.getLogger(FXMLCollectionMethosController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            //pool.
                            m.invoke(dictionaries.get(classNames.getValue().toString()),oArray);
                        } catch (IllegalAccessException ex) {
                            Logger.getLogger(FXMLCollectionMethosController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IllegalArgumentException ex) {
                            Logger.getLogger(FXMLCollectionMethosController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InvocationTargetException ex) {
                            Logger.getLogger(FXMLCollectionMethosController.class.getName()).log(Level.SEVERE, null, ex);
                        }


    }

}
