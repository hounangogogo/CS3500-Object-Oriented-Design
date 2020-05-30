package mymap;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * EmptyTree<K, V> represent an EmptyTree
 * 
 * @author Haonan Zhao
 * 
 * @param <K>
 *            k Key it is a random data type
 * @param <V>
 *            v Value it is a random data type
 * 
 * @version 2/11/2014
 */
public class EmptyTree<K, V> extends BST<K, V> {

    /**
     * 
     */
    Comparator<? super K> c;

    /**
     * Comparator
     * 
     * @param c
     *            which represent a comparator
     */
    public EmptyTree(Comparator<? super K> c) {
        this.c = c;
        this.color = black;
    }

    /**
     * Method to represent a tree with has include k, v in it
     * 
     * @param k
     *            represent a key to be include
     * @param v
     *            represent a value to be include
     * @return a tree with has include k, v in it
     */
    public BST<K, V> includehelper(K k, V v) {
        return new Node(k, v, this, this, this.c, red);
    }

    /**
     * Method to return a boolean that show whether this tree is empty
     * 
     * @return boolean to show whether this tree is empty
     */
    public boolean isEmpty() {
        return true;
    }

    /**
     * Method to return a integer that represent the size
     * 
     * @return integer show the size of the tree
     */
    public int size() {
        return 0;
    }

    /**
     * Method to set key k, and value v in it
     * 
     * @param k1
     *            represent the key to be set
     * @param v1
     *            represent the value to be set
     * @return tree with Key k and value v in it
     */
    public BST<K, V> set(K k1, V v1) {
        return this.includehelper(k1, v1);
    }

    /**
     * Method to show whether this map contains key k
     * 
     * @param k
     *            represent the key that to be check
     * @return boolean that show whether this map contains key k
     */
    public boolean containsKey(K k) {
        return false;
    }

    /**
     * Method to get value whose key is k
     * 
     * @param k
     *            represent the key
     * @return V represent the value to get
     */
    public V get(K k) {
        throw new RuntimeException("no key to get");
    }

    /**
     * Method is to produce an empty Arraylist
     * 
     * @param a
     *            Arrylist empty list
     * 
     * @return list which is an empty list
     */
    public ArrayList<K> keyArray(ArrayList<K> a) {
        return a;

    }

    /**
     * Method to represent the hashCode for the tree
     * 
     * @return integer which represent the hashCode for that
     */
    public int hashCode() {
        return this.size();
    }

    /**
     * Method to get the key of the tree
     * 
     * @return k represent the key
     */
    public K getKey() {
        throw new RuntimeException("Can not get key from empty tree");
    }

    /**
     * Method to get the map without top most element
     * 
     * @return map without top most element
     */
    public MyMap<K, V> getMap() {
        throw new RuntimeException("Can not get map from empty tree");
    }

    /**
     * Method to determine whether they have the same key
     * 
     * @param m
     *            represent the map
     * @return boolean determine whether they have the same key
     */
    public boolean sameKey(MyMap<K, V> m) {
        return true;

    }

    /**
     * Method to determine whether they have the same value
     * 
     * @param m
     *            represent the map
     * @return boolean determine whether they have the same value
     */
    public boolean sameValue(MyMap<K, V> m) {
        return true;
    }


    /**
     * Method to return right side of the tree
     * @return bst represent right side of the tree
     */
    public BST<K, V> getRight() {
        return this;
    }


    /**
     * Method to return whether the node is red
     * @return boolean represent whether the node is red 
     */
    public boolean isRed() {
        return false;
    }


    /**
     * Method to return the value
     * @return V represent the value 
     */
    public V getValue() {
        throw new RuntimeException("Can not get map from empty tree");
    }

    /**
     * Method to return left side of the tree
     * @return bst represent left side of the tree
     */
    public BST<K, V> getLeft() {
        return this;
    }
    
    /**
     * Method to return comparator of the tree
     * @return bst represent comparator of the tree
     */
    public Comparator<? super K> getComp() {
        return c;
    }


    /**
     * Method to represent the accept method
     * @param visitor visitor
     * @return BST
     */
    public BST<K, V> accept(MyMapVisitor<K, V> visitor) {
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
        return visitor.visitEmpty(c, black);
    }


    /**
     * Method to get color
     * @return String
     */
    public String getColor() {
        return black;
    }

}
