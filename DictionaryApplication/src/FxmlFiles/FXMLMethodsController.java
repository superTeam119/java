/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FxmlFiles;

import DictionaryApplication.Generator;
import static FxmlFiles.Start.pool;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
//import static DictionaryApplication.FXMLNewObjectController.pool;

/**
 * FXML Controller class
 *
 * @author Issa
 */
public class FXMLMethodsController implements Initializable {

    @FXML
    private ComboBox firstClassComboBox;
    @FXML
    private ComboBox secondClassComboBox;
    @FXML
    private ComboBox firstObjectComboBox;
    @FXML
    private ComboBox secondObjectComboBox;
    @FXML
    private ComboBox MethodComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MethodComboBox.getItems().addAll("compareTo()", "equals()", "toString()", "hashCode()");
        firstClassComboBox.getItems().addAll(Generator.getClassNames());
        secondClassComboBox.getItems().addAll(Generator.getClassNames());
    }

    public void Back(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLNewClass.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        //app_stage.setTitle("Methods");
        app_stage.show();

    }

    public void firstObjectComboBox1(ActionEvent event) {
    }

    public void secondObjectComboBox2(ActionEvent event) {
    }

    public void firstClassComboBox1(ActionEvent event) {
        firstObjectComboBox.getItems().clear();
       // System.out.println(FXMLNewObjectController.pool.keySet().toString());
        firstObjectComboBox.getItems().addAll(Generator.getClassObject(firstClassComboBox.getValue().toString().trim()));//package plus
    }

    public void secondClassComboBox2(ActionEvent event) {
        secondObjectComboBox.getItems().clear();
        secondObjectComboBox.getItems().addAll(Generator.getClassObject(secondClassComboBox.getValue().toString().trim()));//package plus

    }

    public void MethodComboBox1(ActionEvent event) {
            //firstClassComboBox.getItems().clear();
        //secondClassComboBox.getItems().clear();

//            firstClassComboBox.getItems().addAll(Generator.getClassNames());
//            secondClassComboBox.getItems().addAll(Generator.getClassNames());
    }

    public void result(ActionEvent event) {
        DictionaryApplication.SuperType a;
        DictionaryApplication.SuperType b;
        String result;
        String Methodname = MethodComboBox.getValue().toString().trim();
        //a = pool.get(firstClassComboBox.getValue().toString().trim() + "." + firstObjectComboBox.getValue().toString().trim());
        a=pool.get(firstClassComboBox.getValue().toString().trim()).get(firstObjectComboBox.getValue().toString().trim());
        result = firstObjectComboBox.getValue().toString().trim();
        if (Methodname.equals("toString()")) {
            result = result + ".toString():" + a.toString();
        }
        if (Methodname.equals("hashCode()")) {
            result = result + ".hashCode():" + a.hashCode();
        }
        b = null;
        if (secondClassComboBox.getValue() != null) {
            //b = pool.get(secondClassComboBox.getValue().toString().trim() + "." + secondObjectComboBox.getValue().toString().trim());
            b=pool.get(secondClassComboBox.getValue().toString().trim()).get(secondObjectComboBox.getValue().toString().trim());
        }
        if (Methodname.equals("equals()")) {
            result = result + String.format(".equals(%s):%s", secondObjectComboBox.getValue().toString().trim(), a.equals(b));
        }
        System.out.println(a.getClass());
//        System.out.println(b.getClass());
        if (b != null && a.getClass()!=b.getClass() && Methodname.equals("compareTo()")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Result");
            alert.setResizable(false);
            alert.getDialogPane().setPrefSize(250, 320);
            alert.setContentText("cannot compare different types");
            alert.showAndWait();
            return;
        } else {
            if(Methodname.equals("compareTo()"))
            result = result + String.format(".compareTo(%s):%d", secondObjectComboBox.getValue().toString().trim(), a.compareTo(b));
            
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setResizable(false);
        alert.getDialogPane().setPrefSize(250, 320);
        alert.setContentText(result);
        alert.showAndWait();
        //System.out.println(result);
    }

}
