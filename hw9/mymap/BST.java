package mymap;
import java.util.ArrayList;
import java.util.Comparator;


/**
 * BST represent BST whose key is k
 * whose value is v
 * @author Haonan Zhao
 * 
 * @param <K> k Key it is a random data type
 * @param <V> v Value it is a random data type
 * @version 2/11/2014
 */
public abstract class BST<K, V> extends MyMap<K, V> {

    /**
     * represent color
     */
    public String color;
    /**
     * represent the color red
     */
    public String red = "red";
    /**
     * represent the color black
     */
    public String black = "black";
    
    
    /**
     * @param k which represent key
     * @param v which represent value
     * @return a BST with k and v in it
     */
    public abstract BST<K, V> includehelper(K k, V v);

    /**
     * Method to return a boolean that show whether this 
     * tree is empty
     * @return boolean to show whether this 
     * tree is empty
     */
    public abstract boolean isEmpty();

    
    /**
     * Method to return a integer that represent the size
     * @return integer show the size of the tree
     */
    public abstract int size();

    /**
     * Method to show whether this map contains key k
     * @param k represent the key that to be check
     * @return boolean that show whether this map contains key k
     */
    public abstract boolean containsKey(K k);

    
    /**
     * Method to set key k, and value v in it
     * @param k represent the key to be set
     * @param v represent the value to be set 
     * @return tree with Key k and value v in it 
     */
    public abstract BST<K, V> set(K k, V v);

    /**
     * Method to get value whose key is k
     * @param k represent the key 
     * @return V represent the value to get
     */
    public abstract V get(K k);
    
    /**
     * Method to get the key of the tree
     * @return k represent the key
     */
    public abstract K getKey();
    
    
   

   
    /**
     * Method is to produce an empty Arraylist
     * 
     * @param a
     *            Arrylist  empty list
     * 
     * @return list which is an empty list
     */
    public abstract ArrayList<K> keyArray(ArrayList<K> a);

    
    
    /**
     * Method is to produce Arraylist with element in it
     * 
     * @return Iterator<K> which can iterate throw the map
     */
    public MyIterator<K> iterator() {
        return new MyIterator<K>(this.keyArray(new ArrayList<K>()));
    }
    
    
    

    /**
     * Method to get the left side of tree
     * @return BST
     */
    public abstract BST<K, V> getLeft();
    
    /**
     * Method to get the right side of the tree
     * @return BST
     */
    public abstract BST<K, V> getRight();

    /**
     * method to test whether the node is red
     * @return boolean
     */
    public abstract boolean isRed();
    
    
    /**
     * Method to get the value of a node
     * @return V value
     */
    public abstract V getValue();
    
    /**
     * Method to get the comparator
     * @return c comparator
     */
    public abstract Comparator<? super K> getComp();
    
    
    /**
     * Method to make the node color become black
     * @return BST with the node color become black
     */
    public BST<K, V> makeBlack() {
        return new Node<K, V>(this.getKey(), 
                this.getValue(), this.getLeft(), 
                this.getRight(), this.getComp(), black);
    }
    
   
    /**
     * Method to return the topmost node with 
     * color replaced by black
     * @param k key represent the key
     * @param v represent the value
     * @return BST<K, V> return the topmost node with 
     * color replaced by black
     * 
     */
    public BST<K, V> include(K k, V v) {
        return includehelper(k, v).makeBlack();
    }
    
    
    /**
     * Method to implement the accept method
     * @param visitor visitor
     * @return BST
     */
    public abstract BST<K, V> accept(MyMapVisitor<K, V> visitor);
    
    
}