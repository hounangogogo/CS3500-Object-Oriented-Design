/**
 * Class EmptyList represents an emptyList.
 */
public class EmptyList extends MyList {

  /**
   * Function return whether the list isEmpty or not.
   *
   * @return the list is empty or not.
   */
  @Override
  public boolean isEmptyMethod() {
    return true;
  }

  /**
   * Get the String on given index.
   *
   * @param i the index i.
   * @return the String on that index.
   */
  @Override
  public String getMethod(int i) {
    throw new RuntimeException("There is no element in the empty list");
  }

  /**
   * Set the string s on index i in list l.
   *
   * @param index given index i
   * @param s     given string s
   * @return the new list with string s on index i.
   */
  @Override
  public MyList setMethod(int index, String s) {
    throw new RuntimeException("There is no element in the empty list");
  }

  /**
   * The size of a list.
   *
   * @return the size of a list.
   */
  @Override
  public int sizeMethod() {
    return 0;
  }

  /**
   * Check whether the list contains String s.
   *
   * @param s the give string s.
   * @return whether the list contains string s.
   */
  @Override
  public boolean containsMethod(String s) {
    return false;
  }

  /**
   * Write list in a string representation.
   *
   * @return the string representation of a list.
   */
  @Override
  public String toString() {
    return "[]";
  }
}
