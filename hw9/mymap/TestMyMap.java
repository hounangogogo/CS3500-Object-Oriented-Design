package mymap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

import tester.Tester;

/**
 * ExamplesMyMap is to make instances and tests for the methods
 * 
 * @author Haonan Zhao
 * @version 1/29/2014
 */
class ExamplesMyMap {

    /** represent an empty map */
    MyMap<Integer, String> m0 = MyMap.empty();

    /** represent map m1 */
    // [(1, "Garen")]
    MyMap<Integer, String> m1 = m0.include(1, "Garen");

    // [(2, "Irelia"), (1, "Garen")]
    /** represent map m2 */
    MyMap<Integer, String> m2 = m1.include(2, "Irelia");

    /** represent map m3 */
    // [(3, "Jax"), (2, "Irelia"), (1, "Garen")]
    MyMap<Integer, String> m3 = m2.include(3, "Jax");

    /** represent map m4 */
    // [(4, "Riven"),(3, "Jax"), (2, "Irelia"), (1, "Garen")]
    MyMap<Integer, String> m4 = m3.include(4, "Riven");

    /** represent map m5 */
    // [(5, "Zhang Wei"),(4, "Riven"),
    // (3, "Jax"), (2, "Irelia"), (1, "Garen")]
    MyMap<Integer, String> m5 = m3.include(5, "Zhang Wei");

    /** represent map m11 */
    MyMap<Integer, String> m11 = m0.include(1, "wang");

    /** represent map m12 */
    MyMap<Integer, String> m12 = m11.include(2, "RV");

    /** represent map m13 */
    MyMap<Integer, String> m13 = m12.include(1, "R");

    /** represent map m14 */
    MyMap<Integer, String> m14 = m13.include(2, "en");

    /** represent the comparator c */
    UsualIntegerComparator c = new UsualIntegerComparator();

    /** represent m24 with comparator c */
    MyMap<Integer, String> m24 = MyMap.empty(c);

    /** represent map m15 */
    MyMap<Integer, String> m15 = m0.include(1, "R");
    /** represent map m16 */
    MyMap<Integer, String> m16 = m15.include(2, "en");

    /** represent map m20 */
    MyMap<Integer, String> m20 = MyMap.empty(c);

    /** represent arrayList k1 empty list */
    ArrayList<Integer> k1 = new ArrayList<Integer>();

    /** represent arraylist k2 */
    ArrayList<Integer> k2 = new ArrayList<Integer>(Arrays.asList(3, 2, 1));

    /** represent arraylist k3 */
    ArrayList<Integer> k3 = new ArrayList<Integer>(Arrays.asList(1, 2, 3));

    /**
     * represent mymap visitor
     */
    MyMapVisitor<Integer, String> mv = new MyMapVisitor<Integer, String>() {
        /**
         * method to visit
         * 
         * @param i
         *            integer
         * @param s
         *            string
         * @return string
         */
        public String visit(Integer i, String s) {
            return s;
        }
    };

    /**
     * represent mv1
     */
    MyMapVisitor<Integer, String> mv1 = new MyMapVisitor<Integer, String>() {
        /**
         * method to visit
         * 
         * @param i
         *            integer
         * @param s
         *            string
         * @return
         */
        public String visit(Integer i, String s) {
            return s + s;
        }
    };

    /**
     * to test the arraylist method
     * 
     * @param t
     *            tester
     */
    void testArrayList(Tester t) {
        t.checkExpect(m3.keyArray(k1), k2);
        t.checkExpect(m3.iterator().hasNext(), true);
        t.checkExpect(m0.iterator().hasNext(), false);
        t.checkExpect(m3.iterator().next(), 3);

    }

    /**
     * to test empty method
     * 
     * @param t
     *            tester
     */
    void testEmpty(Tester t) {
        t.checkExpect(MyMap.empty(), m0);
        t.checkExpect(MyMap.empty(c), m20);

    }

