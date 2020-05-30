package mymap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * MyIterator<K> that represent an iterator can check throgh the list
 * 
 * @author Haonan Zhao
 * 
 * @param <K>
 *            key which is a random value type
 * 
 * @version 1/29/2014
 */
class MyIterator<K> implements Iterator<K> {

    /** Represent the arryList **/
    ArrayList<K> arry;

    /** represent index of list */
    int i;

    /** represent the comparator */
    Comparator<? super K> c;

    /**
     * Constructor for MIterator without comparator
     * 
     * @param arry
     *            list which is an arrayList
     */
    MyIterator(ArrayList<K> arry) {
        this.arry = arry;
        this.i = 0;

    }

    /**
     * Constructor for MIterator with comparator
     * 
     * @param arry
     *            list which represent an arrayList
     * @param c
     *            comparator which represent an operation
     */
    MyIterator(ArrayList<K> arry, Comparator<? super K> c) {
        this.arry = arry;
        Collections.sort(arry, c);

    }

    /**
     * Method to return the next value in list
     * 
     * @return boolean to determine whether there are more element
     */
    public boolean hasNext() {
        return i < arry.size();
    }

    /**
     * Method to return the next key of the list
     * 
     * @return K which is the next key
     */
    public K next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException(
                    "There is no element in the empty list");
        } 
        else {
            i = i + 1;
            return arry.get(i - 1);
        }
    }

    /**
     * 
     * Remove unsupported method has no effects and throws exception
     */
    public void remove() {
        throw new UnsupportedOperationException("no element can be remove");
    }
}
