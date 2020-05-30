package mymap;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * MyMap represent a map whose Key is k, and value is V,
 *  and implements iterable<K>
 * 
 * @author Haonan Zhao
 * 
 * @param <K>
 *            Key it is a random data type
 * @param <V>
 *            Value it is a random data type
 * 
 * @version 1/29/2014
 */
public abstract class MyMap<K, V> implements Iterable<K> {

    /**
     * Method is to produce an empty map
     * 
     * @param <K>
     *            key which is a random data type
     * @param <V>
     *            value which is a random data type
     * 
     * @return My<K, V> which is a empty map
     */
    public static <K, V> MyMap<K, V> empty() {
        return new Empty<K, V>();
    }

    
    
    
    /**
     * Method is to produce an empty map with a comparator
     * 
     * @param <K>
     *            key which is a random data type
     * @param <V>
     *            value which is a random data type
     * @param comp
     *            comparator which is an operation
     *            
     * @return My<K, V> which is a empty map
     */
    public static <K, V> MyMap<K, V> empty(
            java.util.Comparator<? super K> comp) {
        return new EmptyTree<K, V>(comp);
    }



    
    


    /**
     * Method is to produce an non-map
     * 
     * @param k
     *            represent a key k
     * @param v
     *            represent a value v
     * 
     * @return MyMap<K, V> which have Key k, and its Value v
     */
    public abstract MyMap<K, V> include(K k, V v);

    
    
    /**
     * Method is to produce an empty Arraylist
     * 
     * @param arry
     *            Arrylist  empty list
     * 
     * @return list which is an empty list
     */
    public abstract ArrayList<K> keyArray(ArrayList<K> arry);

    
    /**
     * Method is to produce Arraylist with element in it
     * 
     * @return Iterator<K> which can iterate throw the map
     */
    public Iterator<K> iterator() {
        return new MyIterator<K>(this.keyArray(new ArrayList<K>()));
    }

    /**
     * Method is to produce a new list which the element are sorted
     * 
     * @param c
     *            comparator which is an operation
     *
     * @return Iterator<K> that can iterate through the map,
     *  sorted by c
     */
    public Iterator<K> iterator(java.util.Comparator<? super K> c) {
        return new MyIterator<K>(this.keyArray(new ArrayList<K>()), c);
    }

    /**
     * Method is to check whether the map is empty
     * 
     * @return a boolean which to show whether the map is empty
     */
    public abstract boolean isEmpty();

   
    /**
     * method to produce the size of the map
     * 
     * @return a integer which shows the size of the map
     */
    public abstract int size();

   
    
    /**
     * Method to check whether the map contains k
     * 
     * @param k
     *            represent a key k
     * @return a boolean which shows whether the map contains 
     * Key k
     */
    public abstract boolean containsKey(K k);

    
    
    /**
     * Method to get the value whose key is k
     * 
     * @param k
     *            represent a key k
     * 
     * @return V value whose Key is k in the Map 
     */
    public abstract V get(K k);

    /**
     * method to produce a map whose value being replaced by v on key k
     * 
     * @param k
     *            represent a key k
     * @param v
     *            represent a value v
     * @return MyMap<K, V> which put value v in map and its Key is k
     */
    public abstract MyMap<K, V> set(K k, V v);

    
    /**
     * Method to produce a String
     * 
     * @return String represent the data for this map
     */
    public String toString() {
        return "{...(" + this.size() + " key(s) mapped to value(s))...}";
    }

    

    /**
     * method to check whether two map are the same
     * 
     * @param obj
     *            represent an object
     * @return a boolean which shows whether the object is the same
     * as the given map
     */
    
    public boolean equals(Object obj) {
        if (!(obj instanceof MyMap)) {
            return false;
        }

        @SuppressWarnings("unchecked")
        MyMap<K, V> map = (MyMap<K, V>) obj;
        if (map.isEmpty()) {
            return this.isEmpty();
        }
        if (this.isEmpty()) {
            return map.isEmpty();
        }
        if (this.getMap().containsKey(this.getKey())) {
            return this.getMap().set(this.getKey(), this.get(this.getKey()))
                    .equals(map);
        }
        if (map.getMap().containsKey(map.getKey())) {
            return map.getMap().set(map.getKey(), map.get(map.getKey()))
                    .equals(this);
        }
        if (this.size() != map.size()) {
            return false;
        }
         
        else {
            return this.sameKey(map) && this.sameValue(map);
        }

    }

    
    /**
     * Method to produce the hashCode of map
     * 
     * @return integer which show the hashCode for the map
     */
    public abstract int hashCode();

    
    /**
     * Method is to produce the key
     * 
     * @return key which is the first Key in this map
     */
    public abstract K getKey();
    
    
    /**
     * Method to represent the return value method
     * @return V value
     */
    public abstract V getValue();

    
    /**
     * Method is to produce the map
     * 
     * @return map which is the map does not include Value v, and Key k
     */
    public abstract MyMap<K, V> getMap();
    
    /**
     * Method to determine whether two map have the same key
     * @param m represent the map to be compared
     * @return boolean that determine wheter they have the same key
     */
    public abstract boolean sameKey(MyMap<K, V> m);
    
    /**
     * Method to determine whether two map have the same value
     * @param m map
     * @return boolean
     */
    public abstract boolean sameValue(MyMap<K, V> m);

    
    /**
     * @param visitor visitor
     * @return map
     * Mehtod to implements accept
     */
    public abstract MyMap<K, V> accept(MyMapVisitor<K, V> visitor);
    
    
    
    
    /**
     * Method that accepts a visitor that produces a value of 
     * the type R
     * 
     * @param visitor
     *            the given visitor
     * @param <R>
     *            the type of elements returned by method
     * @return the result of calling the appropriate visit 
     *            method from the given the visitor
     * 
     * @throws UnsupportedOperationException
     *             if this is not implemented as a Red-Black
     *             Tree
     */
    public abstract <R> R acceptRBT(RBTVisitor<K, V, R> visitor);
 

    /**
     * Method to get the left tree
     * @return Map
     */
    public abstract MyMap<K, V> getLeft();
    
    /**
     * Method to get the right 
     * @return map
     */
    public abstract MyMap<K, V> getRight();

    

    /**
     * Method to get color
     * @return String color
     */
    public abstract String getColor();
}


