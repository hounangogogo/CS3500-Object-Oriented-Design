import java.util.ArrayList;
import java.util.Comparator;


/**
 * Method to represent the RBTVisitor
 *
 * @author Haonan Zhao
 * @version 3/14/2014
 * @param <K>
 *            key is ramdom data type
 * @param <V>
 *            value is ramdom data type
 *
 */
class PathLengths<K, V> implements RBTVisitor<K, V, ArrayList<Integer>> {

  /**
   * The method for the empty tree
   *
   * @param comp the Comparator for the whole tree
   * @param red  the color of the node, which should be "RED" or "BLACK"
   * @return some value of the type R
   */
  @Override
  public ArrayList<Integer> visitEmpty(Comparator<? super K> comp, boolean red) {
    ArrayList<Integer> ilist = new ArrayList<Integer>();
    return ilist;
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
  public ArrayList<Integer> visitNode(Comparator<? super K> comp, boolean red, K k, V v, MyMap<K, V> left, MyMap<K, V> right) {
    return visitHelper(left, right, 0);
  }


  /**
   * Method to calculate the height
   *
   * @param left
   *            map
   * @param right
   *            map
   * @param height
   *            integer
   * @return arrayList
   */
  public ArrayList<Integer> visitHelper(MyMap<K, V> left, MyMap<K, V> right,
                                        int height) {
    ArrayList<Integer> ilist = new ArrayList<Integer>();
    if (left.isEmpty() && right.isEmpty()) {
      ilist.add(height);
      return ilist;
    }
    if (left.isEmpty() && !right.isEmpty()) {
      ilist.add(height);
      return PathLengths.append(ilist,
              visitHelper(right.getLeft(),
                      right.getRight(), height + 1));
    }
    if (!left.isEmpty() && right.isEmpty()) {
      ilist.add(height);
      return PathLengths.append(ilist,
              visitHelper(left.getLeft(),
                      left.getRight(), height + 1));
    }
    else {
      return PathLengths.append(
              visitHelper(
                      right.getLeft(),
                      right.getRight(), height + 1),
              visitHelper(
                      left.getLeft(), right.getRight(), height + 1));
    }

  }

  /**
   * Method to append two arrayList together
   *
   * @param arry1
   *            arrayList
   * @param arry2
   *            ArrayList
   * @param <T> type
   * @return ArrayList
   */
  public static <T> ArrayList<T> append(ArrayList<T> arry1,
                                        ArrayList<T> arry2) {
    for (T t : arry2) {
      arry1.add(t);
    }
    return arry1;
  }
}