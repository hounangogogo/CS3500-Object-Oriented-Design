import java.util.ArrayList;
import java.util.Comparator;

import mymap.MyMap;
import mymap.RBTVisitor;

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
public class PathLengths<K, V> implements RBTVisitor<K, V, ArrayList<Integer>> {


    /**
     * Method to visitEmpty Map
     * 
     * @param comp
     *            comparator
     * @param color
     *            string color
     * @return ArrayList
     */
    public ArrayList<Integer> visitEmpty(Comparator<? super K> comp,
            String color) {

        ArrayList<Integer> ilist = new ArrayList<Integer>();
        return ilist;
    }

    /**
     * Mehtod to get the left and right
     * 
     * @param comp
     *            comparator
     * @param color
     *            color
     * @param k
     *            key
     * @param v
     *            value
     * @param left
     *            left map
     * @param right
     *            right map
     * @return arrayList
     */
    public ArrayList<Integer> visitNode(Comparator<? super K> comp,
            String color, K k, V v, MyMap<K, V> left, MyMap<K, V> right) {
        return visithelper(left, right, 0);
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
    public ArrayList<Integer> visithelper(MyMap<K, V> left, MyMap<K, V> right,
            int height) {
        ArrayList<Integer> ilist = new ArrayList<Integer>();
        if (left.isEmpty() && right.isEmpty()) {
            ilist.add(height);
            return ilist;
        }
        if (left.isEmpty() && !right.isEmpty()) {
            ilist.add(height);
            return PathLengths.append(ilist,
                    visithelper(right.getLeft(), 
                            right.getRight(), height + 1));
        }
        if (!left.isEmpty() && right.isEmpty()) {
            ilist.add(height);
            return PathLengths.append(ilist,
                    visithelper(left.getLeft(),
                            left.getRight(), height + 1));
        } 
        else {
            return PathLengths.append(
                    visithelper(
                            right.getLeft(), 
                            right.getRight(), height + 1),
                    visithelper(
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