    /**
     * to test isempty method
     * 
     * @param t
     *            tester
     */
    void testisEmpty(Tester t) {
        t.checkExpect(m0.isEmpty(), true);
        t.checkExpect(m2.isEmpty(), false);
        t.checkExpect(m3.isEmpty(), false);
        t.checkExpect(m4.empty().isEmpty(), true);
        t.checkException(new RuntimeException(
                "There is no element in the empty Map"), m0, "get", "2");

    }

    /**
     * to test the size method
     * 
     * @param t
     *            tester
     */
    void testsize(Tester t) {
        t.checkExpect(m0.size(), 0);
        t.checkExpect(m4.size(), 4);
        t.checkExpect(m4.include(0, "juhua").size(), 5);
        t.checkExpect(m4.include(1, "Garen").size(), 4);

    }

    /**
     * to test the containsKey method
     * 
     * @param t
     *            tester
     */
    void testContainsKey(Tester t) {
        t.checkExpect(m0.containsKey(1), false);
        t.checkExpect(m2.containsKey(2), true);
        t.checkExpect(m3.containsKey(3), true);
        t.checkExpect(m4.containsKey(4), true);
        t.checkExpect(m4.containsKey(5), false);
    }

    /**
     * to test the get method
     * 
     * @param t
     *            tester
     */
    void testGet(Tester t) {
        t.checkExpect(m1.get(1), "Garen");
        t.checkExpect(m2.get(2), "Irelia");
        t.checkExpect(m3.get(3), "Jax");
        t.checkExpect(m4.get(4), "Riven");
        t.checkExpect(m2.include(0, "ZhangWei").get(0), "ZhangWei");

        t.checkExpect(m2.include(0, "ZhangWei").get(2), "Irelia");
    }

    /**
     * to test the set method
     * 
     * @param t
     *            tester
     */
    void testSet(Tester t) {
        t.checkExpect(m0.set(400, "Fiora").containsKey(400), true);
        t.checkExpect(m4.set(400, "Fiora").containsKey(400), true);
        t.checkExpect(m0.set(90, "Fiora").size(), 1);
        t.checkExpect(m4.set(1, "Garen").size(), 4);
        t.checkExpect(m4.set(1, "Gare").get(1), "Gare");

    }

    /**
     * to test toString method
     * 
     * @param t
     *            tester
     */
    void testtoString(Tester t) {
        t.checkExpect(m0.toString(), "{...(" + m0.size()
                + " key(s) mapped to value(s))...}");
        t.checkExpect(m1.toString(), "{...(" + m1.size()
                + " key(s) mapped to value(s))...}");
        t.checkExpect(m4.toString(), "{...(" + m4.size()
                + " key(s) mapped to value(s))...}");

    }

    /**
     * to test equals method
     * 
     * @param t
     *            tester
     */
    void testEquals(Tester t) {
        t.checkExpect(m0.equals(m0), true);
        t.checkExpect(m2.equals(m1), false);
        t.checkExpect(m3.equals(m2), false);
        t.checkExpect(m4.equals(m4), true);
        t.checkExpect(m3.equals(m3), true);
        t.checkExpect(m2.equals(m4), false);
        t.checkExpect(m5.equals(m4), false);

        t.checkExpect(m0.equals("a"), false);
        t.checkExpect(m0.equals(null), false);
        t.checkExpect(m5.equals(null), false);
        t.checkExpect(m5.equals("a"), false);
        t.checkExpect(m2.include(3, "Jax").equals(m3), true);
        t.checkExpect(m2.include(3, "dd").equals(m3), false);
        t.checkExpect(m4.include(4, "rive").equals(m4), false);
        t.checkExpect(m0.equals(m1), false);
        t.checkExpect(m14.equals(m16), true);
        t.checkExpect(m16.equals(m14), true);

    }

