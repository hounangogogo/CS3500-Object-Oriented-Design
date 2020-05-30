package mymap;

import java.util.ArrayList;

/**
 * Include<K, V> represent an map whose Key is k and value is v
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
class Include<K, V> extends MyMap<K, V> {
    /** represent map m0 */
    MyMap<K, V> m0;
    /** represent the key k0 */
    K k0;
    /** represent the value v0 */
    V v0;

    /**
     * 
     * @param m0
     *            map which represent a map
     * @param k0
     *            key which represent a key
     * @param v0
     *            value which represent a value
     */
    Include(MyMap<K, V> m0, K k0, V v0) {
        this.m0 = m0;
        this.k0 = k0;
        this.v0 = v0;
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
     * Method is to produce a boolean which shows whether the map is empty
     * 
     * @return boolean which represent whether the map is empty
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * method to produce the size of the map
     * 
     * @return a integer which shows the size of the map
     */
    public int size() {
        if (m0.containsKey(k0)) {
            return this.m0.size();
        } 
        else {
            return 1 + m0.size();
        }

    }

    /**
     * Method to check whether the map contains k
     * 
     * @param k1
     *            represent a key k1
     * @return a boolean which shows whether the map contains Key k
     */
    public boolean containsKey(K k1) {
        if (k0.equals(k1)) {
            return true;
        } 
        else {
            return m0.containsKey(k1);
        }
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
        if (k1.equals(k0)) {
            return v0;
        } 
        else {
            return m0.get(k1);
        }
    }

    /**
     * method to produce a map whose value being replaced by v on key k
     * 
     * @param k1
     *            represent a key k1
     * @param v1
     *            represent a value v1
     * @return MyMap<K, V> which put value v1 in map and its Key is k1
     */
    public MyMap<K, V> set(K k1, V v1) {
        if (k1.equals(k0)) {
            return m0.include(k1, v1);
        }
        else {
            return m0.set(k1, v1).include(k0, v0);
        }
    }

    /**
     * Method is to produce the key
     * 
     * @return key which is the first Key in this map
     */
    public K getKey() {
        return this.k0;
    }

    /**
     * Method to produce the hashCode of map
     * 
     * @return integer which show the hashCode for the map
     */
    public int hashCode() {
        ArrayList<K> m = this.keyArray(new ArrayList<K>());
        int n = 0;
        for (K k : m) {
            n = n + k.hashCode() * 100 + 11;
        }
        return n;
    }

    /**
     * Method is to produce the map
     * 
     * @return map which is the map does not include Value v, and Key k
     */
    public MyMap<K, V> getMap() {
        return this.m0;
    }

    /**
     * Method is to produce an empty Arraylist
     * 
     * @param arry
     *            Arraylist empty list
     * 
     * @return list which is an empty list
     */
    public ArrayList<K> keyArray(ArrayList<K> arry) {
        if (this.m0.containsKey(k0)) {
            return m0.keyArray(arry);
        }
        else {
            arry.add(k0);
            return m0.keyArray(arry);
        }
    }

    /**
     * Method to determine whether two map have the same key
     * 
     * @param m
     *            represent the map to be compared
     * @return boolean that determine whether they have the same key
     */
    public boolean sameKey(MyMap<K, V> m) {
        if (m.isEmpty()) {
            return false;
        }
        if (m.containsKey(k0)) {
            return this.m0.sameKey(m);
        } 
        else {
            return false;
        }
    }

    /**
     * Method to determine whether they have the same value
     * 
     * @param m
     *            represent the map
     * @return boolean determine whether they have the same value
     */
    public boolean sameValue(MyMap<K, V> m) {
        if (m.isEmpty()) {
            return false;
        }
        if (m.get(this.k0).equals(this.get(this.k0))) {
            return this.m0.sameValue(m);
        }
        else {
            return false;
        }
    }

    /**
     * Mehtod to represent the accept method
     * 
     * @param visitor
     *            visitor
     * @return Mymap
     */
    public MyMap<K, V> accept(MyMapVisitor<K, V> visitor) {
        /** represent map 2 m2 */
        MyMap<K, V> m2 = MyMap.empty();
        for (K k : this) {
            V v = visitor.visit(k, this.get(k));
            m2 = m2.include(k, v);
        }
        return m2;
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
     * Method to get left tree
     * 
     * @return map
     */
    public MyMap<K, V> getLeft() {
        throw new RuntimeException("no left to get");
    }

    /**
     * Method to get right tree
     * 
     * @return map
     */
    public MyMap<K, V> getRight() {
        throw new RuntimeException("no right to get");
    }

    /**
     * Method to get the value of the map
     * 
     * @return v value
     */
    public V getValue() {
        return this.v0;
    }


    /**
     * Method to return color
     * @return String 
     */
    public String getColor() {
        throw new RuntimeException("no color to get");

    }
}
