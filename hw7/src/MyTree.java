import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * BinaryTree represent BinaryTree whose key is k
 * whose value is v
 * @author Haonan Zhao
 *
 * @param <K> k Key it is a random data type
 * @param <V> v Value it is a random data type
 * @version 2/11/2014
 */
abstract class MyTree<K, V> extends MyMap<K, V> {

  // -------------------- red black tree --------------------

  /**
   * Get the left tree.
   * @return left tree.
   */
  public abstract MyTree<K,V> getLeft();

  /**
   * Get the right tree.
   * @return right tree.
   */
  public abstract MyTree<K, V> getRight();


  /**
   * Method to get the comparator
   * @return c comparator
   */
  public abstract Comparator<? super K> getComp();

  /**
   * Get the key of the node.
   * @return the key of the node.
   */
  public abstract K getKey();


  /**
   * Get the value of the node.
   * @return the value of the node.
   */
  public abstract V getValue();


  /**
   * Function check the current node is red or not.
   * @return current node is red or not.
   */
  public abstract boolean isRed();


  /**
   * Make the root black.
   * @return the tree with black root.
   */
   Node<K, V> makeBlack() {
    return new Node<>(this.getKey(), this.getValue(),
            this.getLeft(), this.getRight(),
            this.getComp(), false);
  }


  /**
   * Balance a tree.
   * @return balance a tree.
   */
  public abstract MyTree<K, V> balance();


  /**
   * Method is to produce an non-map
   *
   * @param key   represent a key k
   * @param value represent a value v
   * @return MyMap<K, V> which have Key k, and its Value v
   */
  @Override
  public MyTree<K, V> include(K key, V value) {
    return includeHelper(key, value).makeBlack();
  }


  abstract MyTree<K, V> includeHelper(K key, V value);

  /**
   * Method is to produce a boolean which shows whether the map is empty.
   *
   * @return boolean which represent whether the map is empty
   */
  @Override
  public abstract boolean isEmpty();

  /**
   * method to produce the size of the map
   *
   * @return a integer which shows the size of the map
   */
  @Override
  public abstract int size();

  /**
   * Method to check whether the map contains k
   *
   * @param key represent a key k
   * @return a boolean which shows whether the map contains Key k
   */
  @Override
  public abstract boolean containsKey(K key);


  /**
   * Method to get the value whose key is k
   *
   * @param key represent a key k
   * @return V value whose Key is k in the Map
   */
  @Override
  public abstract V get(K key);

  /**
   * method to produce a map whose value being replaced by v on key k
   *
   * @param key   represent a key k
   * @param value represent a value v
   * @return MyTree<K, V> which put value v in map and its Key is k
   */
  @Override
  public abstract MyTree<K, V> set(K key, V value);

  /**
   * Get all keys from a map.
   *
   * @param list list contains keys.
   * @return the list of keys.
   */
  @Override
  public abstract ArrayList<K> getAllKeys(ArrayList<K> list);


  @Override
  public Iterator<K> iterator() {
    return new KeyIterator<>(this.getAllKeys(new ArrayList<K>()));
  }
}
