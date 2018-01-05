/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

import java.io.IOException;
import UserClasses.superDictionary;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
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

    /**
     * Initializes the controller class.
     */
    List<TextField> attrField=new ArrayList<TextField>();
    static HashMap<String, superDictionary> pool=new HashMap<String,superDictionary>();
    @FXML
    private ComboBox chooseClass;
    @FXML
    private GridPane attributesPlace;
    @FXML
    public TextField key=new TextField();
    
    public ComboBox getc(){
        return chooseClass;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        List<String> fnameNew=Generator.getClassNames();
                fnameNew=Generator.getClassNames();
                 
                 chooseClass.getItems().addAll(fnameNew);
    }    
    public void Back(ActionEvent event) throws IOException{
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLNewClass.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        //app_stage.setTitle("Methods");
        app_stage.show();
    
    }
    public void createObject(ActionEvent event) throws NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
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
//               superDictionary bobject = (superDictionary) cons.newInstance(bArr);
//               pool.put(chooseClass.getValue().toString().trim() + "." + key.getText().trim(),bobject);
//                
//                    System.out.println(bobject.toString());
//                    System.out.println(pool.get(chooseClass.getValue().toString().trim() + "." + key.getText().trim()));
//                    System.out.println(pool.keySet().toString());
//               
//        }
        Class<?> c=int.class;
             
                    c = Class.forName("UserClasses." + chooseClass.getValue().toString().trim());
        Field[] field = c.getDeclaredFields();
        ArrayList<Class> params = new ArrayList<>();
        
        for(Field f: field)
        {
            params.add(f.getType());    
        }
        
        Class[] paramsArr= params.toArray(new Class[params.size()]);
        Constructor<?> cons;
                    cons = c. getConstructor(paramsArr);
                    ArrayList<Object> b= new ArrayList<>();
                
                for (int i = 0; i < field.length; i++) {Object o=attrField.get(i).getText().trim();
                    String fieldtype=field[i].getType().getSimpleName();
                   // System.out.println(fieldtype);
                    if(fieldtype.equals("int"))
                                   o=Integer.parseInt(attrField.get(i).getText().trim());
                    if(fieldtype.equals("boolean"))  
                                    o=Boolean.parseBoolean(attrField.get(i).getText().trim());
                       // case "char": 
                                    //o=Character.valueOf(fieldtype);
                                    //o=Character.highSurrogate(Character.)
                        if(fieldtype.equals("double"))
                                    o=Double.parseDouble(attrField.get(i).getText().trim());
                        if(fieldtype.equals("float"))
                                    o=Float.parseFloat(attrField.get(i).getText().trim());
                        if(fieldtype.equals("short"))
                                    o=Short.parseShort(attrField.get(i).getText().trim());
                        if(fieldtype.equals("long"))
                                    o=Long.parseLong(attrField.get(i).getText().trim());
                        if(fieldtype.equals("byte"))
                                    o=Byte.parseByte(attrField.get(i).getText().trim());
                            
                        b.add(o);
                }
                Object[] bArr= b.toArray(new Object[b.size()]);
                superDictionary bobject = (superDictionary) cons.newInstance(bArr);
                String tmp=chooseClass.getValue().toString().trim() + "." + key.getText().trim();
                    //System.out.println(tmp);
                pool.put(tmp,bobject);
               // System.out.println(pool.keySet().toString());
                //               pool.put(chooseClass.getValue().toString().trim() + "." + key.getText().trim(),bobject);
                //System.out.println(pool.keySet().toString());
    }
    public void attributesFill(ActionEvent event) throws ClassNotFoundException{
      attributesPlace.getChildren().clear();
            attrField.clear();
//            List<String> fnameNew=Generator.getClassNames();
//                fnameNew=Generator.getClassNames();
//                 
//                 
                // attributesPlace.add(superClassMethod, 0, 0);
                String s=chooseClass.getValue().toString().trim();
                Class<?> c=int.class;
                try {
                    c = Class.forName("UserClasses." + s);
                } catch (ClassNotFoundException ex) {
                   // Logger.getLogger(Projects.class.getName()).log(Level.SEVERE, null, ex);
                }   
                    attributesPlace.add(key,1,0);
                    attributesPlace.add(new Text("key"),0,0);
                    Field[] field = c.getDeclaredFields();
                    int i;
                    attributesPlace.add(new Text("AttributeType"),0,1);
                    attributesPlace.add(new Text("AttributeName"),1,1);
                    attributesPlace.add(new Text("AttributeValue"),2,1);
                    for (i = 0; i < field.length; i++) {
                        attributesPlace.add(new Text(field[i].getName()), 1, i+2);
                        TextField f=new TextField();
                        attrField.add(f);
                        attributesPlace.add(f,2,i+2);
                        attributesPlace.add(new Text(field[i].getType().getSimpleName()), 0, i+2);
                    }
                   // z.add(method,1,i+1);
//            superClassMethod.getItems().clear();
           //      superClassMethod.getItems().addAll(fnameNew);    
            }
   public void classesAre(ActionEvent event){
       
            chooseClass.getItems().clear();
            List<String> fnameNew=Generator.getClassNames();
                fnameNew=Generator.getClassNames();
                 
                 chooseClass.getItems().addAll(fnameNew);
   }
}
