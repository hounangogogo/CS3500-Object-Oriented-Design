import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * MyMap represent a map whose Key is k, and value is V, and implements iterable<K>
 *
 * @param <K> Key it is a random data type
 * @param <V> Value it is a random data type
 * @author Haonan Zhao
 * @version 1/29/2014
 */
public abstract class MyMap<K, V> implements Iterable<K> {

  // static method
  /**
   * Method is to produce an empty map
   *
   * @param <K> key which is a random data type
   * @param <V> value which is a random data type
   * @return My<K, V> which is a empty map
   */
  public static <K, V> EmptyMap empty() {

    return new EmptyMap();
  }

  /**
   * Method is to produce an empty map with a comparator
   *
   * @param <K>  key which is a random data type
   * @param <V>  value which is a random data type
   * @param comp comparator which is an operation
   * @return My<K, V> which is a empty map
   */
  public static <K, V> EmptyTree<K, V> empty(Comparator<? super K> comp) {
    return new EmptyTree<>(comp);
  }


  // Dynamic Method

  /**
   * Method is to produce an non-map
   *
   * @param key   represent a key k
   * @param value represent a value v
   * @return MyMap<K, V> which have Key k, and its Value v
   */
  public abstract MyMap<K, V> include(K key, V value);


  /**
   * Method is to produce a boolean which shows whether the map is empty.
   *
   * @return boolean which represent whether the map is empty
   */
  public abstract boolean isEmpty();

  /**
   * method to produce the size of the map
   *
   * @return a integer which shows the size of the map
   */
  public abstract int size();

  /**
   * Method to check whether the map contains k
   *
   * @param key represent a key k
   * @return a boolean which shows whether the map contains Key k
   */
  public abstract boolean containsKey(K key);

  /**
   * Method to get the value whose key is k
   *
   * @param key represent a key k
   * @return V value whose Key is k in the Map
   */
  public abstract V get(K key);

  /**
   * method to produce a map whose value being replaced by v on key k
   *
   * @param key   represent a key k
   * @param value represent a value v
   * @return MyMap<K, V> which put value v in map and its Key is k
   */
  public abstract MyMap<K, V> set(K key, V value);


  /**
   * Get all keys from a map.
   *
   * @param list list contains keys.
   * @return the list of keys.
   */
  public abstract ArrayList<K> getAllKeys(ArrayList<K> list);


  @Override
  public String toString() {
    return "{...(" + this.size() + " key(s) mapped to value(s))...}";
  }


  @Override
  public boolean equals(Object o) {
    if (o instanceof MyMap) {
      MyMap<K, V> m = (MyMap<K, V>) o;
      if (this.size() == m.size()) {
        ArrayList<K> Keys = new ArrayList<>();
        ArrayList<K> allKeys = this.getAllKeys(Keys);
        for (K k : allKeys) {
          if (m.containsKey(k)) {
            if (m.get(k).equals(this.get(k))) {
            } else {
              return false;
            }
          }
        }
        return true;
      } else {
        return false;
      }
    }
    return false;
  }


  /**
   * Function return the hashCode for an object.
   * @return hashCode of an object.
   */
  public abstract int hashCode();

  @Override
  public Iterator<K> iterator() {
    return new KeyIterator<K>(getAllKeys(new ArrayList<>()));
  }

  /**
   * Method is to produce a new list which the element are sorted
   *
   * @param c comparator which is an operation
   * @return Iterator<K> that can iterate through the map, sorted by c
   */
  public Iterator<K> iterator(Comparator<? super K> c) {
    return new KeyIterator<>(getAllKeys(new ArrayList<>()), c);
  }
}
