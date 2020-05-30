package mymap;
import java.util.ArrayList;

/**
 * Empty<K, V> represent an empty map whose Key is k and value is v
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
class Empty<K, V> extends MyMap<K, V> {

    /**
     * Method is to prouduce a boolean which shows whether the map is empty
     * 
     * @return boolean which represent whether the map is empty
     */
    public boolean isEmpty() {
        return true;
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
    public MyMap<K, V> include(K k, V v) {
        return new Include(this, k, v);
    }

    /**
     * method to produce the size of the map
     * 
     * @return a integer which shows the size of the map
     */
    public int size() {
        return 0;
    }

    /**
     * Method to check whether the map contains k
     * 
     * @param k1
     *            represent a key k1
     * @return a boolean which shows whether the map contains Key k
     */
    public boolean containsKey(K k1) {
        return false;
    }

    /**
     * Method to get the value whose key is k
     * 
     * @param k1
     *            represent a key k
     * 
     * @return V value whose Key is k in the Map
     */
    public V get(K k1) {
        throw new RuntimeException("There is no element in the empty Map");
    }

    /**
     * method to produce a map whose value being replaced by v on key k
     * 
     * @param k
     *            represent a key k
     * @param v
     *            represent a value v
     * @return MyMap<K, V> which put value v in map and its Key is k
     */
    public MyMap<K, V> set(K k, V v) {
        return this.include(k, v);
    }

    /**
     * Method to produce the hashCode of map
     * 
     * @return integer which show the hashCode for the map
     */
    public int hashCode() {
        return 0;
    }

    /**
     * Method is to produce the key
     * 
     * @return key which is the first Key in this map
     */
    public K getKey() {
        throw new RuntimeException("There is no element in the empty Map");
    }

    /**
     * Method is to produce the map
     * 
     * @return map which is the map does not include Value v, and Key k
     */
    public MyMap<K, V> getMap() {
        throw new RuntimeException("Can not get map from empty map");
    }

    /**
     * Method is to produce an empty Arraylist
     * 
     * @param arry
     *            Arrylist empty list
     * 
     * @return list which is an empty list
     */
    public ArrayList<K> keyArray(ArrayList<K> arry) {
        return arry;
    }

    /**
     * Method to determine whether two map have the same key
     * 
     * @param m
     *            represent the map to be compared
     * @return boolean that determine wheter they have the same key
     */
    public boolean sameKey(MyMap<K, V> m) {
        return true;
    }

    /**
     * Method to determine whether two map have the same value
     * 
     * @param m
     *            map
     * @return boolean
     */
    public boolean sameValue(MyMap<K, V> m) {
        return true;

    }


    /**
     * Method to implement accept method
     * @param visitor visitor
     * @return MyMap
     */
    public MyMap<K, V> accept(MyMapVisitor<K, V> visitor) {
        return this;
    }

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
    public <R> R acceptRBT(RBTVisitor<K, V, R> visitor) {
        throw new UnsupportedOperationException("not a red black tree");
    }

    /**
     * Method to get the left part of the tree
     * @return Map
     */
    public MyMap<K, V> getLeft() {
        throw new RuntimeException("no left to get");
    }

    /**
     * Method to get the right part of the map
     * @return map
     */
    public MyMap<K, V> getRight() {
        throw new RuntimeException("no right to get");
    }

    /**
     * Method to get the value of a map
     * @return V value
     */
    public V getValue() {
        throw new RuntimeException("There is no element in the empty Map");

    }


    /**
     * Method to get color 
     * @return string
     */
    public String getColor() {
        throw new RuntimeException("no color to get");
    }

}
