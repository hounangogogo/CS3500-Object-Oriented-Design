package mymap;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Node to represent the the BST with k0 and v0 in it
 * 
 * @author Haonan Zhao
 * 
 * @param <K>
 *            k Key it is a random data type
 * @param <V>
 *            v Value it is a random data type
 * @version 2/11/2014
 */
public class Node<K, V> extends BST<K, V> {
    /** represent key of first node **/
    K k0;
    /** represent value of first node **/
    V v0;
    /** represent the left tree of this tree **/
    BST<K, V> left;
    /** represent the right tree of this tree **/
    BST<K, V> right;
    /** represent the comparator of tree **/
    Comparator<? super K> comp;
    /** represent color of tree **/
    String color;
    /** represent the size of tree **/
    int size;

    /**
     * Method represent the Node of BST
     * 
     * @param k0
     *            represent value of first node
     * @param v0
     *            represent value of first node
     * @param left
     *            represent the left tree of this tree
     * @param right
     *            represent the right tree of this tree
     * @param comp
     *            represent the comparator of tree
     * @param color
     *            represent the color
     */
    Node(K k0, V v0, BST<K, V> left, BST<K, V> right,
            Comparator<? super K> comp, String color) {
        this.k0 = k0;
        this.v0 = v0;
        this.left = left;
        this.right = right;
        this.comp = comp;
        this.color = color;
        this.size = 1 + left.size() + right.size();
    }

    /**
     * Method to return a boolean that show whether this tree is empty
     * 
     * @return boolean to show whether this tree is empty
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * Method to return a integer that represent the size
     * 
     * @return integer show the size of the tree
     */
    public int size() {
        return this.size;
    }

    /**
     * Method to set key k, and value v in it
     * 
     * @param k1
     *            represent the key to be set
     * @param v1
     *            represent the value to be set
     * @return tree with Key k1 and value v1 in it
     */
    public BST<K, V> set(K k1, V v1) {
        if (this.k0.equals(k1)) {
            return new Node<K, V>(k0, v1, this.left, this.right, comp, color);
        }
        if (this.comp.compare(k0, k1) < 0) {
            return new Node<K, V>(k0, v0, this.left, this.right.set(k1, v1),
                    comp, color);
        } 
        else {
            return new Node<K, V>(k0, v0, this.left.set(k1, v1), this.right,
                    comp, color);
        }
    }

    /**
     * Method to show whether this map contains key k
     * 
     * @param k
     *            represent the key that to be check
     * @return boolean that show whether this map contains key k
     */
    public boolean containsKey(K k) {
        if (comp.compare(this.k0, k) == 0) {
            return true;
        }
        else if (comp.compare(this.k0, k) > 0) {
            return this.left.containsKey(k);
        }
        else {
            return this.right.containsKey(k);
        }
    }

    /**
     * Method to get value whose key is k
     * 
     * @param k
     *            represent the key
     * @return V represent the value to get
     */
    public V get(K k) {
        if (comp.compare(this.k0, k) == 0) {
            return this.v0;
        } 
        else if (comp.compare(this.k0, k) > 0) {
            return this.left.get(k);
        } 
        else {
            return this.right.get(k);
        }
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
        a.add(this.k0);
        a.addAll(this.left.keyArray(new ArrayList<K>()));
        a.addAll(this.right.keyArray(new ArrayList<K>()));
        return a;
    }

    /**
     * Method to represent the hashCode for the tree
     * 
     * @return integer which represent the hashCode for that
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
     * Method to represent a tree with has include k, v in it
     * 
     * @param k
     *            represent a key to be include
     * @param v
     *            represent a value to be include
     * @return a tree with has include k, v in it
     */
    public BST<K, V> includehelper(K k, V v) {
        BST<K, V> bt;
        if (this.k0.equals(k)) {
            bt = this.set(k0, v);
            return balanceMethod(bt);
        }
        if (this.comp.compare(this.k0, k) > 0) {
            bt = new Node<K, V>(this.k0, this.v0, this.left.includehelper(k, v),
                    this.right, this.comp, color);
            return balanceMethod(bt);

        } 
        else {
            bt = new Node<K, V>(this.k0, this.v0, this.left,
                    this.right.includehelper(k, v), this.comp, color);
            return balanceMethod(bt);

        }
    }

    /**
     * Method to get the key of the tree
     * 
     * @return k represent the key
     */
    public K getKey() {
        return this.k0;
    }

