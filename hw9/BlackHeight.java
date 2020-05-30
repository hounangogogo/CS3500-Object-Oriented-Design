import java.util.Comparator;

import mymap.MyMap;
import mymap.RBTVisitor;

/**
 * 
 * @author Haonan Zhao
 * @version 3/14/2014
 * 
 * @param <K>
 *            key is ramdom data type
 * @param <V>
 *            value is ramdom data type
 */
public class BlackHeight<K, V> implements RBTVisitor<K, V, Integer> {

    /**
     * Method to visit empty
     * 
     * @param comp
     *            comparator
     * @param color
     *            String color
     * @return integer 0
     */
    public Integer visitEmpty(Comparator<? super K> comp, String color) {

        return 0;
    }

    /**
     * Method to visit Node part
     * 
     * @param comp
     *            comparator
     * @param color
     *            string color
     * @param k
     *            key
     * @param v
     *            value
     * @param left
     *            MyMap<K, V>
     * @param right
     *            MyMap<K, V>
     * @return Integer
     */
    public Integer visitNode(Comparator<? super K> comp, String color, K k,
            V v, MyMap<K, V> left, MyMap<K, V> right) {

        if (color.equals("black")) {
            return 1 + right.acceptRBT(this);
        }
        else {
            return right.acceptRBT(this);
        }

    }

}
