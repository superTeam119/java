/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Import_Export;

import DictionaryApplication.Dictionary;
import DictionaryApplication.Generator;
import DictionaryApplication.SuperType;
import static FxmlFiles.Start.dictionaries;
import static FxmlFiles.Start.pool;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Abo Ali
 */
public class Import_Export_FormController implements Initializable {

    @FXML
    private ComboBox exportClassesNames;
    @FXML
    private TextField filterField;
    List<String> filteredArray;
    @FXML
    private ListView filterListView;

    /**
     * Initializes the controller class.
     */
    public void Back(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/FxmlFiles/FXMLDictionary.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        //app_stage.setTitle("Methods");
        app_stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        filteredArray=new ArrayList<String>();
//        filteredArray.add("song.mp3");
//        filteredArray.add("fatwa.mp3");
//        filteredArray.add("nadbeyet.mp3");
        // exportClassesNames.getItems().addAll(Generator.getClassNames());
        for (String s : dictionaries.keySet()) {
            if (pool.get(s).size() != 0) {
                exportClassesNames.getItems().add(s);
            }
        }
//         filterField.textProperty().addListener((observable, oldValue, newValue) -> {
//             filterListView.getItems().clear();
//                 Compare first name and last name field in your object with filter.
//                String lowerCaseFilter = newValue.toLowerCase();
//                for (int i = 0; i <filteredArray.size() ; i++) {
//                 if(filteredArray.get(i).contains(lowerCaseFilter)){
//                    filterListView.getItems().add(filteredArray.get(i));
//                 }
//             }
//
//        });
    }

    public void exportDictionary(ActionEvent event) throws FileNotFoundException, IOException {

        try {
            FileChooser fileChooser = new FileChooser();

            File file = fileChooser.showSaveDialog((Stage) ((Node) event.getSource()).getScene().getWindow());
            System.out.println(file.toString());
            File exportFile = new File(file.getAbsolutePath().toString());
            file.mkdir();
            String className = exportClassesNames.getValue().toString();
            //pool.get(className);
            //dictionaries

            File f = new File(file.getAbsolutePath().toString() + "\\pool.xml");
            FileOutputStream ff = new FileOutputStream(f);
            ObjectOutputStream fff = new ObjectOutputStream(ff);
            fff.writeObject(pool.get(className));
            fff.close();

            if (dictionaries.containsKey(className) == true) {
                File s = new File(file.getAbsolutePath().toString() + "\\dictionaries.xml");
                FileOutputStream ss = new FileOutputStream(s);
                ObjectOutputStream sss = new ObjectOutputStream(ss);
                sss.writeObject(dictionaries.get(className));
                sss.close();
            }
        } catch (Exception e) {
        }

    }

    public void importDictionary(ActionEvent event) throws FileNotFoundException, IOException, ClassNotFoundException {
        try {
            FileChooser fileChooser = new FileChooser();
            File f;
            File s;
            List<File> file = fileChooser.showOpenMultipleDialog((Stage) ((Node) event.getSource()).getScene().getWindow());
            Dictionary<SuperType> classDictionary = null;
            if (file.size() > 1) {
                s = new File(file.get(0).getAbsolutePath());
                FileInputStream ss = new FileInputStream(s);
                ObjectInputStream sss = new ObjectInputStream(ss);
                classDictionary = (Dictionary<SuperType>) sss.readObject();
                sss.close();
            }
            //[C:\Users\Abo Ali\Desktop\lanshuf\dictionaries.xml, C:\Users\Abo Ali\Desktop\lanshuf\pool.xml]
            f = new File(file.get(1).getAbsolutePath());
            FileInputStream ff = new FileInputStream(f);
            ObjectInputStream fff = new ObjectInputStream(ff);
            HashMap<String, SuperType> classPool = (HashMap<String, SuperType>) fff.readObject();
            fff.close();//catch(Exception ex){System.out.println(ex.getMessage());   
            String className = classPool.values().toArray()[0].getClass().getSimpleName();
            pool.put(className, classPool);
            if (file.size() > 1) {
                dictionaries.put(className, classDictionary);
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setResizable(false);
            alert.getDialogPane().setPrefSize(250, 320);
            alert.setContentText("please choose a compatable file");
            alert.showAndWait();

        }
    }
}
