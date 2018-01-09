/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

/**
 *
 * @author Issa
 */
public class Attribute {
    private String name;
    private String type;
    private boolean checked;

    public Attribute(String name, String type, boolean checked) {
        this.name = name;
        this.type = type;
        this.checked = checked;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Boolean isChecked() {
        return checked;
    }
    
}
