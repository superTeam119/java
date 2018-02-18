/*
 * Stringo change this license header, choose License Headers in Project Properties.
 * Stringo change this template file, choose Stringools | Stringemplates
 * and open the template in the editor.
 */
package DictionaryApplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import static java.util.Spliterators.iterator;
import java.util.TreeSet;
import static javafx.scene.input.KeyCode.E;
import static javafx.scene.input.KeyCode.T;
//import UserClasses.*;

/**
 *
 * @author Aya
 */
public class Dictionary<T> implements Collection<T> {
     private Map<T,Pair<Set<T>,Set<T>>> elements;
     private Set<String> keys;
    public Map<T, Pair<Set<T>, Set<T>>> getElements() {
        return elements;
    }
     
    public Dictionary()
    {   //keys=new HashSet<String>();
        elements=new TreeMap<T,Pair<Set<T>,Set<T>>> ();
//        elements.put((T)"aya",new Pair());
//        elements.put((T)"alaa", new Pair());
//        elements.put((T)"Tala", new Pair());
//       
    }
     
    @Override
    public int size() 
    {
        return elements.size();
    }

    @Override
    public boolean isEmpty() 
    {
        return elements.isEmpty();
        }

    @Override
    public boolean contains(Object o) 
    {
        List<T> key = new ArrayList<>(elements.keySet());
        
           for(T k:key)
               if(k.equals(o)) return true;
           return false;
           
    }
   

    @Override
    public Object[] toArray() 
    {
        Object[] array=new Object[elements.size()];
        array=elements.entrySet().toArray();
      
        return array;
     }

    @Override
    public <T> T[] toArray(T[] a) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(T key) 
    {
       Pair pair=new Pair<Set<T>,Set<T>>(new HashSet<T>(),new HashSet<T>());
        System.out.println(key.toString()+".......");
       try{
        elements.put(key, pair);
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
       
       
        //return (elements.putIfAbsent(key,pair).equals(pair));
       return true;
    }

    @Override
    public boolean remove(Object key) 
    {
     
         Pair s=elements.get(key);
         elements.remove(key);
         return !(elements.remove(key)==s);
         //elements.get(o);
         //return elements.remove(key).equals(s);
       
       // return (elements.remove(o).equals(elements.get(o)));  
    }

    @Override
    public boolean containsAll(Collection<?> c) 
    {
        for(Object o:c)
            if(!this.contains(o)) return false;
        return true;
        
    }

    @Override
    public boolean addAll(Collection<? extends T> c) 
    { 
        for(T t:c)
            if(!this.add(t)) return false;
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) 
    {
       for(Object o:c)
           if(!this.remove(o))
            return false;
       
      
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) 
    {
       List<Object> retain=new ArrayList<>();
        for(Object o:elements.keySet())
            if(!c.contains(o)) 
                retain.add(o);
        
        return this.removeAll(retain);
     
    }

    @Override
    public void clear() 
    {
        elements.clear();
    }

    @Override
    public int hashCode()
    {
        int hash=1;
        
     for(T k:elements.keySet())
     {
        hash=hash*elements.get(k).hashCode();
     }
     return hash;
                
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dictionary<?> other = (Dictionary<?>) obj;
        if (!this.elements.equals(other.elements)) {
            return false;
        }
        return true;
    }
    
  @Override  
  public Iterator<T> iterator() {
  return new DictionaryIterator<T>();
 }

 
 private class DictionaryIterator<T> implements Iterator<T> {
  int size = elements.size();
  
  int currentPointer = 0;

  public boolean hasNext() {
   return (currentPointer < size);
  }

  public T next() {
   if (!hasNext()) {
    throw new NoSuchElementException();
   }

   
   T val = (T) elements.get(currentPointer);
   currentPointer += 2;

   return val;
  }

 }


     
    
}