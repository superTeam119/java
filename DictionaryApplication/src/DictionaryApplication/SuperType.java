/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DictionaryApplication;

import java.io.Serializable;

/**
 *
 * @author user
 */

    
    public  class SuperType implements Comparable<SuperType>,Serializable{
    public SuperType(){
    }
    
    @Override
    public String toString(){
        return getClass().getSimpleName();
    }
    
    @Override
    public boolean equals(Object otherObj){
        if(otherObj==null)
            return false;
        if(this==otherObj)
            return true;
        if(getClass()!=otherObj.getClass())
            return false;
        return true;
    }
    
    @Override
    public int hashCode(){
        return 0;
    }
    public int rank(){
        return 0;
    }
    @Override 
    public int compareTo(SuperType obj){
        //throw new InvalidComparisonTypeException();
        return 0;
    }
}
