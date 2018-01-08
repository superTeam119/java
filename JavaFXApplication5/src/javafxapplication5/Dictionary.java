/*
 * Stringo change this license header, choose License Headers in Project Properties.
 * Stringo change this template file, choose Stringools | Stringemplates
 * and open the template in the editor.
 */
package javafxapplication5;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Issa
 */
public class Dictionary<T> implements Collection<String>{
    public Map<String,Pair<Set<T>,Set<T>>> dico;

    @Override
    public int size() {
        return dico.size();
    }

    @Override
    public boolean isEmpty() {
        return dico.isEmpty();
    }

    @Override
    public Iterator<String> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //Stringo change body of generated methods, choose Stringools | Stringemplates.
    }

    @Override
    public Object[] toArray() {
        Object[] o=new Object[dico.keySet().size()];
    Iterator<?> iter=iterator();
       int i=0;
       while(iter.hasNext()){
           o[i]=iter.next();
           i++;
       }
       return o;
    }

    @Override
    public <String> String[] toArray(String[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //Stringo change body of generated methods, choose Stringools | Stringemplates.
    }

    @Override
    public boolean add(String e) {Pair p=new Pair<Set<String>,Set<String>>();
        return dico.put(e,p)==null;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //Stringo change body of generated methods, choose Stringools | Stringemplates.
    }

    @Override
    public boolean containsAll(Collection<?> c) {
    Iterator<?> iterator=c.iterator();
    //for(Object o:c){
        
    
        while(iterator.hasNext()){
            Object o=iterator.next();
            if(!contains(o))
                return false;
        }
        
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        
        
        
        
        
    Iterator<?> iterator=c.iterator();
        while(iterator.hasNext()){
            String o=(String) iterator.next();
            if(!add(o))
                return false;
        }
        return true;}

    @Override
    public boolean removeAll(Collection<?> c) {
        Iterator<?> iterator=c.iterator();
        while(iterator.hasNext()){
            Object o=iterator.next();
            if(!remove(o))
                return false;
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //Stringo change body of generated methods, choose Stringools | Stringemplates.
    }

    @Override
    public void clear() {
    dico = new HashMap<String,Pair<Set<T>,Set<T>>>();
    }

    @Override
    public boolean contains(Object o) {
    Set<Map.Entry<String,Pair<Set<T>,Set<T>>>> allObjects=dico.entrySet();
    return true;
    
    } 
}
