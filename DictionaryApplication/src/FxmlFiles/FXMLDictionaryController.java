/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FxmlFiles;

import DictionaryApplication.Dictionary;
import DictionaryApplication.Generator;
import static FxmlFiles.Start.dictionaries;
import DictionaryApplication.SuperType;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLDictionaryController implements Initializable {
    @FXML
    private ComboBox classNames;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Set<String> all=new HashSet(Generator.getClassNames());
        //all.removeAll(dictionaries.keySet());
        classNames.getItems().addAll(all);
        
    }

    public void FriendsAndEnemies(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLFriendsEnemy.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        //app_stage.setTitle("Methods");
        app_stage.show();
    }

        public void deleteDictionary(ActionEvent event) {
         String className=classNames.getValue().toString();
            dictionaries.remove(className);
            System.out.println("deleted");
        }
    public void Methods(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLCollectionMethods.fxml"));

        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        //app_stage.setTitle("Methods");
        app_stage.show();
    }
    public void impExp(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/Import_Export/Import_Export_Form.fxml"));

        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        //app_stage.setTitle("Methods");
        app_stage.show();
    }

    public void Back(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLMain.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        home_page_scene.getStylesheets().add("/css/simple.css");
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        //app_stage.setTitle("Methods");
        app_stage.show();
    }

    public void CreateDictionary() {
        try{
        String className=classNames.getValue().toString();
        dictionaries.put(className,new Dictionary<SuperType>());
        classNames.getItems().remove(className);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setResizable(false);
        alert.getDialogPane().setPrefSize(200, 200);
        alert.setContentText("Dictionary "+className+" created");
        alert.showAndWait();
        }
        catch(Exception e)
       { Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Warning");
                    alert.setResizable(false);
                    alert.getDialogPane().setPrefSize(250, 320);
                    alert.setContentText("choose a class");
                    alert.showAndWait();
       }
       
        }
}
