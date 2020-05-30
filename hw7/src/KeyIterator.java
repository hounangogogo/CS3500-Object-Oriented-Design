import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

class KeyIterator<K> implements Iterator<K> {

  ArrayList<K> list;
  int index;
  Comparator<? super K> c;


  /**
   * Constructor for keyIterator.
   * @param list list of key.
   */
  KeyIterator(ArrayList<K> list) {
    this.list = list;
    this.index = 0;
  }


  /**
   * Constructor for MIterator with comparator
   *
   * @param list list which represent an arrayList
   * @param c    comparator which represent an operation
   */
  KeyIterator(ArrayList<K> list, Comparator<? super K> c) {
    this.list = list;
    list.sort(c);
    index = 0;
  }


  @Override
  public boolean hasNext() {
    return index < list.size();
  }

  @Override
  public K next() {
    if (!this.hasNext()) {
      throw new NoSuchElementException(
              "There is no element in the empty list");
    } else {
      index++;
      return list.get(index - 1);
    }
  }
}
