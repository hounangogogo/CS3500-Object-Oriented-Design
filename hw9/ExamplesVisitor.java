import java.util.Comparator;

import tester.Tester;
import mymap.BST;
import mymap.EmptyTree;
import mymap.MyMap;
import mymap.UsualIntegerComparator;

/**
 * Method to test visitor method
 * 
 * @author Haonan Zhao
 * @version 3/14/2014
 */
public class ExamplesVisitor {
    /** represent comparator */
    Comparator<Integer> c = new UsualIntegerComparator();

    /** represent empty map */
    MyMap<Integer, Integer> m0 = MyMap.empty();
    /** represent map1 */
    MyMap<Integer, Integer> m1 = m0.include(10, 20);
    /** represent map2 */
    MyMap<Integer, Integer> m2 = m0.include(15, 20);

    /** represent map s0 */
    MyMap<Integer, String> s0 = MyMap.empty();

    /** represent map s1 */
    MyMap<Integer, String> s1 = s0.include(20, "Bob");

    /** represent map s2 */
    MyMap<Integer, String> s2 = s0.include(40, "haha");
    /** represent map s3 */
    MyMap<Integer, String> s3 = s0.include(50, "bbb");

    /** represent tree0 */
    BST<Integer, String> tree0 = new EmptyTree<Integer, String>(c);

    /** represent tree4 */
    BST<Integer, String> tree4 = tree0.include(4, "d");

    /** represent tree5 */
    BST<Integer, String> tree5 = tree4.include(5, "e");
    /** represent tree6 */
    BST<Integer, String> tree6 = tree5.include(6, "f");
    /** represent tree7 */
    BST<Integer, String> tree7 = tree6.include(7, "g");

    /** represent map i0 */
    MyMap<Integer, Integer> i0 = MyMap.empty();
    /** represent map i1 */
    MyMap<Integer, Integer> i1 = i0.include(20, 30);
    /** represent map i2 */
    MyMap<Integer, Integer> i2 = i0.include(15, 30);
    /** represent map i3 */
    MyMap<Integer, Integer> i3 = i0.include(18, 30);

    /**
     * Method to test gdc
     * 
     * @param t
     *            tester
     */
    void testGCD(Tester t) {
        t.checkExpect(GCD.gcdhelper(i1.getKey(), i1.getValue()), 10);
        t.checkExpect(GCD.gcdhelper(i2.getKey(), i2.getValue()), 15);
        t.checkExpect(GCD.gcdhelper(i3.getKey(), i3.getValue()), 6);
    }

    /**
     * Method to test stringwithnumber
     * 
     * @param t
     *            tester
     */
    void testStringWithNumber(Tester t) {
        t.checkExpect(StringWithNumber.swnhelper(s1.getKey(), s1.getValue()),
                "Bob 20");

        t.checkExpect(StringWithNumber.swnhelper(s2.getKey(), s2.getValue()),
                "haha 40");

        t.checkExpect(StringWithNumber.swnhelper(s3.getKey(), s3.getValue()),
                "bbb 50");
    }

    /**
     * Method to test balckheight
     * 
     * @param t
     *            tester
     */
    public void testBlackHeight(Tester t) {
        t.checkExpect(tree5.getColor(), "black");
        t.checkExpect(tree0.acceptRBT(new BlackHeight<Integer, String>()), 0);
        t.checkExpect(tree6.acceptRBT(new BlackHeight<Integer, String>()), 2);
        t.checkExpect(tree7.acceptRBT(new BlackHeight<Integer, String>()), 2);
        t.checkExpect(tree4.acceptRBT(new BlackHeight<Integer, String>()), 1);
        t.checkExpect(tree5.acceptRBT(new BlackHeight<Integer, String>()), 1);

    }

    /**
     * Method to test pathlengths
     * 
     * @param t
     *            tester
     */
    public void testPathLengths(Tester t) {
        t.checkExpect(tree0.acceptRBT(new PathLengths<Integer, String>())
                .size(), 0);

        t.checkExpect(tree7.acceptRBT(new PathLengths<Integer, String>())
                .size(), 4);
    }
}
