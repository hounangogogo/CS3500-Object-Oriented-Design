import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Node to represent the the binaryTree with k0 and v0 in it
 * @author Haonan Zhao
 *
 * @param <K> k Key it is a random data type
 * @param <V> v Value it is a random data type
 * @version 2/11/2014
 */
public class Node<K, V> extends MyTree<K, V> {

  private K k0;
  private V v0;
  private MyTree<K, V> left;
  private MyTree<K, V> right;
  private Comparator<? super K> comp;
  private int size;

  /**
   * Method represent the Node of BinaryTree
   * @param k0 represent value of first node
   * @param v0 represent value of first node
   * @param left represent the left tree of this tree
   * @param right represent the right tree of this tree
   * @param comp represent the comparator of tree
   */
  Node(K k0, V v0, MyTree<K, V> left, MyTree<K, V> right, Comparator<? super K> comp) {
    this.k0 = k0;
    this.v0 = v0;
    this.left = left;
    this.right = right;
    this.comp = comp;
    this.size = 1 + left.size() + right.size();
  }

  /**
   * Method is to produce an non-map
   *
   * @param key   represent a key k
   * @param value represent a value v
   * @return MyMap<K, V> which have Key k, and its Value v
   */
  @Override
  public MyTree<K, V> include(K key, V value) {
    if(key.equals(k0)) {
      return this.set(key, value);
    }
    else if (comp.compare(k0, key) > 0) {
      return new Node<>(k0, v0, left.set(key, value), right, comp);
    }
    else {
      return new Node<>(k0, v0, left, right.set(key, value), comp);
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
    }
    else if (comp.compare(k0, key) > 0) {
      return left.get(key);
    }
    else {
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
      return new Node<>(k0, value, left, right, comp);
    }
    else if (comp.compare(k0, key) > 0) {
      return new Node<>(k0, v0, left.set(key, value), right, comp);
    }
    else {
      return new Node<>(k0, v0, left, right.set(key, value), comp);
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
