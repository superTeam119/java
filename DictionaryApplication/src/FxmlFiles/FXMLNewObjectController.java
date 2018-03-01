/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FxmlFiles;

import DictionaryApplication.ClassGenerator;
import DictionaryApplication.Dictionary;
import DictionaryApplication.Fields;
import DictionaryApplication.Generator;
import static FxmlFiles.Start.dictionaries;
import static FxmlFiles.Start.pool;
import DictionaryApplication.SuperType;
import java.io.IOException;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
public class FXMLNewObjectController implements Initializable {
     public static Map<String,Class<?>> classMap=new HashMap<String,Class<?>>();
    /**
     * Initializes the controller class.
     */
    List<TextField> attrField = new ArrayList<TextField>();
    List<Fields> objectFields = new ArrayList<Fields>();
    @FXML
    private ComboBox chooseClass;
    @FXML
    private GridPane attributesPlace;
    @FXML
    public TextField key = new TextField();
    public URLClassLoader classLoader;

    public ComboBox getc() {
        return chooseClass;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            //classLoader = new URLClassLoader(new URL[]{new File("./").toURI().toURL()});
            List<String> classNames = Generator.getClassNames();
            classNames = Generator.getClassNames();
            chooseClass.getItems().addAll(classNames);
        } catch (Exception ex) {
            Logger.getLogger(FXMLNewObjectController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private boolean testException(String type,String input){
        try{
        if(type.equals("int"))
            Integer.parseInt(input);
        if(type.equals("double"))
            Double.parseDouble(input);
        if(type.equals("float"))
            Float.parseFloat(input);
        if(type.equals("boolean"))
            Boolean.getBoolean(input);
        }catch(Exception ex){
            return false;
        }
        return true;
    }
    public void Back(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLNewClass.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        //app_stage.setTitle("Methods");
        app_stage.show();

    }

    public void createObject(ActionEvent event) throws NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
try{
//     Class<?> c=int.class;
//                
//                    c = Class.forName("UserClasses." + chooseClass.getValue().toString().trim());
//                
//        Field[] field = c.getDeclaredFields();
//        ArrayList<Class> params = new ArrayList<>();
//        
//        for(Field f: field)
//        {//System.out.println(f.getType());//.toString().substring(f.getType().toString().lastIndexOf(".")));
//            params.add(f.getType());//    System.out.println(f.getClass().);
//        }
//        Class[] paramsArr= params.toArray(new Class[params.size()]);
//        Constructor<?> cons;
//                System.out.println(params);
//                    cons = c. getConstructor(paramsArr);
//                    ArrayList<Object> b= new ArrayList<>();
//                
//                for (int i = 0; i < field.length; i++) {Object o=attrField.get(i).getText().trim();
//                    String fieldtype=field[i].getType().getSimpleName();
//                    switch(fieldtype){
//                        case "int":
//                                   o=Integer.parseInt(attrField.get(i).getText().trim());
//                        case "boolean":    
//                                    o=Boolean.parseBoolean(attrField.get(i).getText().trim());
//                        case "char": 
//                                    //o=Character.valueOf(fieldtype);
//                                    //o=Character.highSurrogate(Character.)
//                        case "double":
//                                    o=Double.parseDouble(attrField.get(i).getText().trim());
//                        case "float":
//                                    o=Float.parseFloat(attrField.get(i).getText().trim());
//                        case "short":
//                                    o=Short.parseShort(attrField.get(i).getText().trim());
//                        case "long":
//                                    o=Long.parseLong(attrField.get(i).getText().trim());
//                        case "byte":
//                                    o=Byte.parseByte(attrField.get(i).getText().trim());
//                    }
//                        b.add(o);
//                
//                Object[] bArr= b.toArray(new Object[b.size()]);
//                    System.out.println(bArr[0].toString());
//                    System.out.println(bArr.toString());
//               SuperType bobject = (SuperType) cons.newInstance(bArr);
//               pool.put(chooseClass.getValue().toString().trim() + "." + key.getText().trim(),bobject);
//                
//                    System.out.println(bobject.toString());
//                    System.out.println(pool.get(chooseClass.getValue().toString().trim() + "." + key.getText().trim()));
//                    System.out.println(pool.keySet().toString());
//               
//        }
        Class<?> c = int.class;
           
            // Load the class from the classloader by name....
        //Files.move(Paths.get(tempSource), Paths.get(sourceClass), StandardCopyOption.REPLACE_EXISTING);
        String className=chooseClass.getValue().toString();
        if(classMap.keySet().contains(className)==false)
        {System.out.println(className);
            c = classLoader.loadClass("UserClasses1." + className);
        
            classMap.put(className, c);
        }
        else
        c=classMap.get(className);
        // c = Class.forName("UserClasses." + chooseClass.getValue().toString().trim());
        //Field[] field = c.getDeclaredFields();
        List<Field> field = ClassGenerator.getFields(c);
        ArrayList<Class> params = new ArrayList<>();
        //String classKey=ClassGenerator.classKey("./attributes/" + chooseClass.getValue().toString().trim() + ".txt");
        String keyValue = "";//System.out.println(classKey);
        for (Field f : field) {
            params.add(f.getType());
        }

        Class[] paramsArr = params.toArray(new Class[params.size()]);
        Constructor<?> cons;
        cons = c.getConstructor(paramsArr);
        ArrayList<Object> b = new ArrayList<>();

        for (int i = 0; i < field.size(); i++) {//System.out.println(field.get(i).getName().toString().trim());
            String value = field.get(i).getName();
            //System.out.println(classKey + "  " + value);
//        if(classKey.equals(value)){//System.out.println("hello");
//                keyValue=objectFields.get(i).getKeyValue();
//            }
            Object o = objectFields.get(i).getObject(field.get(i));
            b.add(o);
        }
//        if(c.getDeclaredFields().length==0)
//            keyValue="singleton";
        //String key = chooseClass.getValue().toString().trim() + "." + keyValue;System.out.println(key);
        String keys = key.getText();
        Object[] bArr = b.toArray(new Object[b.size()]);
        SuperType bobject = (SuperType) cons.newInstance(bArr);

        if (pool.get(chooseClass.getValue().toString().trim()).values().contains(bobject) == false) {
            if (pool.get(chooseClass.getValue().toString().trim()).get(keys) == null) {
                //System.out.println(tmp);
                // System.out.println(bobject);
                //pool.put(key, bobject);
                pool.get(chooseClass.getValue().toString().trim()).put(keys, bobject);
            } else {
                System.out.println("before");
                System.out.println(pool.get(chooseClass.getValue().toString()).get(keys).toString());
            }
        }
        // System.out.println(pool.keySet().toString());
        //               pool.put(chooseClass.getValue().toString().trim() + "." + key.getText().trim(),bobject);
        //System.out.println(pool.keySet().toString());
        String path = "./media/" + chooseClass.getValue().toString();

        File files = new File(path);
        if (!files.exists()) {
            if (files.mkdir()) {
                System.out.println("Multiple directories are created!");
            } else {
                System.out.println("Failed to create multiple directories!");
            }
        }
        path += "/" + keys;
        files = new File(path);
        files.mkdir();
        files = new File(path + "/Audio");
        files.mkdir();
        files = new File(path + "/Video");
        files.mkdir();

        files = new File(path + "/Pictures");
        files.mkdir();
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setResizable(false);
        alert.getDialogPane().setPrefSize(200, 200);
        alert.setContentText("Instance of "+chooseClass.getValue().toString()+" is created");
        alert.showAndWait();
}catch(Exception ex){
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                 alert.setTitle("Error");
                 alert.setResizable(false);
                  alert.getDialogPane().setPrefSize(200, 200);
                 alert.setContentText("check your values");
                  alert.showAndWait();
                  return;
}
    }

    public void attributesFill(ActionEvent event) throws ClassNotFoundException, MalformedURLException {
        attributesPlace.getChildren().clear();

        attrField.clear();
        objectFields.clear();
//            List<String> fnameNew=Generator.getClassNames();
//                fnameNew=Generator.getClassNames();
//                 
//                 
        // attributesPlace.add(superClassMethod, 0, 0);
        String s = chooseClass.getValue().toString().trim();
        Class<?> c = int.class;
        try {
           URLClassLoader classLoader = new URLClassLoader(new URL[]{new File("./").toURI().toURL()});

            c = classLoader.loadClass("UserClasses1." + s);//or c=classMap.get("person");

            //c = Class.forName("UserClasses." + s);
            System.out.println(c.getSimpleName());
        } catch (ClassNotFoundException ex) {
            // Logger.getLogger(Projects.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error");
        }
        attributesPlace.add(key, 1, 0);
        attributesPlace.add(new Text("key"), 0, 0);
        //Field[] field = c.getDeclaredFields();
        System.out.println(c.getSimpleName());
        List<Field> field = ClassGenerator.getFields(c);
        int i;
        attributesPlace.add(new Text("AttributeType"), 0, 1);
        attributesPlace.add(new Text("AttributeName"), 1, 1);
        attributesPlace.add(new Text("AttributeValue"), 2, 1);
        List<String> classNames = Generator.getClassNames();
        for (i = 0; i < field.size(); i++) {
            attributesPlace.add(new Text(field.get(i).getName()), 1, i + 2);
            if (classNames.contains(field.get(i).getType().getSimpleName())) {
                ComboBox cc = new ComboBox();
                cc.getItems().addAll(Generator.getClassObject(field.get(i).getType().getSimpleName()));
                objectFields.add(new Fields(cc));
                attributesPlace.add(cc, 2, i + 2);
            } else {
                TextField ccc = new TextField();
                objectFields.add(new Fields(ccc));
                attributesPlace.add(ccc, 2, i + 2);
            }
            attributesPlace.add(new Text(field.get(i).getType().getSimpleName()), 0, i + 2);
        }
        // z.add(method,1,i+1);
//            superClassMethod.getItems().clear();
        //      superClassMethod.getItems().addAll(fnameNew);    
    }

//    public void classesAre(ActionEvent event) {
//
//        chooseClass.getItems().clear();
//        List<String> fnameNew = Generator.getClassNames();
//        fnameNew = Generator.getClassNames();
//
//        chooseClass.getItems().addAll(fnameNew);
//    }
}
