/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Import_Export;

import DictionaryApplication.Generator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author Abo Ali
 */
public class ImportFormController implements Initializable {

    @FXML
    private ComboBox classesNamesExport;
    @FXML
    private Button importButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        classesNamesExport.getItems().addAll(Generator.getClassNames());
    }    
    
}
