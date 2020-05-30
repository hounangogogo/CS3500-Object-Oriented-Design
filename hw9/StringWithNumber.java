import mymap.MyMapVisitor;

/**
 * Method to represent the stringwithnumber
 * 
 * @author Haonan Zhao
 * @version 3/14/2014
 * @param <K>
 *            key is ramdom data type
 * @param <V>
 *            value is ramdom data type
 */
public class StringWithNumber<K, V> implements MyMapVisitor<Integer, String> {

    /**
     * Method to represent the visit
     * @param k integer k
     * @param v string v
     * @return string
     */
    public String visit(Integer k, String v) {

        return swnhelper(k, v);
    }

    /**
     * Method to represent swnhelper
     * 
     * @param k
     *            key
     * @param v
     *            value
     * @return string
     */
    static String swnhelper(Integer k, String v) {
        return v + " " + k.toString();
    }

}
