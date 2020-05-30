
/**
 * ElementSet represents a set with elements in it.
 */
public class ElementSet extends MySet {
  private Long first;
  private MySet rest;

  /**
   * Constructor for a ElementSet.
   * @param first the first element in set.
   * @param rest the rest element in set.
   */
  public ElementSet(Long first, MySet rest) {
    this.first = first;
    this.rest = rest;
  }

  /**
   * Method return the size of a list.
   *
   * @return the size of list.
   */
  @Override
  public int sizeMethod() {
    return 1 + MySet.size(rest);
  }

  /**
   * Function return whether the set is empty.
   *
   * @return whether the set is empty.
   */
  @Override
  public boolean isEmptyMethod() {
    return false;
  }

  /**
   * Function return whether the set contains long l.
   *
   * @param l the given long l.
   * @return whether the set contains long l.
   */
  @Override
  public boolean containsMethod(Long l) {
    if (first.equals(l)) {
      return true;
    }
    else {
      return MySet.contains(rest, l);
    }
  }

  /**
   * The current one is the subset of the other one.
   *
   * @param s the given set.
   * @return whether the current set is the subset of the other one.
   */
  @Override
  public boolean isSubsetMethod(MySet s) {
    if (MySet.contains(s, first)) {
      return MySet.isSubset(rest, s);
    }
    else {
      return false;
    }
  }

  /**
   * Function return the set after long l has been removed.
   *
   * @param l the long l need to be removed.
   * @return the set after long l has been removed.
   */
  @Override
  public MySet removeMethod(Long l) {
    if (first.equals(l)) {
      return rest;
    }
    else {
      return MySet.insert(MySet.remove(rest, l), first);
    }
  }

  /**
   * Function join the s1 with s2.
   *
   * @param s the given set s.
   * @return the result after join two sets together.
   */
  @Override
  public MySet joinMethod(MySet s) {
    if (MySet.contains(s, first)) {
      return MySet.join(rest, s);
    }
    else {
      return MySet.insert(MySet.join(rest, s), first);
    }
  }

  /**
   * Function return the intersect of s1 and s2.
   *
   * @param s set s.
   * @return the intersect of two sets.
   */
  @Override
  public MySet intersectMethod(MySet s) {
    if (MySet.contains(s, first)) {
      return MySet.insert(MySet.intersect(rest, s), first);
    }
    else {
      return MySet.intersect(rest, s);
    }
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
    if (first.equals(l1)) {
      return MySet.insert(MySet.replace(rest, l1, l2), l2);
    }
    else {
      return MySet.insert(MySet.replace(rest, l1, l2), first);
    }
  }

  /**
   * Return the hashCode of a set.
   *
   * @return the hashCode of a set.
   */
  @Override
  public int hashCode() {
    if (MySet.contains(rest, first)) {
      return rest.hashCode();
    }
    else {
      return first.hashCode() + rest.hashCode();
    }
  }
}