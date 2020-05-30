/**
 * ElementList represents list with elements in it.
 */
public class ElementList extends MyList {

  private String first;
  private MyList rest;

  /**
   * Constructor for elementList.
   *
   * @param first the first element of the list.
   * @param rest  the rest element of the list.
   */
  public ElementList(String first, MyList rest) {
    this.first = first;
    this.rest = rest;
  }

  /**
   * Function return whether the list isEmpty or not.
   *
   * @return the list is empty or not.
   */
  @Override
  public boolean isEmptyMethod() {
    return false;
  }

  /**
   * Get the String on given index.
   *
   * @param i the index i.
   * @return the String on that index.
   */
  @Override
  public String getMethod(int i) {
    if (i < 0) {
      throw new RuntimeException("given number is too small");
    }
    if (i == 0) {
      return first;
    } else {
      return MyList.get(rest, i - 1);
    }
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
    if (index == 0) {
      return MyList.add(rest, s);
    } else {
      return MyList.add(MyList.set(rest, index - 1, s), first);
    }
  }

  /**
   * The size of a list.
   *
   * @return the size of a list.
   */
  @Override
  public int sizeMethod() {
    return 1 + MyList.size(rest);
  }

  /**
   * Check whether the list contains String s.
   *
   * @param s the give string s.
   * @return whether the list contains string s.
   */
  @Override
  public boolean containsMethod(String s) {
    if (s.equals(first)) {
      return true;
    } else {
      return MyList.contains(rest, s);
    }
  }

  /**
   * Write list in a string representation.
   *
   * @return the string representation of a list.
   */
  @Override
  public String toString() {
    if (MyList.isEmpty(rest)) {
      return "[" + first.toString() + "]";
    } else {
      return "[" + first.toString() + ", "
              + rest.toString().substring(1, rest.toString().length());
    }
  }


}
