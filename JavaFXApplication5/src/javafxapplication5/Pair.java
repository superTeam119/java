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
public class Pair<T,V> {
   
    private T first;
    private V second;
    public Pair(T s1,V s2){
    first =s1;
    second=s2;
    }
    public Pair(){}
    public T getFirst(){
        return first;
    }
    public V getSecond(){
        return second;
    }
}
