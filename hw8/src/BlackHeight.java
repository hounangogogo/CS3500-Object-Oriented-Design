import java.util.Comparator;

/**
 *
 * @author Haonan Zhao
 * @version 3/14/2014
 *
 * @param <K>
 *            key is ramdom data type
 * @param <V>
 *            value is ramdom data type
 */
public class BlackHeight<K, V> implements RBTVisitor<K, V, Integer> {

  /**
   * The method for the empty tree
   *
   * @param comp the Comparator for the whole tree
   * @param red  the color of the node, which should be "RED" or "BLACK"
   * @return some value of the type R
   */
  @Override
  public Integer visitEmpty(Comparator<? super K> comp, boolean red) {
    return 0;
  }

  /**
   * The method for the node of the tree
   *
   * @param comp  the Comparator for the whole tree
   * @param red   the color of the node, which should be "RED" or "BLACK"
   * @param k     the key for the node
   * @param v     the value for the node
   * @param left  the left subtree of the node
   * @param right the right subtree of the node
   * @return some value of the type R
   */
  @Override
  public Integer visitNode(Comparator<? super K> comp, boolean red, K k, V v, MyMap<K, V> left, MyMap<K, V> right) {
    if (!red) {
      return 1 + right.acceptRBT(this);
    }
    else {
      return right.acceptRBT(this);
    }
  }
}