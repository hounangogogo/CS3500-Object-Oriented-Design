/**
 * Class EmptySet represents a set without any element in it.
 */
public class EmptySet extends MySet {

  /**
   * Method return the size of a list.
   *
   * @return the size of list.
   */
  @Override
  public int sizeMethod() {
    return 0;
  }

  /**
   * Function return whether the set is empty.
   *
   * @return whether the set is empty.
   */
  @Override
  public boolean isEmptyMethod() {
    return true;
  }

  /**
   * Function return whether the set contains long l.
   *
   * @param l the given long l.
   * @return whether the set contains long l.
   */
  @Override
  public boolean containsMethod(Long l) {
    return false;
  }

  /**
   * The current one is the subset of the other one.
   *
   * @param s the given set.
   * @return whether the current set is the subset of the other one.
   */
  @Override
  public boolean isSubsetMethod(MySet s) {
    return true;
  }

  /**
   * Function return the set after long l has been removed.
   *
   * @param l the long l need to be removed.
   * @return the set after long l has been removed.
   */
  @Override
  public MySet removeMethod(Long l) {
    return this;
  }

  /**
   * Function join the s1 with s2.
   *
   * @param s the given set s.
   * @return the result after join two sets together.
   */
  @Override
  public MySet joinMethod(MySet s) {
    return s;
  }

  /**
   * Function return the intersect of s1 and s2.
   *
   * @param s set s.
   * @return the intersect of two sets.
   */
  @Override
  public MySet intersectMethod(MySet s) {
    return this;
  }

  /**
   * Function replace l1 with l2.
   *
   * @param l1 Long l1
   * @param l2 Long l2
   * @return the set after elements been replaced.
   */
  @Override
  public MySet replaceMethod(Long l1, Long l2) {
    return this;
  }

  /**
   * Return the hashCode of a set.
   *
   * @return the hashCode of a set.
   */
  @Override
  public int hashCode() {
    return 0;
  }
}
