package mymap;

import java.util.*;

import tester.Tester;

/**
 * 
 * @author Haonan Zhao
 * @version 2/28/2014
 */
public class ExamplesBST {
    /** elements of this test */
    Comparator<Integer> c = new UsualIntegerComparator();
    /** elements of this test */
    String red = "red";
    /** elements of this test */
    String black = "black";

    /** elements of this test */
    BST<Integer, String> tree0 = new EmptyTree<Integer, String>(c);

    /** elements of this test */
    BST<Integer, String> tree1 = tree0.include(1, "a");
    /** elements of this test */
    BST<Integer, String> tree2 = new Node<Integer, String>(2, "b", tree1,
            tree0, c, "red");
    /** elements of this test */
    BST<Integer, String> tree33 = tree0.include(1, "aa");
    /** elements of this test */
    BST<Integer, String> tree3 = tree33.include(2, "b");
    /** elements of this test */
    BST<Integer, String> tree4 = tree0.include(4, "d");
    /** elements of this test */
    BST<Integer, String> tree5 = tree4.include(5, "e");
    /** elements of this test */
    BST<Integer, String> tree6 = tree5.include(6, "f");
    /** elements of this test */
    BST<Integer, String> tree7 = tree6.include(7, "g");

    /** elements of this test */
    BST<Integer, String> tmid = tree0.include(10, "a");
    /** elements of this test */
    BST<Integer, String> tl = tmid.include(7, "b");
    /** elements of this test */
    BST<Integer, String> tr = tl.include(11, "c");

    /** represent my map visitor */
    MyMapVisitor<Integer, String> mv = new MyMapVisitor<Integer, String>() {
        public String visit(Integer i, String s) {
            return s;
        }
    };

    /** represent arrayList k1 empty list */
    ArrayList<Integer> k0 = new ArrayList<Integer>();

    /** elements of this test */
    ArrayList<Integer> list1;

    /**
     * Method to test getComp
     * 
     * @param t
     *            tester
     */
    public void testgetComp(Tester t) {
        t.checkExpect(tree0.getComp(), c);
        t.checkExpect(tree2.getComp(), c);

    }

    /**
     * Method to test getleft and get right
     * 
     * @param t
     *            tester
     */
    public void testgetLeftRight(Tester t) {
        t.checkExpect(tree0.getLeft(), tree0);
        t.checkExpect(tree0.getRight(), tree0);
        t.checkExpect(tr.getLeft(), new Node<Integer, String>(7, "b", tree0,
                tree0, c, red));
        t.checkExpect(tr.getRight(), new Node<Integer, String>(11, "c", tree0,
                tree0, c, red));
    }

    /**
     * Method to test includ helper
     * 
     * @param t
     *            tester
     */
    public void testincludehelper(Tester t) {
        t.checkExpect(tree0.includehelper(1, "a"), new Node<Integer, String>(1,
                "a", tree0, tree0, c, red));
    }

    /**
     * Method to test isEmpty
     * 
     * @param t
     *            Tester
     */
    public void testgetisEmpty(Tester t) {

        t.checkExpect(tree0.isEmpty(), true);
        t.checkExpect(tree1.isEmpty(), false);
    }

    /**
     * Method to test size
     * 
     * @param t
     *            Tester
     */
    public void testsize(Tester t) {

        t.checkExpect(tree0.size(), 0);
        t.checkExpect(tree1.size(), 1);
    }

    /**
     * Method to test containsKey
     * 
     * @param t
     *            Tester
     */
    public void testcontainsKey(Tester t) {

        t.checkExpect(tree0.containsKey(1), false);
        t.checkExpect(tree1.containsKey(1), true);
        t.checkExpect(tree1.containsKey(2), false);
        t.checkExpect(tree6.containsKey(6), true);
    }

    /**
     * Method to test get
     * 
     * @param t
     *            Tester
     */
    public void testget(Tester t) {

        t.checkExpect(tree1.get(1).equals("a"), true);
        t.checkExpect(tree2.get(1).equals("a"), true);
        t.checkExpect(tree2.get(2).equals("b"), true);
        t.checkException(
                new RuntimeException("no key to get"), tree0,
                "get", 2);
    }

    /**
     * Method to test set
     * 
     * @param t
     *            Tester
     */
    public void testset(Tester t) {

        t.checkExpect(tree0.set(1, "a").size() == 1, true);
        t.checkExpect(tree0.set(1, "a"), new Node<Integer, String>(1, "a",
                tree0, tree0, c, red));
        t.checkExpect(tree1.set(2, "ss").size() == 2, true);
        t.checkExpect(tree2.set(2, "32").get(2).equals("32"), true);
    }

