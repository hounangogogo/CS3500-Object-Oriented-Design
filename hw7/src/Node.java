import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * Node to represent the the binaryTree with k0 and v0 in it
 *
 * @param <K> k Key it is a random data type
 * @param <V> v Value it is a random data type
 * @author Haonan Zhao
 * @version 2/11/2014
 */
public class Node<K, V> extends MyTree<K, V> {

  private K k0;
  private V v0;
  private MyTree<K, V> left;
  private MyTree<K, V> right;
  private Comparator<? super K> comp;
  private int size;
  private boolean red;

  /**
   * Method represent the Node of BinaryTree
   *
   * @param k0    represent value of first node
   * @param v0    represent value of first node
   * @param left  represent the left tree of this tree
   * @param right represent the right tree of this tree
   * @param comp  represent the comparator of tree
   * @red red represent the color of the node.
   */
  Node(K k0, V v0, MyTree<K, V> left, MyTree<K, V> right, Comparator<? super K> comp, boolean red) {
    this.k0 = k0;
    this.v0 = v0;
    this.left = left;
    this.right = right;
    this.comp = comp;
    this.size = 1 + left.size() + right.size();
    this.red = red;
  }

  /**
   * Get the left tree.
   *
   * @return left tree.
   */
  @Override
  public MyTree<K, V> getLeft() {
    return left;
  }

  /**
   * Get the right tree.
   *
   * @return right tree.
   */
  @Override
  public MyTree<K, V> getRight() {
    return right;
  }

  /**
   * Method to get the comparator
   *
   * @return c comparator
   */
  @Override
  public Comparator<? super K> getComp() {
    return comp;
  }

  /**
   * Get the key of the node.
   *
   * @return the key of the node.
   */
  @Override
  public K getKey() {
    return k0;
  }

  /**
   * Get the value of the node.
   *
   * @return the value of the node.
   */
  @Override
  public V getValue() {
    return v0;
  }

  /**
   * Function check the current node is red or not.
   *
   * @return current node is red or not.
   */
  @Override
  public boolean isRed() {
    return red;
  }

  /**
   * Balance a tree.
   *
   * @return balance a tree.
   */
  @Override
  public MyTree<K, V> balance() {
    if (this.getLeft().isEmpty() && this.getRight().isEmpty()) {
      return this;
    }
    // case 1: left(red), left-right(red)
    else if (this.getLeft().isRed() && this.getLeft().getRight().isRed()) {
      return this.case1();
    }
    // Case 2: Left(red), left-left(red)
    else if (this.getLeft().isRed() &&
            this.getLeft().getLeft().isRed()) {
      return this.case2();
    }
    // Case 3: right(red), right-right(red)
    else if (this.getRight().isRed() &&
            this.getRight().getRight().isRed()) {
      return this.case3();
    }
    // Case 4: Right(red), right -left(red)
    else if (this.getRight().isRed() &&
            this.getRight().getLeft().isRed()) {
      return this.case4();
    } else {
      return this;
    }
  }

  /**
   * Case one balance.
   *
   * @return the balanced tree.
   */
  private MyTree<K, V> case1() {
    MyTree<K, V> a = this.getLeft().getLeft();
    MyTree<K, V> b = this.getLeft().getRight().getLeft();
    MyTree<K, V> c = this.getLeft().getRight().getRight();
    MyTree<K, V> d = this.getRight();

    MyTree<K, V> x = this.getLeft();
    MyTree<K, V> y = this.getLeft().getRight();
    MyTree<K, V> z = this;

    Node<K, V> left = new Node<>(x.getKey(), x.getValue(), a, b, this.comp, false);
    Node<K, V> right = new Node<>(z.getKey(), z.getValue(), c, d, this.comp, false);

    return new Node<>(y.getKey(), y.getValue(), left, right, this.comp, true);
  }


  /**
   * Case one balance.
   *
   * @return the balanced tree.
   */
  MyTree<K, V> case2() {
    MyTree<K, V> a = this.getLeft().getLeft().getLeft();
    MyTree<K, V> b = this.getLeft().getLeft().getRight();
    MyTree<K, V> c = this.getLeft().getRight();
    MyTree<K, V> d = this.getRight();

    MyTree<K, V> x = this.getLeft().getLeft();
    MyTree<K, V> y = this.getLeft();
    MyTree<K, V> z = this;

    Node<K, V> left = new Node<>(x.getKey(), x.getValue(), a, b, this.comp, false);
    Node<K, V> right = new Node<>(z.getKey(), z.getValue(), c, d, this.comp, false);

    return new Node<>(y.getKey(), y.getValue(), left, right, this.comp, true);
  }


