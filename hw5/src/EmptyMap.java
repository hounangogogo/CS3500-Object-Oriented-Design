import java.util.ArrayList;

/**
 * Empty<K, V> represent an empty map whose Key is k and value is v
 *
 * @param <K> Key it is a random data type
 * @param <V> Value it is a random data type
 * @author Haonan Zhao
 * @version 1/29/2014
 */
class EmptyMap<K, V> extends MyMap<K, V> {

  /**
   * Method is to produce an non-map
   *
   * @param key   represent a key k
   * @param value represent a value v
   * @return MyMap<K, V> which have Key k, and its Value v
   */
  @Override
  public MyMap<K, V> include(K key, V value) {
    return new ElementMap<>(key, value, this);
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
    throw new RuntimeException("There is no element in the empty Map");
  }

  /**
   * method to produce a map whose value being replaced by v on key k
   *
   * @param key   represent a key k
   * @param value represent a value v
   * @return MyMap<K, V> which put value v in map and its Key is k
   */
  @Override
  public MyMap<K, V> set(K key, V value) {
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


  @Override
  public int hashCode() {
    return 0;
  }

}