    /**
     * to test hashCode method
     * 
     * @param t
     *            tester
     */
    void testhashCode(Tester t) {
        t.checkExpect(m0.hashCode() == m0.hashCode(), true);
        t.checkExpect(m1.hashCode() == m0.hashCode(), false);
        t.checkExpect(m4.hashCode() == m4.hashCode(), true);
        t.checkExpect(m4.include(1, "gg").hashCode() == m4.hashCode(), true);
    }

    /**
     * to test iterator method
     * 
     * @param t
     *            tester
     */
    void testIterator(Tester t) {
        t.checkExpect(m0.iterator().hasNext(), false);
        t.checkExpect(m4.iterator().hasNext(), true);

        t.checkExpect(m4.iterator().next(), 4);

        t.checkException(new NoSuchElementException(
                "There is no element in the empty list"),
                m0.iterator(), "next");

        t.checkException(new UnsupportedOperationException(
                "no element can be remove"), m0.iterator(),
                "remove");

        t.checkExpect(m3.iterator(c), 
                new MyIterator<Integer>(k3));

    }

    /**
     * to test getMap method
     * 
     * @param t
     *            tester
     */
    void testgetMap(Tester t) {
        t.checkException(
                new RuntimeException("Can not get map from empty map"), m0,
                "getMap");

    }

    /**
     * to test getKey method
     * 
     * @param t
     *            tester
     */
    void testgetKey(Tester t) {
        t.checkException(new RuntimeException(
                "There is no element in the empty Map"), m0, "getKey");
    }

    /**
     * to test KeyArray Method
     * 
     * @param t
     *            tester
     */
    void testKeyArray(Tester t) {
        t.checkExpect(m1.include(1, "Garan").iterator(), m1.iterator());
    }

    /**
     * to test the comparator
     * 
     * @param t
     *            tester
     */
    void testComparator(Tester t) {
        t.checkExpect(c.equals(c), true);
        t.checkExpect(c.equals(2), false);
        t.checkExpect(c.hashCode(), c.toString().hashCode());
        t.checkExpect(c.toString(), "UsualIntegerComparator");

    }

    /**
     * Method to test samekey
     * @param t
     *            tester
     */
    void testsameKey(Tester t) {
        t.checkExpect(m3.sameKey(m0), false);
    }

    /**
     * Method to test samevalue
     * @param t
     *            tester
     */
    void testsameValue(Tester t) {
        t.checkExpect(m3.sameValue(m0), false);
    }

    /**
     * Method to test visitor
     * @param t tester
     */
    void testvisitor(Tester t) {
        t.checkExpect(m0.equals(m0.accept(mv)));
        t.checkExpect(m2.equals(m2.accept(mv)));
        t.checkExpect(m3.equals(m3.accept(mv)));

        t.checkExpect(m3.accept(mv1).get(1), "GarenGaren");
        t.checkExpect(m3.accept(mv1).get(2), "IreliaIrelia");

        t.checkExpect(m3.accept(mv).size(), 3);

    }
    
  
    /**
     * Method getleft
     * @param t tester
     */
    void testgetLeft(Tester t) {
        t.checkException(new RuntimeException(
                "no left to get"), m0, "getLeft");
        t.checkException(new RuntimeException(
                "no left to get"), m1, "getLeft");
    }
    
    
    /**
     * Method getRight
     * @param t tester
     */
    void testgetRight(Tester t) {
        t.checkException(new RuntimeException(
                "no right to get"), m0, "getRight");
        t.checkException(new RuntimeException(
                "no right to get"), m3, "getRight");
    }
    
    
    /**
     * Method getvalue
     * @param t tester
     */
    void testgetValue(Tester t) {
        t.checkException(new RuntimeException(
                "There is no element in the empty Map"), m0, "getValue");
    }
    
    
    /**
     * Method getcolor
     * @param t tester
     */
    void testgetColor(Tester t) {
        t.checkException(new RuntimeException(
                "no color to get"), m0, "getColor");
        
        t.checkException(new RuntimeException(
                "no color to get"), m3, "getColor");
    }
    

}