    /**
     * Method to test hashCode
     * 
     * @param t
     *            Tester
     */
    public void testhashCode(Tester t) {

        t.checkExpect(tree5.hashCode() == 4, false);
        t.checkExpect(tree7.hashCode() == 22, false);
        t.checkExpect(tree0.hashCode() == 3, false);
        t.checkExpect(tree0.hashCode() == 0, true);

    }

    /**
     * Method to test toString
     * 
     * @param t
     *            Tester
     */
    public void testtoString(Tester t) {

        t.checkExpect(tree0.toString(),
                "{...(0 key(s) mapped to value(s))...}");
        t.checkExpect(tree1.toString(),
                "{...(1 key(s) mapped to value(s))...}");
    }

    /**
     * Method to test getKey
     * 
     * @param t
     *            Tester
     */
    public void testgetKey(Tester t) {

        t.checkExpect(tree1.getKey(), 1);
        t.checkException(
                new RuntimeException("Can not get key from empty tree"), tree0,
                "getKey");
    }

    /**
     * Method to test getMap
     * 
     * @param t
     *            tester
     */
    public void testgetMap(Tester t) {
        t.checkException(
                new RuntimeException("Can not get map from empty tree"), tree0,
                "getMap");
    }

    /**
     * Method to test the equals
     * 
     * @param t
     *            Tester
     */
    public void testequals(Tester t) {

        t.checkExpect(tree2.equals(tree1), false);
        t.checkExpect(tree0 == null, false);
        t.checkExpect(tree2 == null, false);
        t.checkExpect(tree3.equals(tree1.set(1, "aa")), false);
        t.checkExpect(BST.empty().equals(tree0));
        t.checkExpect(tree1.equals(true), false);
        t.checkExpect(tree2.equals(32), false);
        t.checkExpect(tree2.equals(tree2), true);

    }

    /**
     * Method to test iterator
     * 
     * @param t
     *            Tester
     */
    public void testiterator(Tester t) {

        t.checkExpect(tree0.iterator().hasNext(), false);
        t.checkExpect(tree1.iterator().hasNext(), true);
        t.checkExpect(tree1.iterator().hasNext(), true);
        t.checkExpect(tree7.iterator().hasNext(), true);

        t.checkExpect(tree1.iterator(c).equals(new MyIterator<Integer>(list1)),
                false);

    }

    /**
     * Method to test Array
     * 
     * @param t
     *            tester
     */
    public void testkeyArray(Tester t) {
        t.checkExpect(tree0.keyArray(k0), k0);

    }

    /**
     * Method to test the samekey and samevalue
     * 
     * @param t
     *            tester
     */
    public void testsameKeyandValue(Tester t) {
        t.checkExpect(tree0.sameKey(tree0), true);
        t.checkExpect(tree0.sameValue(tree0), true);
        t.checkExpect(tree3.sameValue(tree3), true);
        t.checkExpect(tree3.sameKey(tree3), true);

    }

    /**
     * Method to test isRed
     * 
     * @param t
     *            tester
     */
    public void testisRed(Tester t) {
        t.checkExpect(tree0.isRed(), false);
        t.checkExpect(tree1.isRed(), false);
    }

    /**
     * Method to test getValue method
     * 
     * @param t
     *            tester
     */
    public void testgetValue(Tester t) {
        t.checkException(
                new RuntimeException("Can not get map from empty tree"), tree0,
                "getValue");
        t.checkExpect(tree1.getValue(), "a");
    }

    /**
     * Method to test equal using accept
     * 
     * @param t
     *            tester
     */
    public void testequal(Tester t) {
        t.checkExpect(tree0.equals(tree0.accept(mv)));
        t.checkExpect(tree3.equals(tree3.accept(mv)));
        t.checkExpect(tree4.equals(tree4.accept(mv)));

        t.checkExpect(tree2.accept(mv).get(1), "a");
        t.checkExpect(tree2.accept(mv).get(2), "b");

        t.checkExpect(tree2.accept(mv).size(), 2);
        t.checkExpect(tree3.accept(mv).size(), 2);

    }
    
    
    /**
     * Method getcolor
     * @param t tester
     */
    void testgetColor(Tester t) {
        t.checkExpect(tree0.getColor(), "black");
        t.checkExpect(tree2.getColor(), "red");
    }

}