  /**
   * Case one balance.
   *
   * @return the balanced tree.
   */
  MyTree<K, V> case3() {
    MyTree<K, V> a = this.getLeft();
    MyTree<K, V> b = this.getRight().getLeft();
    MyTree<K, V> c = this.getRight().getRight().getLeft();
    MyTree<K, V> d = this.getRight().getRight().getRight();

    MyTree<K, V> x = this;
    MyTree<K, V> y = this.getRight();
    MyTree<K, V> z = this.getRight().getRight();

    Node<K, V> left = new Node<>(x.getKey(), x.getValue(), a, b, this.comp, false);
    Node<K, V> right = new Node<>(z.getKey(), z.getValue(), c, d, this.comp, false);
    return new Node<>(y.getKey(), y.getValue(), left, right, this.comp, true);
  }


  // case4 : -> FTree<K,V>
  // Reorders the tree when the case is Red right - Red left.
  MyTree<K, V> case4() {
    MyTree<K, V> a = this.getLeft();
    MyTree<K, V> b = this.getRight().getLeft().getLeft();
    MyTree<K, V> c = this.getRight().getLeft().getRight();
    MyTree<K, V> d = this.getRight().getRight();

    MyTree<K, V> x = this;
    MyTree<K, V> y = this.getRight().getLeft();
    MyTree<K, V> z = this.getRight();

    Node<K, V> left = new Node<>(x.getKey(), x.getValue(), a, b, this.comp, false);
    Node<K, V> right = new Node<>(z.getKey(), z.getValue(), c, d, this.comp, false);
    return new Node<>(y.getKey(), y.getValue(), left, right, this.comp, true);

  }


  @Override
  MyTree<K, V> includeHelper(K key, V value) {
    MyTree<K, V> rbtree;
    if (key.equals(k0)) {
      rbtree = this.set(key, value);
      return rbtree.balance();
    }
    if (this.comp.compare(this.k0, key) > 0) {
      rbtree = new Node<K, V>(this.k0, this.v0, this.left.includeHelper(key, value),
              this.right, this.comp, red);
      return rbtree.balance();
    }
    else {
      rbtree = new Node<K, V>(this.k0, this.v0, this.left,
              this.right.includeHelper(key, value), this.comp, red);
      return rbtree.balance();
    }
  }

  /**
   * Method is to produce a boolean which shows whether the map is empty.
   *
   * @return boolean which represent whether the map is empty
   */
  @Override
  public boolean isEmpty() {
    return false;
  }

  /**
   * method to produce the size of the map
   *
   * @return a integer which shows the size of the map
   */
  @Override
  public int size() {
    return this.size;
  }

  /**
   * Method to check whether the map contains k
   *
   * @param key represent a key k
   * @return a boolean which shows whether the map contains Key k
   */
  @Override
  public boolean containsKey(K key) {
    if (k0.equals(key)) {
      return true;
    } else {
      return left.containsKey(key) || right.containsKey(key);
    }
  }

  /**
   * Method to get the value whose key is k
   *
   * @param key represent a key k
   * @return V value whose Key is k in the Map
   */
  @Override
  public V get(K key) {
    if (key.equals(k0)) {
      return v0;
    } else if (comp.compare(k0, key) > 0) {
      return left.get(key);
    } else {
      return right.get(key);
    }
  }

  /**
   * method to produce a map whose value being replaced by v on key k
   *
   * @param key   represent a key k
   * @param value represent a value v
   * @return MyTree<K, V> which put value v in map and its Key is k
   */
  @Override
  public MyTree<K, V> set(K key, V value) {
    if (key.equals(k0)) {
      return new Node<>(k0, value, left, right, comp, red);
    } else if (comp.compare(k0, key) > 0) {
      return new Node<>(k0, v0, left.set(key, value), right, comp, red);
    } else {
      return new Node<>(k0, v0, left, right.set(key, value), comp, red);
    }
  }

  /**
   * Get all keys from a map.
   *
   * @param list list contains keys.
   * @return the list of keys.
   */
  @Override
  public ArrayList<K> getAllKeys(ArrayList<K> list) {
    list.add(k0);
    list.addAll(left.getAllKeys(new ArrayList<>()));
    list.addAll(right.getAllKeys(new ArrayList<>()));
    return list;
  }

  /**
   * Function return the hashCode for an object.
   *
   * @return hashCode of an object.
   */
  @Override
  public int hashCode() {
    ArrayList<K> a = new ArrayList<>();
    Iterator<K> keys = this.getAllKeys(a).iterator();
    int i = 1;
    while (keys.hasNext()) {
      i = i * keys.next().hashCode();
    }
    return i;
  }
}
