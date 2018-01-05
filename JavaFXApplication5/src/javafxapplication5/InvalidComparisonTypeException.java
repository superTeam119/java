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
public class InvalidComparisonTypeException extends Exception{
    
     public InvalidComparisonTypeException() {
    }

    /**
     * Constructs an instance of <code>InvalidComparisonTypeException</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidComparisonTypeException(String msg) {
        super(msg);
    }
    
}
