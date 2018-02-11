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
        classNames.getItems().addAll(Generator.getClassNames());
    }    
    public void classObjects(ActionEvent event){
        Set<superDictionary> keys=dictionaries.get(classNames.getValue().toString()).getDico().keySet();
        if(keys==null)
            System.out.println("empty");
        if(keys.size()==0)
            System.out.println("0");
        System.out.println(keys.size());
        System.out.println(keys.toArray()[0].toString());
        List<String> poolKeys= Generator.getClassObject(classNames.getValue().toString(), pool);
        for(superDictionary key:keys)
            System.out.println(key.toString());
        for(String key:poolKeys){System.out.println(key);
            System.out.println(keys.size());
            if(keys.contains(pool.get(classNames.getValue().toString() + "." + key)))
                objectNames.getItems().add(key);
        }
//objectNames.getItems().addAll(dictionaries.get(classNames.getValue().toString()).getDico().keySet());
    }
    public void generateObjects(ActionEvent event){friendList.getItems().clear();
        enemyList.getItems().clear();
        System.out.println("ss");
        String className=classNames.getValue().toString();
        Dictionary<superDictionary> objDictionary=dictionaries.get(className);
        toAddObjectNames.getItems().clear();
        String fromKey=className + "." + objectNames.getValue().toString();
        superDictionary from=pool.get(fromKey);
        Set<superDictionary> friends=objDictionary.getDico().get(from).getFriend();
//        friendList.getItems().addAll(friends);
        Set<superDictionary> enemies=objDictionary.getDico().get(from).getEnemy();
        Set<superDictionary> related=new HashSet<superDictionary>();
        related.addAll(objDictionary.getDico().get(from).getFriend());
        related.addAll(objDictionary.getDico().get(from).getEnemy());
        related.add(from);//i cannot be friend or enemy to me
        List<String> keys=Generator.getClassObject(className, pool);
        for(String key:keys){System.out.println(key);System.out.println(friends.size()+"." +enemies.size());
//            System.out.println(friends.toArray()[0].toString());
        superDictionary obj=pool.get(className + "." + key);
            if(related.contains(obj)==false)
                toAddObjectNames.getItems().add(key);
            if(friends.contains(obj)==true )
                friendList.getItems().add(key);
            if(enemies.contains(obj)==true)
                enemyList.getItems().add(key);
        }
        //Set<String>
      //  objectNames.getItems().addAll(objDictionary.getDico().keySet());
        //toAddObjectNames.getItems().addAll(objDictionary.getDico().keySet());
        //objectNames.getItems().addAll(Generator.getClassObject(classNames.getValue().toString(),pool));
        //toAddObjectNames.getItems().addAll(Generator.getClassObject(classNames.getValue().toString(),pool));
        
    }
    public void add(ActionEvent event){
        Dictionary<superDictionary> objDictionary=dictionaries.get(classNames.getValue().toString());
        superDictionary obj=pool.get(classNames.getValue().toString() + "." + objectNames.getValue().toString());
        superDictionary objToAdd=pool.get(classNames.getValue().toString() + "." + toAddObjectNames.getValue().toString());
        Set<superDictionary> friends,enemies,friendsTo,enemiesTo,tmpFriends,tmpEnemies,iter,toAdd;
        friends= objDictionary.getDico().get(obj).getFriend();
         enemies=objDictionary.getDico().get(obj).getEnemy();
         friendsTo= objDictionary.getDico().get(objToAdd).getFriend();
         enemiesTo=objDictionary.getDico().get(objToAdd).getEnemy();
         iter=new HashSet<superDictionary>();
         toAdd=new HashSet<superDictionary>();
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
         for(superDictionary f:iter){
             //if(f.equals(obj)==false && f.equals(objToAdd))//krml eza ma7et 7ale mn l friends bbatel zedo krml 2 r7 ysero nfs l pointer friends aw b3ml clone
             tmpFriends=objDictionary.getDico().get(f).getFriend();
             tmpEnemies=objDictionary.getDico().get(f).getEnemy();
             tmpFriends.addAll(toAdd);
             tmpEnemies.addAll(enemies);
             tmpFriends.remove(f);
         }//for loop a3de2
         iter.clear();
         iter.addAll(enemies);
         toAdd.clear();
         toAdd.addAll(enemies);
         for(superDictionary e:iter){
             tmpFriends=objDictionary.getDico().get(e).getFriend();
             tmpEnemies=objDictionary.getDico().get(e).getEnemy();
             tmpEnemies.addAll(friends);
             tmpFriends.addAll(enemies);
             tmpFriends.remove(e);
         }
         //friends.remove(obj);
         //friendsTo.remove(objToAdd);
         //recursivee  pluss 3nd kil l ref2a :P
         //objDictionary.getDico().get(obj).getFriend().add(objToAdd);
        }
        if(enemy.isSelected()==true)
        { enemies.add(objToAdd);
         enemiesTo.add(obj);
         friends.addAll(enemiesTo);
         enemies.addAll(friendsTo);
         iter.addAll(enemies);
         toAdd.addAll(enemies);//krml bs a3ml remove la 7ale dal zedo 3nd l be2yen
         
         for(superDictionary e:iter){
             tmpFriends=objDictionary.getDico().get(e).getFriend();
             tmpEnemies=objDictionary.getDico().get(e).getEnemy();
             tmpFriends.addAll(toAdd);
             tmpEnemies.addAll(friends);
             tmpFriends.remove(e);
         }
         iter.clear();
         iter.addAll(friends);
         toAdd.clear();
         toAdd.addAll(friends);
         
         for(superDictionary f:iter){
             tmpFriends=objDictionary.getDico().get(f).getFriend();
             tmpEnemies=objDictionary.getDico().get(f).getEnemy();
             tmpFriends.addAll(toAdd);
             tmpEnemies.addAll(enemies);
             tmpFriends.remove(f);
         }            
            }
    }
    public void addEnemy(){}
    public void addFriend(){}
    public void methodView(ActionEvent event) throws IOException{
    
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLCollectionMethods.fxml"));
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
