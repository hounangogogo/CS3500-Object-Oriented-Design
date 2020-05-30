import mymap.MyMapVisitor;

/**
 * Mehtod to represent GCD method
 * 
 * @author Haonan Zhao
 * @version 3/14/2014
 * @param <K>
 *            k is a ramdom data type
 * @param <V>
 *            v is a ramdom data type
 */
public class GCD<K, V> implements MyMapVisitor<Integer, Integer> {

    /**
     * Method to visit the map
     * 
     * @param k
     *            key
     * @param v
     *            value
     * @return integer
     */
    public Integer visit(Integer k, Integer v) {

        return gcdhelper(k, v);
    }

    /**
     * Method to caluate the gcd for 2 number
     * 
     * @param k
     *            integer k
     * @param v
     *            integer v
     * @return integer
     */
    static Integer gcdhelper(Integer k, Integer v) {
        if (v == 0) {
            return k;
        }
        else {
            return gcdhelper(v, (k % v));
        }
    }

}
