/**
 * Class represent list data structure.
 */
public abstract class MyList {

  // static method

  /**
   * Function return an emptyList.
   *
   * @return an emptyList object.
   */
  public static MyList emptyList() {
    return new EmptyList();
  }

  /**
   * Function return an list with elements in it.
   *
   * @param l the list l.
   * @param s the string object s.
   * @return the list has s in it.
   */
  public static MyList add(MyList l, String s) {
    return new ElementList(s, l);
  }


  /**
   * Function return whether the list isEmpty or not.
   *
   * @param l the list need to be tested whether empty.
   * @return the list is empty or not.
   */
  public static boolean isEmpty(MyList l) {
    return l.isEmptyMethod();
  }


  /**
   * Get the String on given index.
   *
   * @param l the list.
   * @param i the index i.
   * @return the String on that index.
   */
  public static String get(MyList l, int i) {
    return l.getMethod(i);
  }


  /**
   * Set the string s on index i in list l.
   *
   * @param l given list l
   * @param i given index i
   * @param s given string s
   * @return the new list with string s on index i.
   */
  public static MyList set(MyList l, int i, String s) {
    return l.setMethod(i, s);
  }

  /**
   * Get the size of a list.
   *
   * @param l the given list.
   * @return the size of list.
   */
  public static int size(MyList l) {
    return l.sizeMethod();
  }


  /**
   * Check whether the list contains String s.
   *
   * @param l the given list l.
   * @param s the give string s.
   * @return whether the list contains string s.
   */
  public static boolean contains(MyList l, String s) {
    return l.containsMethod(s);
  }

  // abstract method

  /**
   * Function return whether the list isEmpty or not.
   *
   * @return the list is empty or not.
   */
  public abstract boolean isEmptyMethod();

  /**
   * Get the String on given index.
   *
   * @param i the index i.
   * @return the String on that index.
   */
  public abstract String getMethod(int i);

  /**
   * Set the string s on index i in list l.
   *
   * @param index given index i
   * @param s     given string s
   * @return the new list with string s on index i.
   */
  public abstract MyList setMethod(int index, String s);

  /**
   * The size of a list.
   *
   * @return the size of a list.
   */
  public abstract int sizeMethod();

  /**
   * Check whether the list contains String s.
   *
   * @param s the give string s.
   * @return whether the list contains string s.
   */
  public abstract boolean containsMethod(String s);


  /**
   * Write list in a string representation.
   *
   * @return the string representation of a list.
   */
  public abstract String toString();

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }

    if (obj instanceof MyList) {
      MyList l = (MyList) obj;
      if (MyList.size(l) != MyList.size(this)) {
        return false;
      } else {
        int size = MyList.size(l);
        int i = 0;
        while (i < size) {
          if (MyList.get(this, i).equals(MyList.get(l, i))) {
            i++;
          } else {
            return false;
          }
        }
      }
    } else {
      return false;
    }
    return true;
  }


  @Override
  public int hashCode() {
    return this.toString().hashCode();
  }
}





