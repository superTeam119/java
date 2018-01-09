/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLNewClassController implements Initializable {

    /**
     * Initializes the controller class.
     *
     */
    List<ComboBox> typeField = new ArrayList<ComboBox>();
    List<TextField> nameField = new ArrayList<TextField>();
    List<CheckBox> methods = new ArrayList<CheckBox>();

    @FXML
    private TextField numberOfAtt;
    @FXML
    private GridPane gridPane;
    @FXML
    private TextField className;
    @FXML
    private CheckBox sub;
    @FXML
    private ComboBox superClass;
    @FXML
    private ComboBox chooseClass;
    @FXML
    private GridPane attributesPlace;

//        public void methodTest(ActionEvent event){
//        
//        
////            List<String> fnameNew=Generator.getClassNames();
////                fnameNew=Generator.getClassNames();
////                 
////                 chooseClass.getItems().addAll(fnameNew);
//                 
//                 
//                 
//        }
//        public void attributesFill(ActionEvent event) throws ClassNotFoundException {
//        
//          
//                }
    public void fill(ActionEvent event) throws IOException {

        gridPane.getChildren().clear();
        int n = Integer.parseInt(numberOfAtt.getText().trim());

        int index = 0;
        String attribute;

        for (int i = 0; i < n; i++) {
            index = i + 1;
            attribute = "attribute " + (i + 1);
            Text nbAttributes = new Text(attribute);
            gridPane.add(nbAttributes, 0, i);//attribute i
            ComboBox dataTypeField = new ComboBox();
            dataTypeField.getItems().addAll("long", "float", "double", "char", "boolean", "String", "Date", "int");
            gridPane.add(dataTypeField, 2, i);// type of attribute i field
            typeField.add(dataTypeField);
            TextField dataNameField = new TextField();//name of attribute i field
            gridPane.add(dataNameField, 1, i);
            nameField.add(dataNameField);
            CheckBox checkBox = new CheckBox("");
            methods.add(checkBox);
            gridPane.add(checkBox, 3, i);

        }

    }

    public void enable(ActionEvent event) {

        if (sub.isSelected() == true) {

            List<String> fname = Generator.getClassNames();

            superClass.getItems().addAll(fname);

            superClass.setDisable(false);

        } else {
            superClass.getItems().clear();
            superClass.setDisable(true);
        }
    }

    public void generateYourClass(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException {

        String classText = "";
        ClassDetails classInfo = new ClassDetails();
        classInfo.setSuperClass(superClass.getValue().toString().trim());
        classInfo.setSubClass(sub.isSelected());
        classInfo.setClassName(className.getText());
        for (int i = 0; i < typeField.size(); i++) {
            classInfo.addAttribute(nameField.get(i).getText(), typeField.get(i).getValue().toString().trim(), methods.get(i).isSelected());
        }
        //classText = classText + Generator.getClassText(typeField, nameField, className.getText().trim(), methods, sub, superClass);
        ClassGenerator.compileClass(classInfo);

        //System.out.println(classText); 
    }

    public void handleButtonAction(ActionEvent event) throws IOException {

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLNewObject.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.setTitle("Object");
        app_stage.show();

    }

    public void newScene(ActionEvent event) throws IOException {

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLNewObject.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.setTitle("Instance of Class");
        app_stage.show();

        //  attributesPlace.add(chooseClass, 0, 0);
    }

    public void methodScene(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLMethods.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.setTitle("Methods");
        app_stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
