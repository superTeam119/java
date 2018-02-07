/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FxmlFiles;

import DictionaryApplication.Dictionary;
import DictionaryApplication.Generator;
import DictionaryApplication.Pair;
import static FxmlFiles.FXMLNewObjectController.dictionaries;
import static FxmlFiles.FXMLNewObjectController.pool;
import UserClasses.superDictionary;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Issa
 */
public class FXMLFriendsEnemyController implements Initializable {
@FXML
private RadioButton friend;
@FXML
private RadioButton enemy;
@FXML
private ComboBox classNames;
@FXML
private ComboBox objectNames;
@FXML
private ComboBox toAddObjectNames;
@FXML
private Button Back;
@FXML
private Button add;

@Override
    public void initialize(URL url, ResourceBundle rb) {
        classNames.getItems().addAll(Generator.getClassNames());
    }    
    public void generateNewObjects(ActionEvent event){}
    public void generateObjects(ActionEvent event){objectNames.getItems().clear();
    toAddObjectNames.getItems().clear();
        objectNames.getItems().addAll(Generator.getClassObject(classNames.getValue().toString(),pool));
        toAddObjectNames.getItems().addAll(Generator.getClassObject(classNames.getValue().toString(),pool));
        
    }
    public void add(ActionEvent event){
        if(friend.isSelected()==true)
        {//dictionaries.get(classNames.getValue().toString()).getDico().get(pool.get(classNames.getValue().toString() + "." + objectNames.getValue().toString())).toString());
        Dictionary<superDictionary> d=dictionaries.get(classNames.getValue().toString());
        superDictionary s=pool.get(classNames.getValue().toString() + "." + objectNames.getValue().toString());
       //superDictionary sd=d.getDico().get(s);
        
        }
        }
    public void addEnemy(){}
    public void addFriend(){}
    public void methodView(ActionEvent event) throws IOException{
    
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLCollectionMethos.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.setTitle("Methods Collection Class");
        app_stage.show();
    }
      public void Back(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLNewObject.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        //app_stage.setTitle("Methods");
        app_stage.show();

    }
    public void enemyOff(ActionEvent event){
    enemy.setSelected(false);
    }
    public void friendOff(ActionEvent event){
    friend.setSelected(false);
    }
     
}
