/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FxmlFiles;

import DictionaryApplication.Dictionary;
import DictionaryApplication.Generator;
import static FxmlFiles.Start.dictionaries;
import static FxmlFiles.Start.pool;
import DictionaryApplication.SuperType;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SelectionModel;
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
        methods.setDisable(true);
        methods.getItems().add("add");
        methods.getItems().add("remove");
        methods.getItems().add("clear");
        methods.getItems().add("contains");
        methods.getItems().add("addAll");
        methods.getItems().add("removeAll");
        methods.getItems().add("containsAll");
        methods.getItems().add("size");
        methods.getItems().add("isEmpty");
        methods.getItems().add("toArray");
        methods.getItems().add("hashCode");

        classNames.getItems().addAll(dictionaries.keySet());
        // oListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public void methodEnable(ActionEvent event) {
        methods.setDisable(false);
    }

    public void Back(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLDictionary.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        //app_stage.setTitle("Methods");
        app_stage.show();

    }

    public void fillList(ActionEvent event) {
        oListView.getItems().clear();

        oListView.getItems().addAll(Generator.getClassObject(classNames.getValue().toString()));
        String methodName = methods.getValue().toString();
        if (methodName.equals("add") || methodName.equals("addAll")) {
            oListView.getItems().removeAll(Generator.dictionaryObjects(classNames.getValue().toString()));
        }
        if (methodName.contains("All")) {
            oListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        } else {
            oListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        }
        if (!(methodName.equals("size") == false && methodName.equals("isEmpty") == false && methodName.equals("toArray") == false && methodName.equals("clear") == false)) {
            oListView.getItems().clear();

        }
    }

    public void resultMethod(ActionEvent event) throws IOException {
//                        if(methodName.equals("add")){
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
        try {

            String methodName = methods.getValue().toString();
            ObservableList<String> selectedItems = oListView.getSelectionModel().getSelectedItems();
            List<SuperType> oArrayList = new ArrayList<SuperType>();
            for (String s : selectedItems) {
                SuperType obj = pool.get(classNames.getValue().toString()).get(s);
                System.out.println(obj);
                oArrayList.add(obj);
                System.out.println(obj.toString());
            }
            Method m = null;
            SuperType[] oArray;
            if (methodName.equals("size") == false && methodName.equals("isEmpty") == false && methodName.equals("toArray") == false && methodName.equals("clear") == false) {
                oArray = new SuperType[oArrayList.size()];
                for (int i = 0; i < oArrayList.size(); i++) {
                    oArray[i] = oArrayList.get(i);

                }
                if (oArrayList.size() == 0) {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Warning");
                    alert.setResizable(false);
                    alert.getDialogPane().setPrefSize(250, 320);
                    alert.setContentText("make sure you have assigned the right values to all variables!");
                    alert.showAndWait();

                    return;
                }
            } else {
                oArray = new SuperType[0];
            }
//                        SuperType[] oArray=(SuperType[]) oArrayList.toArray();
            // SuperType[]  oArray=(SuperType[]) oArrayList.toArray();

            // ArrayList<Class<?>> oClass=new ArrayList<Class<?>>();
            Class<?>[] oClass = new Class<?>[oArray.length];
            if (methodName.equals("size") == false && methodName.equals("isEmpty") == false && methodName.equals("toArray") == false && methodName.equals("clear") == false) {
                for (int j = 0; j < oArray.length; j++) {
                    oClass[j] = Object.class;//(oArray[j].getClass());
                }
            } else {
                oClass = new Class[0];
            }
            String oMethod = methodName;
            try {
                if (methodName.contains("All")) {
                    m = dictionaries.get(classNames.getValue().toString()).getClass().getMethod(methodName, Collection.class);
                } else {

                    m = dictionaries.get(classNames.getValue().toString()).getClass().getMethod(methodName, oClass);
                }
                //m=Dictionary.class.getMethod(oMethod, oClass);

                System.out.println("done");
            } catch (NoSuchMethodException ex) {
                System.out.println(ex.getMessage());
                Logger.getLogger(FXMLCollectionMethodsController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                System.out.println(ex.getMessage());
                Logger.getLogger(FXMLCollectionMethodsController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            try {
                //pool.
                Object o;
                if (methodName.contains("All")) {
                    o = m.invoke(dictionaries.get(classNames.getValue().toString()), oArrayList);
                } else {
                    o = m.invoke(dictionaries.get(classNames.getValue().toString()), oArray);
                }
                System.out.println(methodName + "of " + classNames.getValue().toString() + o.toString());
                System.out.println("done");
            } catch (IllegalAccessException ex) {
                System.out.println(ex.getMessage());
                Logger.getLogger(FXMLCollectionMethodsController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                Logger.getLogger(FXMLCollectionMethodsController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                System.out.println(ex.getMessage());
                Logger.getLogger(FXMLCollectionMethodsController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        } catch (Exception e) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setResizable(false);
            alert.getDialogPane().setPrefSize(250, 320);
            alert.setContentText("make sure you have assigned the right values to all variables!");
            alert.showAndWait();

        }
    }

}