    /**
     * Method to get the map without top most element (but it is useless there)
     * 
     * @return map without top most element
     */
    public MyMap<K, V> getMap() {
        return this.left;
    }

    /**
     * Method to determine whether they have the same key
     * 
     * @param m
     *            represent the map
     * @return boolean determine whether they have the same key
     */
    public boolean sameKey(MyMap<K, V> m) {
        if (m.isEmpty()) {
            return false;
        }
        if (m.containsKey(k0)) {
            return this.left.sameKey(m) && this.right.sameKey(m);
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
        if (m.get(k0).equals(v0)) {
            return this.left.sameValue(m) && this.right.sameValue(m);
        } 
        else {
            return false;
        }

    }

    /**
     * @return BST
     */
    public BST<K, V> getLeft() {
        return this.left;
    }

    /**
     * Method to return the
     * @return BST
     */
    public BST<K, V> getRight() {
        return this.right;
    }

    /**
     * @return boolean
     */
    public boolean isRed() {
        return this.color.equals("red");
    }

    
    /**
     * Method to return the value
     * @return V value
     */
    public V getValue() {
        return this.v0;
    }

    /**
     * 
     * @param a
     *            BST represent the BinaryTree
     * @param b
     *            BST represent the BinaryTree
     * @param c
     *            BST represent the BinaryTree
     * @param d
     *            BST represent the BinaryTree
     * @param x
     *            BST represent the BinaryTree
     * @param y
     *            BST represent the BinaryTree
     * @param z
     *            BST represent the BinaryTree
     * @return BST represent the BinaryTree
     */
    private BST<K, V> swap(BST<K, V> a, BST<K, V> b,
            BST<K, V> c, BST<K, V> d, BST<K, V> x,
            BST<K, V> y, BST<K, V> z) {
        BST<K, V> leftTree = new Node<K, V>(x.getKey(), x.getValue(), a,
                b, comp, black);
        BST<K, V> rightTree = new Node<K, V>(z.getKey(), z.getValue(),
                c, d, comp, black);

        return new Node<K, V>(y.getKey(), y.getValue(), leftTree, rightTree,
                comp, red);

    }

    /**
     * Method to get sort the tree
     * @param bt
     *            BST represent the BinaryTree
     * @return BST represent the BinaryTree
     */
    private BST<K, V> balanceMethod(BST<K, V> bt) {

        if (bt.getLeft().isRed() && bt.getLeft().getLeft().isRed()) {

            return swap(bt.getLeft().getLeft().getLeft(), bt.getLeft()
                    .getLeft().getRight(), bt.getLeft().getRight(),
                    bt.getRight(), bt.getLeft().getLeft(), bt.getLeft(), bt);

        }
        if (bt.getLeft().isRed() && bt.getLeft().getRight().isRed()) {

            return swap(bt.getLeft().getLeft(), bt.getLeft().getRight()
                    .getLeft(), bt.getLeft().getRight().getRight(),
                    bt.getRight(), bt.getLeft(), bt.getLeft().getRight(), bt);

        }
        if (bt.getRight().isRed() && bt.getRight().getLeft().isRed()) {

            return swap(bt.getLeft(), bt.getRight().getLeft().getLeft(), bt
                    .getRight().getLeft().getRight(), bt.getRight().getRight(),
                    bt, bt.getRight().getLeft(), bt.getRight());

        }
        if (bt.getRight().isRed() && bt.getRight().getRight().isRed()) {

            return swap(bt.getLeft(), bt.getRight().getLeft(), bt.getRight()
                    .getRight().getLeft(), bt.getRight().getRight().getRight(),
                    bt, bt.getRight(), bt.getRight().getRight());

        }
        return (BST<K, V>) bt;
    }


    /**
     * Method to return the comparator of the tree
     * @return comp comparator
     */
    public Comparator<? super K> getComp() {
        return comp;
    }

    /**
     * Method to represent the accept method
     * @param visitor visitor
     * @return bst
     */
    public BST<K, V> accept(MyMapVisitor<K, V> visitor) {
        BST<K, V> le = this.left.accept(visitor);
        BST<K, V> ri = this.right.accept(visitor);
        return new Node<K, V>(this.k0,
                visitor.visit(this.k0, this.v0),
                le, ri, comp, "red");
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
        if (this.isRed()) {
            return visitor.visitNode(comp, red, k0, v0, left, right);
        }
        else {
            return visitor.visitNode(comp, black, k0, v0, left, right);
        }
    }

    /**
     * Method to get Color
     * @return String color
     */
    public String getColor() {
        return this.color;
    }

  

}
