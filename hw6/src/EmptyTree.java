import java.util.ArrayList;
import java.util.Comparator;

/**
 * EmptyTree<K, V> represent an EmptyTree
 *
 * @param <K> k Key it is a random data type
 * @param <V> v Value it is a random data type
 * @author Haonan Zhao
 * @version 2/11/2014
 */
class EmptyTree<K, V> extends MyTree<K, V> {

  Comparator<? super K> comp;

  /**
   * Constructor for empty tree.
   * @param comp comparator
   */
  EmptyTree(Comparator<? super K> comp) {
    this.comp = comp;
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
    return new Node<>(key, value, this, this, comp);
  }

  /**
   * Method is to produce a boolean which shows whether the map is empty.
   *
   * @return boolean which represent whether the map is empty
   */
  @Override
  public boolean isEmpty() {
    return true;
  }

  /**
   * method to produce the size of the map
   *
   * @return a integer which shows the size of the map
   */
  @Override
  public int size() {
    return 0;
  }

  /**
   * Method to check whether the map contains k
   *
   * @param key represent a key k
   * @return a boolean which shows whether the map contains Key k
   */
  @Override
  public boolean containsKey(K key) {
    return false;
  }

  /**
   * Method to get the value whose key is k
   *
   * @param key represent a key k
   * @return V value whose Key is k in the Map
   */
  @Override
  public V get(K key) {
    throw new RuntimeException("No key to get");  }

  /**
   * method to produce a map whose value being replaced by v on key k
   *
   * @param key   represent a key k
   * @param value represent a value v
   * @return MyTree<K, V> which put value v in map and its Key is k
   */
  @Override
  public MyTree<K, V> set(K key, V value) {
    return this.include(key, value);
  }

  /**
   * Get all keys from a map.
   *
   * @param list list contains keys.
   * @return the list of keys.
   */
  @Override
  public ArrayList<K> getAllKeys(ArrayList<K> list) {
    return list;
  }

  /**
   * Function return the hashCode for an object.
   *
   * @return hashCode of an object.
   */
  @Override
  public int hashCode() {
    return 0;
  }
}
