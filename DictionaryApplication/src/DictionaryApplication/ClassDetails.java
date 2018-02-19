/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DictionaryApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.List;
;

/**
 *
 * @author user
 */
public class ClassDetails {
    
     private String className;
     private List<Attribute> attributes;
     public boolean subClass;
     public String superClass;
     private String key;
     public ClassDetails() {attributes=new ArrayList<Attribute>();
    }
    public void addAttribute(String name,String type,boolean checked){
     attributes.add(new Attribute(name,type,checked));
    }
    public String getClassName() {
        return className;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public boolean isSubClass() {
        return subClass;
    }

    public String getSuperClass() {
        return superClass;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public void setSubClass(boolean subClass) {
        this.subClass = subClass;
    }

    public void setSuperClass(String superClass) {
        this.superClass = superClass;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    
}