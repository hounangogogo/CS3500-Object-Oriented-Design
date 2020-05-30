/**
 * A visitor for MyMap
 *
 * @param <K> the type of key stored in the MyMap
 * @param <V> the type of value stored in the MyMap
 * @author CS3500sp14
 * @version 2014.02.26
 */
public interface MyMapVisitor<K, V> {

  /**
   * @param k given key
   * @param v given value
   * @return a suitable new value
   */
  public V visit(K k, V v);
}
