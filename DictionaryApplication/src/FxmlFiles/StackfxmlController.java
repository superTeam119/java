/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FxmlFiles;

import DictionaryApplication.Generator;
import DictionaryApplication.SuperType;
import static FxmlFiles.Start.pool;
import static FxmlFiles.Start.stacks;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Stack;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Issa
 */
public class StackfxmlController implements Initializable {
    
    @FXML
    private ComboBox classStacks;
    @FXML
    private ComboBox classNames;
    @FXML
    private ComboBox objectNames;
    @FXML
    private Button create;
    @FXML
    private Button result;
    @FXML
    private ComboBox methods;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        classStacks.getItems().addAll(Generator.getClassNames());
        classNames.getItems().addAll(stacks.keySet());
        methods.getItems().add("push");
        methods.getItems().add("pop");
        methods.getItems().add("empty");
        
    }    

    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLMain.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        //app_stage.setTitle("Methods");
        app_stage.show();
    }
    public void generate(){
        objectNames.getItems().addAll(pool.get(classNames.getValue().toString()).keySet());
        
    }
    public void create(){
stacks.put(classStacks.getValue().toString(),new Stack<SuperType>());
classNames.getItems().add(classStacks.getValue().toString());
    }
    public void result(){Stack a;
        String methodName=methods.getValue().toString();
        String className=classNames.getValue().toString();
        String objectName=objectNames.getValue().toString();
        Stack<SuperType> stack=stacks.get(className);
        SuperType s;
        Object o;//result
        if(methodName.equals("push"))
            o=stack.push(pool.get(className).get(objectName));
        else
            if(methodName.equals("Empty"))
              o=  stack.empty();
                else
                o=stack.pop();
        System.out.println(o);        
    }
}
