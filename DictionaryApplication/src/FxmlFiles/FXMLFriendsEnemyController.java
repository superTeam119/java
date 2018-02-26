/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FxmlFiles;//done

import DictionaryApplication.Dictionary;
import DictionaryApplication.Generator;
import DictionaryApplication.Pair;
import static FxmlFiles.Start.dictionaries;
import static FxmlFiles.Start.pool;
import DictionaryApplication.SuperType;
import static FxmlFiles.Start.dictionaries;
import static FxmlFiles.Start.pool;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
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
@FXML
private ListView friendList;
@FXML
private ListView enemyList;

@Override
    public void initialize(URL url, ResourceBundle rb) {
        classNames.getItems().addAll(dictionaries.keySet());
    }    
    public void classObjects(ActionEvent event){
        Set<SuperType> keys=dictionaries.get(classNames.getValue().toString()).getElements().keySet();
        if(keys==null)
            System.out.println("empty");
        if(keys.size()==0)
            System.out.println("0");
        System.out.println(keys.size());
        System.out.println(keys.toArray()[0].toString());
        List<String> poolKeys= Generator.getClassObject(classNames.getValue().toString());
        for(SuperType key:keys)
            System.out.println(key.toString());
        for(String key:poolKeys){System.out.println(key);
            System.out.println(keys.size());
            if(keys.contains(pool.get(classNames.getValue().toString()).get(key)))
                objectNames.getItems().add(key);
        }
//objectNames.getItems().addAll(dictionaries.get(classNames.getValue().toString()).getElements().keySet());
    }
    public void generateObjects(ActionEvent event){friendList.getItems().clear();
        enemyList.getItems().clear();
        System.out.println("ss");
        String className=classNames.getValue().toString();
        Dictionary<SuperType> objDictionary=dictionaries.get(className);
        toAddObjectNames.getItems().clear();
        //String fromKey=className + "." + objectNames.getValue().toString();
        String fromKey=objectNames.getValue().toString();
        SuperType from=pool.get(className).get(fromKey);
        Set<SuperType> friends=objDictionary.getElements().get(from).getFriend();
//        friendList.getItems().addAll(friends);
        Set<SuperType> enemies=objDictionary.getElements().get(from).getEnemy();
        Set<SuperType> related=new HashSet<SuperType>();
        related.addAll(objDictionary.getElements().get(from).getFriend());
        related.addAll(objDictionary.getElements().get(from).getEnemy());
        related.add(from);//i cannot be friend or enemy to me
        List<String> keys=Generator.getClassObject(className);
        for(String key:keys){System.out.println(key);System.out.println(friends.size()+"." +enemies.size());
//            System.out.println(friends.toArray()[0].toString());
        SuperType obj=pool.get(className).get(key);
            if(related.contains(obj)==false && objDictionary.getElements().keySet().contains(obj))
                toAddObjectNames.getItems().add(key);
            if(friends.contains(obj)==true )
                friendList.getItems().add(key);
            if(enemies.contains(obj)==true)
                enemyList.getItems().add(key);
        }
        //Set<String>
      //  objectNames.getItems().addAll(objDictionary.getElements().keySet());
        //toAddObjectNames.getItems().addAll(objDictionary.getElements().keySet());
        //objectNames.getItems().addAll(Generator.getClassObject(classNames.getValue().toString(),pool));
        //toAddObjectNames.getItems().addAll(Generator.getClassObject(classNames.getValue().toString(),pool));
        
    }
    public void add(ActionEvent event){
        Dictionary<SuperType> objDictionary=dictionaries.get(classNames.getValue().toString());
        SuperType obj=pool.get(classNames.getValue().toString()).get(objectNames.getValue().toString());
        SuperType objToAdd=pool.get(classNames.getValue().toString()).get(toAddObjectNames.getValue().toString());
        Set<SuperType> friends,enemies,friendsTo,enemiesTo,tmpFriends,tmpEnemies,iter,toAdd;
        friends= objDictionary.getElements().get(obj).getFriend();
         enemies=objDictionary.getElements().get(obj).getEnemy();
         friendsTo= objDictionary.getElements().get(objToAdd).getFriend();
         enemiesTo=objDictionary.getElements().get(objToAdd).getEnemy();
         iter=new HashSet<SuperType>();
         toAdd=new HashSet<SuperType>();
        if(friend.isSelected()==true)
        {
         friends.add(objToAdd);
         friendsTo.add(obj);
         friends.addAll(friendsTo);
         //friendsTo.addAll(friends);
         enemies.addAll(enemiesTo);
         iter.addAll(friends);
         toAdd.addAll(friends);//krml bs a3ml remove la 7ale dal zedo 3nd l be2yen
         //enemiesTo.addAll(enemies);
         for(SuperType f:iter){
             //if(f.equals(obj)==false && f.equals(objToAdd))//krml eza ma7et 7ale mn l friends bbatel zedo krml 2 r7 ysero nfs l pointer friends aw b3ml clone
             tmpFriends=objDictionary.getElements().get(f).getFriend();
             tmpEnemies=objDictionary.getElements().get(f).getEnemy();
             tmpFriends.addAll(toAdd);
             tmpEnemies.addAll(enemies);
             tmpFriends.remove(f);
         }//for loop a3de2
         iter.clear();
         iter.addAll(enemies);
         toAdd.clear();
         toAdd.addAll(enemies);
         for(SuperType e:iter){
             tmpFriends=objDictionary.getElements().get(e).getFriend();
             tmpEnemies=objDictionary.getElements().get(e).getEnemy();
             tmpEnemies.addAll(friends);
             tmpFriends.addAll(enemies);
             tmpFriends.remove(e);
         }
         //friends.remove(obj);
         //friendsTo.remove(objToAdd);
         //recursivee  pluss 3nd kil l ref2a :P
         //objDictionary.getElements().get(obj).getFriend().add(objToAdd);
         
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setResizable(false);
        alert.getDialogPane().setPrefSize(200, 200);
        alert.setContentText("Friend added");
        alert.showAndWait();
        }
        if(enemy.isSelected()==true)
        {
            enemies.add(objToAdd);
         enemiesTo.add(obj);
         friends.addAll(enemiesTo);
         enemies.addAll(friendsTo);
         iter.addAll(enemies);
         toAdd.addAll(enemies);//krml bs a3ml remove la 7ale dal zedo 3nd l be2yen
         
         for(SuperType e:iter){
             tmpFriends=objDictionary.getElements().get(e).getFriend();
             tmpEnemies=objDictionary.getElements().get(e).getEnemy();
             tmpFriends.addAll(toAdd);
             tmpEnemies.addAll(friends);
             tmpFriends.remove(e);
         }
         iter.clear();
         iter.addAll(friends);
         toAdd.clear();
         toAdd.addAll(friends);
         
         for(SuperType f:iter){
             tmpFriends=objDictionary.getElements().get(f).getFriend();
             tmpEnemies=objDictionary.getElements().get(f).getEnemy();
             tmpFriends.addAll(toAdd);
             tmpEnemies.addAll(enemies);
             tmpFriends.remove(f);
         }     
         
         
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setResizable(false);
        alert.getDialogPane().setPrefSize(200, 200);
        alert.setContentText("Enemy added");
        alert.showAndWait();
            }
        if(objectNames.getSelectionModel().getSelectedIndex()==0)
        {objectNames.getSelectionModel().selectNext();
                objectNames.getSelectionModel().selectPrevious();
        }
        else
        {objectNames.getSelectionModel().selectPrevious();
                    objectNames.getSelectionModel().selectNext();
        }
    }
    public void addEnemy(){}
    public void addFriend(){}
//    public void methodView(ActionEvent event) throws IOException{
//    
//        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLCollectionMethods.fxml"));
//        Scene home_page_scene = new Scene(home_page_parent);
//        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        app_stage.setScene(home_page_scene);
//        app_stage.setTitle("Methods Collection Class");
//        app_stage.show();
//    }
      public void Back(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLDictionary.fxml"));
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
