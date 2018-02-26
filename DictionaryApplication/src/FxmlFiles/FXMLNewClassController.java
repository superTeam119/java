/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FxmlFiles;

import DictionaryApplication.ClassDetails;
import DictionaryApplication.ClassGenerator;
import DictionaryApplication.Dictionary;
import DictionaryApplication.Generator;
import static FxmlFiles.Start.dictionaries;
import static FxmlFiles.Start.pool;
import DictionaryApplication.SuperType;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
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
    ComboBox classKey = new ComboBox();

    @FXML
    private TextField numberOfAtt;
    @FXML
    private Label classStatus;
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
    public void Back(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLMain.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        home_page_scene.getStylesheets().add("/css/simple.css");
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        //app_stage.setTitle("Methods");
        app_stage.show();

    }

    public void fill(ActionEvent event) throws IOException, ClassNotFoundException {

        classKey.getItems().clear();
        gridPane.getChildren().clear();
        int n = Integer.parseInt(numberOfAtt.getText().trim());

        int index = 0;
        String attribute;

        for (int i = 0; i < n; i++) {
            index = i + 1;
            attribute = "attribute " + (i + 1);
            classKey.getItems().add(attribute);
            Text nbAttributes = new Text(attribute);
            gridPane.add(nbAttributes, 0, (i + 1));//attribute i
            ComboBox dataTypeField = new ComboBox();
            dataTypeField.getItems().addAll("long", "float", "double", "char", "boolean", "String", "int");
            dataTypeField.getItems().addAll(Generator.getClassNames());
            System.out.println(Generator.getClassNames());

            gridPane.add(dataTypeField, 2, (i + 1));// type of attribute i field
            typeField.add(dataTypeField);
            TextField dataNameField = new TextField();//name of attribute i field
            gridPane.add(dataNameField, 1, (i + 1));
            nameField.add(dataNameField);
            CheckBox checkBox = new CheckBox("");
            methods.add(checkBox);
            gridPane.add(checkBox, 3, (i + 1));

        }
//        if(sub.isSelected())
//        {Class ccc=Class.forName("UserClasses." + superClass.getValue());
//            classKey.getItems().addAll(ClassGenerator.getFieldsString(ccc));}
//        gridPane.add(new Text("Key"), 1, n+1);
//        gridPane.add(classKey, 1, n+1);

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

    public void jjj(ActionEvent event) {
        System.out.println(className.getText());
    }

    public void generateYourClass(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        //String classText="";
//        int keyIndex = -1;
//        if (classKey.getItems().size() > 0 && classKey.getValue().toString().contains(" ")) {
//            keyIndex = Integer.parseInt(classKey.getValue().toString().trim().substring(10)) - 1;
//        }
        ClassDetails classInfo = new ClassDetails();
        if (sub.isSelected() == true) {
            classInfo.setSuperClass(superClass.getValue().toString().trim());
            classInfo.setSubClass(sub.isSelected());
        }
        classInfo.setClassName(className.getText());
//        if(keyIndex!=-1)
//        classInfo.setKey(nameField.get(keyIndex).getText());
//        else
        //classInfo.setKey(classKey.getValue().toString());    
        for (int i = 0; i < typeField.size(); i++) {
            classInfo.addAttribute(nameField.get(i).getText(), typeField.get(i).getValue().toString().trim(), methods.get(i).isSelected());
        }
        //classText = classText + ClassGenerator.getClassText(classInfo);
        ClassGenerator.compileClass(classInfo);
        pool.put(classInfo.getClassName(), new HashMap<String, SuperType>());
        //dictionaries.put(classInfo.getClassName(), new Dictionary<SuperType>());
        //System.out.println(classText); 
        File f = new File("./media/" + className.getText());
        f.mkdir();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setResizable(false);
        alert.getDialogPane().setPrefSize(200, 200);
        alert.setContentText("Class " + className.getText() + " is created");
        alert.showAndWait();
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

        List<String> AR = new ArrayList<String>();

        AR.add("private");
        AR.add("public");
        AR.add("protected");
        AR.add("static");
        AR.add("void");
        AR.add("int");
        AR.add("float");
        AR.add("double");
        AR.add("String");
        AR.add("boolean");
        AR.add("abstract");
        AR.add("final");
        AR.add("char");

        List<String> savedClasses = Generator.getClassNames();
        classStatus.setTextFill(Color.web("#ff0000"));
        classStatus.setText("enter the class name");
        className.textProperty().addListener((observable, oldValue, newValue)
                -> {
            
            classStatus.setTextFill(Color.web("#ff0000"));
            if (className.getText().equals("")) {
                classStatus.setText("enter the class name");

            }
            String tmp = className.getText();
            char tmpC;
            for (int i = 0; i < tmp.length(); i++) {
                tmpC = tmp.charAt(i);
                if (tmpC == '_' || tmpC == '$' || (tmpC >= 'a' && tmpC <= 'z') || (tmpC >= 'A' && tmpC <= 'Z') || (tmpC >= '0' && tmpC <= '9')) {
                    classStatus.setTextFill(Color.web("#00e600"));
                    classStatus.setText("accepted");
                } else {
                    classStatus.setText("incorrect class name");
                    return;
                }
                if (i == 0 && (tmpC >= '0' && tmpC <= '9')) {
                    classStatus.setTextFill(Color.web("#ff0000"));

                    classStatus.setText("incorrect class name");
                    return;
                }
            }
            if (AR.contains(className.getText())) {
                classStatus.setTextFill(Color.web("#ff0000"));
                classStatus.setText("can't set a JAVA predefined name");
                return;
            }

            if (savedClasses.contains(className.getText())) {
                classStatus.setTextFill(Color.web("#ff0000"));
                classStatus.setText("class name already exists!");
                return;
            }

        }
        );

    }
}
