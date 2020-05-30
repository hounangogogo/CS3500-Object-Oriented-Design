/**
 * MySet is an immutable abstract data type whose values represent finite sets with elements of type
 * Long.
 */
public abstract class MySet {

  // Static Method

  /**
   * Function return a empty set.
   *
   * @return a empty set.
   */
  public static MySet empty() {
    return new EmptySet();
  }

  /**
   * Function return a element set.
   *
   * @return a element set.
   */
  public static MySet insert(MySet s, Long l) {
    return new ElementSet(l, s);
  }


  /**
   * Function return the size of a set.
   *
   * @param s current set
   * @return the size of a set.
   */
  public static int size(MySet s) {
    return s.sizeMethod();
  }

  /**
   * Function return whether the set is empty.
   *
   * @param s the given set s.
   * @return whether the set is empty.
   */
  public static boolean isEmpty(MySet s) {
    return s.isEmptyMethod();
  }

  /**
   * Function return whether the set contains long l.
   *
   * @param s the given set s.
   * @param l the given long l.
   * @return whether the set contains long l.
   */
  public static boolean contains(MySet s, Long l) {
    return s.containsMethod(l);
  }

  /**
   * Check the first one is the subset of the second one.
   *
   * @param s1 the first set.
   * @param s2 the second set.
   * @return first one is the subset of the second one.
   */
  public static boolean isSubset(MySet s1, MySet s2) {
    return s1.isSubsetMethod(s2);
  }


  /**
   * Function return the set after long l has been removed.
   *
   * @param s the given set s.
   * @param l the long l need to be removed.
   * @return the set after long l has been removed.
   */
  public static MySet remove(MySet s, Long l) {
    return s.removeMethod(l);
  }

  /**
   * Function join the s1 with s2.
   *
   * @param s1 the first set s1.
   * @param s2 the second set s2.
   * @return the result after join two sets together.
   */
  public static MySet join(MySet s1, MySet s2) {
    return s1.joinMethod(s2);
  }

  /**
   * Function return the intersect of s1 and s2.
   *
   * @param s1 the first set s1.
   * @param s2 the second set s2.
   * @return the intersect of two sets.
   */
  public static MySet intersect(MySet s1, MySet s2) {
    return s1.intersectMethod(s2);
  }


  /**
   * Function replace l1 with l2.
   * @param s the set s.
   * @param l1 Long l1
   * @param l2 Long l2
   * @return the set after elements been replaced.
   */
  public static MySet replace(MySet s, Long l1, Long l2) {
    return s.replaceMethod(l1, l2);
  }


  // abstract methods

  /**
   * Method return the size of a list.
   *
   * @return the size of list.
   */
  public abstract int sizeMethod();

  /**
   * Function return whether the set is empty.
   *
   * @return whether the set is empty.
   */
  public abstract boolean isEmptyMethod();

  /**
   * Function return whether the set contains long l.
   *
   * @param l the given long l.
   * @return whether the set contains long l.
   */
  public abstract boolean containsMethod(Long l);

  /**
   * The current one is the subset of the other one.
   *
   * @param s the given set.
   * @return whether the current set is the subset of the other one.
   */
  public abstract boolean isSubsetMethod(MySet s);

  /**
   * Function return the set after long l has been removed.
   *
   * @param l the long l need to be removed.
   * @return the set after long l has been removed.
   */
  public abstract MySet removeMethod(Long l);

  /**
   * Function join the s1 with s2.
   *
   * @param s the given set s.
   * @return the result after join two sets together.
   */
  public abstract MySet joinMethod(MySet s);


  /**
   * Function return the intersect of s1 and s2.
   *
   * @param s set s.
   * @return the intersect of two sets.
   */
  public abstract MySet intersectMethod(MySet s);


  /**
   * Function replace l1 with l2.
   * @param l1 Long l1
   * @param l2 Long l2
   * @return the set after elements been replaced.
   */
  public abstract MySet replaceMethod(Long l1, Long l2);


  /**
   * Return the hashCode of a set.
   * @return the hashCode of a set.
   */
  public abstract int hashCode();

  @Override
  public String toString() {
    return "{...(This set contains " + MySet.size(this) + " elements)...}";
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (obj instanceof MySet) {
      MySet s = (MySet) obj;
      if (MySet.size(s) == MySet.size(this)) {
        return MySet.isSubset(s, this) &&
                MySet.isSubset(this, s);
      } else return false;
    } else {
      return false;
    }
  }
}
