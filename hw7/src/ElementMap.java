import java.util.ArrayList;

/**
 * Include<K, V> represent an map whose Key is k and value is v
 *
 * @param <K> Key it is a random data type
 * @param <V> Value it is a random data type
 * @author Haonan Zhao
 * @version 1/29/2014
 */
public class ElementMap<K, V> extends MyMap<K, V> {
  K k0;
  V v0;
  MyMap<K, V> m0;

  /**
   * Constructor for elementMap.
   *
   * @param k0 the key for new record.
   * @param v0 the value for new record.
   * @param m0 the map.
   */
  public ElementMap(K k0, V v0, MyMap<K, V> m0) {
    this.k0 = k0;
    this.v0 = v0;
    this.m0 = m0;
  }

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
    return false;
  }

  /**
   * method to produce the size of the map
   *
   * @return a integer which shows the size of the map
   */
  @Override
  public int size() {
    if (m0.containsKey(k0)) {
      return m0.size();
    } else {
      return 1 + m0.size();
    }
  }

  /**
   * Method to check whether the map contains k
   *
   * @param key represent a key k
   * @return a boolean which shows whether the map contains Key k
   */
  @Override
  public boolean containsKey(K key) {
    if (key.equals(k0)) {
      return true;
    } else {
      return m0.containsKey(key);
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
    if (k0.equals(key)) {
      return v0;
    } else {
      return m0.get(key);
    }
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
    if (k0.equals(key)) {
      return new ElementMap<>(key, value, m0);
    }
    else {
      return m0.set(key, value).include(k0, v0);
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
    if (list.contains(k0)) {
      return m0.getAllKeys(list);
    }
    else {
      list.add(k0);
      return m0.getAllKeys(list);
    }
  }

  /**
   * Function return the hashCode for an object.
   *
   * @return hashCode of an object.
   */
  @Override
  public int hashCode() {
    if (m0.containsKey(k0)) {
      return m0.hashCode();
    }
    else {
      return this.get(k0).hashCode() + m0.hashCode();
    }
  }
}
