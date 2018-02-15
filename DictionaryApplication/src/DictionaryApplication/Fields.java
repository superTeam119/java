/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DictionaryApplication;

import static FxmlFiles.DictionaryStart.pool;
import java.lang.reflect.Field;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 *
 * @author Abo Ali
 */
public class Fields {

    private ComboBox oComboBox;
    private TextField oTextField;

    public Fields(ComboBox oComboBox) {
        this.oComboBox = oComboBox;
    }

    public Fields(TextField oTextField) {
        this.oTextField = oTextField;
    }

    public ComboBox getoComboBox() {
        return oComboBox;
    }

    public TextField getoTextField() {
        return oTextField;
    }
    public String getKeyValue(){//System.out.println("sads");
        if(oTextField==null)
            return oComboBox.getValue().toString().trim();
        //System.out.println("textt");
        return oTextField.getText().toString().trim();
    }
    public Object getObject(Field field) {
        Object o;
        if (oTextField == null) {
            String key = field.getType().getSimpleName() + "." + oComboBox.getValue().toString().trim();
            o=pool.get(key);
        }else
        {   o=oTextField.getText().trim();
            String fieldtype = field.getType().getSimpleName();
            // System.out.println(fieldtype);
            if (fieldtype.equals("int")) {
                o = Integer.parseInt(oTextField.getText().trim());
            }
            if (fieldtype.equals("boolean")) {
                o = Boolean.parseBoolean(oTextField.getText().trim());
            }
            // case "char": 
            //o=Character.valueOf(fieldtype);
            //o=Character.highSurrogate(Character.)
            if (fieldtype.equals("double")) {
                o = Double.parseDouble(oTextField.getText().trim());
            }
            if (fieldtype.equals("float")) {
                o = Float.parseFloat(oTextField.getText().trim());
            }
            if (fieldtype.equals("short")) {
                o = Short.parseShort(oTextField.getText().trim());
            }
            if (fieldtype.equals("long")) {
                o = Long.parseLong(oTextField.getText().trim());
            }
            if (fieldtype.equals("byte")) {
                o = Byte.parseByte(oTextField.getText().trim());
            }

        }
        return o;
    }
}
