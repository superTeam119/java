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
public class Pair<T,V> implements Serializable{
   
    private T friend;
    private V enemy;
    public Pair(T friend, V enemy) {
        this.friend = friend;
        this.enemy = enemy;
    }
public Pair(){}
    public T getFriend() {
        return friend;
    }

    public V getEnemy() {
        return enemy;
    }
    
}
