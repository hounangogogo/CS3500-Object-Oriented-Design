import java.util.Comparator;

/**
 * UsualInteger represent an comparator operation
 * (According to the PPT from class)
 * @author Haonan Zhao
 * @version 1/31/2014
 */
class UsualIntegerComparator implements Comparator<Integer> {
  /**
   * Compares its two arguments for order.
   *
   * @param m
   *            first Integer to compare
   * @param n
   *            second Integer to compare
   * @return Returns a negative integer, zero, or a positive integer as m is
   *         less than, equal to, or greater than n
   */
  public int compare(Integer m, Integer n) {
    return m.compareTo(n);
  }

  /**
   * Is this <code>Comparator</code> same as the given object
   *
   * @param o
   *            the given object
   * @return true if the given object is an instance of this class
   */
  public boolean equals(Object o) {
    return (o instanceof UsualIntegerComparator);
  }

  /**
   * There should be only one instance of this class = all are equal
   *
   * @return the hash code same for all instances
   */
  public int hashCode() {
    return (this.toString().hashCode());
  }

  /**
   * @return name of class
   */
  public String toString() {
    return "UsualIntegerComparator";
  }
}