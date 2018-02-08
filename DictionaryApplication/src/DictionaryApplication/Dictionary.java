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


/**
 *
 * @author Aya
 */
public class Dictionary<T> implements Collection<T> {
     private Map<T,Pair<Set<T>,Set<T>>> dico;
     private Set<String> keys;
    public Map<T, Pair<Set<T>, Set<T>>> getDico() {
        return dico;
    }
     
    public Dictionary()
    {   //keys=new HashSet<String>();
        dico=new TreeMap<> ();
//        dico.put((T)"aya",new Pair());
//        dico.put((T)"alaa", new Pair());
//        dico.put((T)"Tala", new Pair());
//       
    }
     
    @Override
    public int size() 
    {
        return dico.size();
    }

    @Override
    public boolean isEmpty() 
    {
        return dico.isEmpty();
        }

    @Override
    public boolean contains(Object o) 
    {
        List<T> key = new ArrayList<>(dico.keySet());
        
           for(T k:key)
               if(k.equals(o)) return true;
           return false;
           
    }
   

    @Override
    public Object[] toArray() 
    {
        Object[] array=new Object[dico.size()];
        array=dico.entrySet().toArray();
      
        return array;
     }

    @Override
    public <T> T[] toArray(T[] a) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(T key) 
    {
       Pair s=new Pair<Set<T>,Set<T>>();
       dico.putIfAbsent(key, s);
       
       
       
        return (dico.putIfAbsent(key, s).equals(s));

    }

    @Override
    public boolean remove(Object key) 
    {
     
         Pair s=dico.get(key);
         dico.remove(key);
         return !(dico.remove(key)==s);
         //dico.get(o);
         //return dico.remove(key).equals(s);
       
       // return (dico.remove(o).equals(dico.get(o)));  
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
        for(Object o:dico.keySet())
            if(!c.contains(o)) 
                retain.add(o);
        
        return this.removeAll(retain);
     
    }

    @Override
    public void clear() 
    {
        dico.clear();
    }

    @Override
    public int hashCode()
    {
        int hash=1;
        
     for(T k:dico.keySet())
     {
        hash=hash*dico.get(k).hashCode();
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
        if (!this.dico.equals(other.dico)) {
            return false;
        }
        return true;
    }
    
  @Override  
  public Iterator<T> iterator() {
  return new DictionaryIterator<T>();
 }

 
 private class DictionaryIterator<T> implements Iterator<T> {
  int size = dico.size();
  
  int currentPointer = 0;

  public boolean hasNext() {
   return (currentPointer < size);
  }

  public T next() {
   if (!hasNext()) {
    throw new NoSuchElementException();
   }

   
   T val = (T) dico.get(currentPointer);
   currentPointer += 2;

   return val;
  }

 }


     
    
}