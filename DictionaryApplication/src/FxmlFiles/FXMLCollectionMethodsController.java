/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FxmlFiles;

import DictionaryApplication.Dictionary;
import DictionaryApplication.Generator;
import static FxmlFiles.DictionaryStart.dictionaries;
import static FxmlFiles.DictionaryStart.pool;
import UserClasses.SuperType;
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
public class FXMLCollectionMethodsController implements Initializable {

    /**
     * Initializes the controller class.
     */
@FXML
private ComboBox classNames;
@FXML
private ComboBox methods;
@FXML
private ListView oListView;
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       // oListView.setItems((ObservableList) Generator.getClassObject(classNames.getValue().toString(), pool));
        methods.getItems().add("add");
        methods.getItems().add("remove");        
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
     public void fillList(ActionEvent event){oListView.getItems().clear();
         oListView.getItems().addAll( Generator.getClassObject(classNames.getValue().toString())); 
     }
 public void resultMethod(ActionEvent event) throws IOException {System.out.println("sss");
//                        if(methods.getValue().toString().equals("add")){
//                            for(String s : pool.get(classNames.getValue().toString()).keySet())
//                                System.out.println("." + s + ".");
//                            Dictionary<SuperType> dictionary=dictionaries.get(classNames.getValue().toString());
//                            SuperType element=pool.get(classNames.getValue().toString()).get(oListView.getSelectionModel().getSelectedItem().toString());
//                            System.out.println(element.toString());
//                            for(SuperType s : dictionaries.get(classNames.getValue().toString()).getElements().keySet())
//                                System.out.println("." + s + ".");
//                            
//                            dictionary.add(element);
//                            
//                            //dictionaries.get(classNames.getValue().toString()).add(pool.get(classNames.getValue().toString()).get(oListView.getSelectionModel().getSelectedItem().toString()));
//                        }
       ObservableList<String> selectedItems =  oListView.getSelectionModel().getSelectedItems();
                        List<SuperType> oArrayList=new ArrayList<SuperType>();
                        for(String s : selectedItems){
                            SuperType obj=pool.get(classNames.getValue().toString()).get(s);
                            System.out.println(obj);
                            oArrayList.add(obj);
                            System.out.println(obj.toString());
                        }
                        Method m= null;
                        SuperType[] oArray=new SuperType[oArrayList.size()];
                        for(int i=0;i<oArrayList.size();i++){
                            oArray[i]=oArrayList.get(i);
                        }
//                        SuperType[] oArray=(SuperType[]) oArrayList.toArray();
                      // SuperType[]  oArray=(SuperType[]) oArrayList.toArray();
                       
                      // ArrayList<Class<?>> oClass=new ArrayList<Class<?>>();
                       Class<?>[] oClass=new Class<?>[oArray.length];
                       for(int j=0; j< oArray.length; j++)
                           oClass[j]=Object.class;//(oArray[j].getClass());
                       String oMethod=methods.getValue().toString();
                        try {
                            m=dictionaries.get(classNames.getValue().toString()).getClass().getMethod(methods.getValue().toString(), oClass);
                            //m=Dictionary.class.getMethod(oMethod, oClass);
                            
                            System.out.println("done");
                        } catch (NoSuchMethodException ex) {System.out.println(ex.getMessage());
                            Logger.getLogger(FXMLCollectionMethodsController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SecurityException ex) {System.out.println(ex.getMessage());
                            Logger.getLogger(FXMLCollectionMethodsController.class.getName()).log(Level.SEVERE, null, ex);
                        }catch(Exception ex){System.out.println(ex.getMessage());}
                        try {
                            //pool.
                            m.invoke(dictionaries.get(classNames.getValue().toString()),oArray);
                            System.out.println("done");
                        } catch (IllegalAccessException ex) {System.out.println(ex.getMessage());
                            Logger.getLogger(FXMLCollectionMethodsController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IllegalArgumentException ex) {System.out.println(ex.getMessage());
                            Logger.getLogger(FXMLCollectionMethodsController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InvocationTargetException ex) {System.out.println(ex.getMessage());
                            Logger.getLogger(FXMLCollectionMethodsController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        catch(Exception ex){System.out.println(ex.getMessage());}


    }

}
