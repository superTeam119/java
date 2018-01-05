/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

/**
 *
 * @author user
 */
public class SuperClass {
    
     private String className;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public static void main(String args[]) {
        SuperClass testClass = new SuperClass();
        testClass.setClassName("Person");
        System.out.println(Generator.GetText(testClass));
    }
}
