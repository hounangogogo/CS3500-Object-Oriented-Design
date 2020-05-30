import java.util.Comparator;
import java.util.Iterator;
import mymap.MyMap;

/**
 * Timing class is to test the time each method takes
 * 
 * @author Haonan Zhao
 * @version 2/14/2014
 */
class Timing {
    /**
     * 
     * @param args
     *            String
     */
    public static void main(String[] args) {
        Timing test = new Timing();

        test.run();

    }

    // define comparator

    /** represent the contcantainsTrue */
    int countContainsTrue = 0;
    
    /** represent the contcantainsTrue */
    int countContains = 0;
    
    /** represent the StringByLex comparator */
    Comparator<String> c1 = new StringByLex();
   
    /** represent the StringReverseByLex comparator */
    Comparator<String> c2 = new StringReverseByLex();
   
    /** represent the empty map */
    MyMap<String, Integer> mm = MyMap.empty();

    /** represent the empty map with comparator c1 */
    MyMap<String, Integer> mm1 = MyMap.empty(c1);
   
    /** represent the empty map with comparator c2 */
    MyMap<String, Integer> mm2 = MyMap.empty(c2);
    
    /** represent the string iterator */
    StringIterator si = new StringIterator("contains_list.txt");

    
    /**
     * Method to reset the map, and numbers
     */
    public void reset() {
        mm = MyMap.empty();
        mm1 = MyMap.empty(c1);
        mm2 = MyMap.empty(c2);
        countContainsTrue = 0;
        si = new StringIterator("contains_list.txt");
    }

    
    /**
     * Method to build a tree which comparator is StringByLex
     * 
     * @param inputfile
     *            the file to be tested
     * @param numString
     *            the number of string
     */
    public void build(String inputfile, int numString) {
        Iterator<String> sit = new StringIterator(inputfile);
        int count = 0;
        while (count < numString && sit.hasNext()) {
            count++;
            mm1 = mm1.include(sit.next(), count);
        }
    }

    
    /**
     * Method to compute the build time
     * 
     * @param inputfile
     *            input file the file to be tested
     * @param numString
     *            numString the number of string
     */
    public void buildTime(String inputfile, int numString) {
        long t1 = System.currentTimeMillis();
        this.build(inputfile, numString);
        long t2 = System.currentTimeMillis();
        System.out.println(inputfile + "StringByLexComparator "
                + "build Timing:" + (t2 - t1));
        System.out.println("size " + mm1.size());
    }

    
    /**
     * Method to print the time of iterator
     */
    public void iterator() {

        long t3 = System.currentTimeMillis();
        mm1.iterator();
        long t4 = System.currentTimeMillis();

        System.out.println(
                "StringByLexComparator " + "iterator Timing:"
                + (t4 - t3));

    }

    
    
    /**
     * Method to print the time of iterate
     */
    public void iterate() {

        long t5 = System.currentTimeMillis();
        Iterator<String> it = mm1.iterator();
        while (it.hasNext()) {
            it.next();
        }
        long t6 = System.currentTimeMillis();
        System.out.println(
                "StringByLexComparator " + "iterate Timing:"
                + (t6 - t5));
    }

    /**
     * Method to represent the contains method
     */
    public void contains() {

        long t7 = System.currentTimeMillis();
        for (String s : si) {
            if (mm1.containsKey(s)) {
                countContainsTrue++;
            }
            countContains++;
        }
        long t8 = System.currentTimeMillis();

        System.out.println(
                "StringByLexComparator " + "contains Timing:"
                + (t8 - t7));
        System.out.println(
                "NumberContainted " + countContainsTrue);

    }

    
    
    
    
    
    /**
     * Method to check time of method 
     * with comparator StringReverseByLex
     * 
     * @param inputfile
     *            file to be tested
     * @param numString
     *            number of string
     */
    public void build2(String inputfile, int numString) {
        Iterator<String> sit = new StringIterator(inputfile);
        int count = 0;
        while (count < numString && sit.hasNext()) {
            count++;
            mm2 = mm2.include(sit.next(), count);
        }
    }

    /**
     * 
     * @param inputfile represent the input file
     * @param numString represent how many number to be count
     */
    public void buildTime2(String inputfile, int numString) {
        reset();
        long t1 = System.currentTimeMillis();
        this.build2(inputfile, numString);
        long t2 = System.currentTimeMillis();
        System.out.println(
                inputfile + "StringReverseByLex " + "build Timing:"
                + (t2 - t1));
        System.out.println("size " + mm2.size());
    }

    
    /**
     * Method to print the time of iterator
     */
    public void iterator2() {

        long t3 = System.currentTimeMillis();
        mm2.iterator();
        long t4 = System.currentTimeMillis();

        System.out.println(
                "StringByLexComparator " + "iterator Timing:"
                + (t4 - t3));
    }
    

    /**
     * Method to exam the time of iterate
     */
    public void iterate2() {

        long t5 = System.currentTimeMillis();

        Iterator<String> it = mm2.iterator();
        while (it.hasNext()) {
            it.next();
        }

        long t6 = System.currentTimeMillis();
        System.out.println(
                "StringReverseByLex " + "iterate Timing:"
                + (t6 - t5));
    }

    
    /**
     * Method to time the contains
     */
    public void contains2() {

        long t7 = System.currentTimeMillis();
        for (String s : si) {
            if (mm2.containsKey(s)) {
                countContainsTrue++;
            }
            countContains++;
        }
        long t8 = System.currentTimeMillis();

        System.out.println(
                "StringReverseByLex " + "contains Timing:"
                + (t8 - t7));
        System.out.println(
                "NumberContainted " + countContainsTrue);

    }

    
    
    
    /**
     * Method the build method with no comparator
     * @param inputfile represent the input file to be be test
     * @param numString represent how many string to be count
     */
    public void build3(String inputfile, int numString) {
        Iterator<String> sit = new StringIterator(inputfile);
        int count = 0;
        while (count < numString && sit.hasNext()) {
            count++;
            mm = mm.include(sit.next(), count);
        }
    }

    /**
     * Method to exam the time of build method
     * @param inputfile represent the file to be test
     * @param numString represent the string to be count
     */
    public void buildTime3(String inputfile, int numString) {
        reset();
        long t1 = System.currentTimeMillis();
        this.build3(inputfile, numString);
        long t2 = System.currentTimeMillis();
        System.out.println(
                inputfile + "NoComparator " + "build Timing:"
                + (t2 - t1));
        System.out.println("size " + mm.size());
    }

    /**
     * Method to test the time of iterator
     */
    public void iterator3() {

        long t3 = System.currentTimeMillis();
        mm.iterator();
        long t4 = System.currentTimeMillis();

        System.out.println(
                "NoComparator " + "iterator Timing:" + (t4 - t3));

    }

    
    /**
     * Method to test iterate time
     */
    public void iterate3() {

        long t5 = System.currentTimeMillis();

        Iterator<String> it = mm.iterator();
        while (it.hasNext()) {
            it.next();
        }

        long t6 = System.currentTimeMillis();
        System.out.println(
                "NoComparator " + "iterate Timing:" + (t6 - t5));
    }

    
    /**
     * Method to test time of contains
     */
    public void contains3() {

        long t7 = System.currentTimeMillis();
        for (String s : si) {
            if (mm.containsKey(s)) {
                countContainsTrue++;
            }
            countContains++;
        }
        long t8 = System.currentTimeMillis();

        System.out.println(
                "NoComparator " + "contains Timing:" + (t8 - t7));
        System.out.println(
                "NumberContainted " + countContainsTrue);

    }
    
    
    
    
    
    
    //////////////////////////////////////////////////////////////
    //Testing on classical literature 
    /**
     * Method the build method with no comparator
     * @param inputfile represent the input file to be be test
     */
    public void buildSBL(String inputfile) {
        Iterator<String> sit = new StringIterator(inputfile);
        int count = 0;
        while (sit.hasNext()) {
            count++;
            mm1 = mm1.include(sit.next(), count);
        }
    }

   
    /**
     * Method to exam the time of build method
     * @param inputfile represent the file to be test
     */
    public void buildTimeSBL(String inputfile) {
        reset();
        long t1 = System.currentTimeMillis();
        this.buildSBL(inputfile);
        long t2 = System.currentTimeMillis();
        System.out.println(
                inputfile + "StringByLux " + "build Timing:"
                + (t2 - t1));
        System.out.println("size " + mm1.size());
    }

    /**
     * Method to test the time of iterator
     */
    public void iteratorSBL() {

        long t3 = System.currentTimeMillis();
        mm1.iterator();
        long t4 = System.currentTimeMillis();

        System.out.println(
                "StringByLux " + "iterator Timing:" + (t4 - t3));

    }

    
    /**
     * Method to test iterate time
     */
    public void iterateSBL() {

        long t5 = System.currentTimeMillis();

        Iterator<String> it = mm1.iterator();
        while (it.hasNext()) {
            it.next();
        }

        long t6 = System.currentTimeMillis();
        System.out.println(
                "StringByLux " + "iterate Timing:" + (t6 - t5));
    }

    
    /**
     * Method to test time of contains
     */
    public void containsSBL() {

        long t7 = System.currentTimeMillis();
        for (String s : si) {
            if (mm1.containsKey(s)) {
                countContainsTrue++;
            }
            countContains++;
        }
        long t8 = System.currentTimeMillis();

        System.out.println(
                "StringByLux " + "contains Timing:" + (t8 - t7));
        System.out.println(
                "NumberContainted " + countContainsTrue);

    }
    
    
    /**
     * Method the build method with SRBL comparator
     * @param inputfile represent the input file to be be test
     */
    public void buildSRBL(String inputfile) {
        Iterator<String> sit = new StringIterator(inputfile);
        int count = 0;
        while (sit.hasNext()) {
            count++;
            mm2 = mm2.include(sit.next(), count);
        }
    }

   
    /**
     * Method to exam the time of build method
     * @param inputfile represent the file to be test
     */
    public void buildTimeSRBL(String inputfile) {
        reset();
        long t1 = System.currentTimeMillis();
        this.buildSRBL(inputfile);
        long t2 = System.currentTimeMillis();
        System.out.println(
                inputfile + "StringRevrseByLux " + "build Timing:"
                + (t2 - t1));
        System.out.println("size " + mm2.size());
    }

    /**
     * Method to test the time of iterator
     */
    public void iteratorSRBL() {

        long t3 = System.currentTimeMillis();
        mm2.iterator();
        long t4 = System.currentTimeMillis();

        System.out.println(
                "StringReverseByLux " + "iterator Timing:" + (
                        t4 - t3));

    }

    
    /**
     * Method to test iterate time
     */
    public void iterateSRBL() {

        long t5 = System.currentTimeMillis();

        Iterator<String> it = mm2.iterator();
        while (it.hasNext()) {
            it.next();
        }

        long t6 = System.currentTimeMillis();
        System.out.println(
                "StringReverseByLux " + "iterate Timing:" + (
                        t6 - t5));
    }

    
    /**
     * Method to test time of contains
     */
    public void containsSRBL() {

        long t7 = System.currentTimeMillis();
        for (String s : si) {
            if (mm2.containsKey(s)) {
                countContainsTrue++;
            }
            countContains++;
        }
        long t8 = System.currentTimeMillis();

        System.out.println(
                "StringReverseByLux " + "contains Timing:" + (
                        t8 - t7));
        System.out.println(
                "NumberContainted " + countContainsTrue);

    }
    
    
    
    
    
    /**
     * Method the build method with no comparator
     * @param inputfile represent the input file to be be test
     */
    public void buildno(String inputfile) {
        Iterator<String> sit = new StringIterator(inputfile);
        int count = 0;
        while (sit.hasNext()) {
            count++;
            mm = mm.include(sit.next(), count);
        }
    }

   
    /**
     * Method to exam the time of build method
     * @param inputfile represent the file to be test
     */
    public void buildTimeno(String inputfile) {
        reset();
        long t1 = System.currentTimeMillis();
        this.buildno(inputfile);
        long t2 = System.currentTimeMillis();
        System.out.println(
                inputfile + "noComparator " + "build Timing:"
                + (t2 - t1));
        System.out.println("size " + mm.size());
    }

    /**
     * Method to test the time of iterator
     */
    public void iteratorno() {

        long t3 = System.currentTimeMillis();
        mm.iterator();
        long t4 = System.currentTimeMillis();

        System.out.println(
                "noComparator " + "iterator Timing:" + (t4 - t3));

    }

    
    /**
     * Method to test iterate time
     */
    public void iterateno() {

        long t5 = System.currentTimeMillis();

        Iterator<String> it = mm.iterator();
        while (it.hasNext()) {
            it.next();
        }

        long t6 = System.currentTimeMillis();
        System.out.println(
                "noComparator " + "iterate Timing:" + (t6 - t5));
    }

    
    /**
     * Method to test time of contains
     */
    public void containsno() {

        long t7 = System.currentTimeMillis();
        for (String s : si) {
            if (mm.containsKey(s)) {
                countContainsTrue++;
            }
            countContains++;
        }
        long t8 = System.currentTimeMillis();

        System.out.println(
                "NoComparator " + "contains Timing:" + (t8 - t7));
        System.out.println(
                "NumberContainted " + countContainsTrue);

    }
    
    

 
    /**
     * Method to run the test
     */
    public void run() {

        System.out.println("StringByLex");
        System.out.println("lexicographically_ordered.txt");
        System.out.println("\n");
        reset();
        this.buildTime("lexicographically_ordered.txt", 2000);
        this.iterator();
        this.iterate();
        this.contains();

        System.out.println("\n");
        System.out.println("\n");
        reset();
        this.buildTime("lexicographically_ordered.txt", 4000);
        this.iterator();
        this.iterate();
        this.contains();

        System.out.println("\n");
        System.out.println("\n");
        reset();
        this.buildTime("lexicographically_ordered.txt", 8000);
        this.iterator();
        this.iterate();
        this.contains();

        System.out.println("\n");
        System.out.println("\n");
        reset();
        this.buildTime("lexicographically_ordered.txt", 16000);
        this.iterator();
        this.iterate();
        this.contains();

        
        System.out.println("\n");
        System.out.println("\n");
        reset();
        System.out.println("StringByLex");
        System.out.println("random_order.txt");
        System.out.println("\n");
        this.buildTime("random_order.txt", 2000);
        this.iterator();
        this.iterate();
        this.contains();

        System.out.println("\n");
        System.out.println("\n");
        reset();
        this.buildTime("random_order.txt", 4000);
        this.iterator();
        this.iterate();
        this.contains();

        System.out.println("\n");
        System.out.println("\n");
        reset();
        this.buildTime("random_order.txt", 8000);
        this.iterator();
        this.iterate();
        this.contains();

        System.out.println("\n");
        System.out.println("\n");
        reset();
        this.buildTime("random_order.txt", 16000);
        this.iterator();
        this.iterate();
        this.contains();

        
        System.out.println("\n");
        System.out.println("\n");
        reset();
        System.out.println("StringByLex");
        System.out.println("reverse_ordered.txt");
        System.out.println("\n");
        this.buildTime("reverse_ordered.txt", 2000);
        this.iterator();
        this.iterate();
        this.contains();

        
        System.out.println("\n");
        System.out.println("\n");
        reset();
        this.buildTime("reverse_ordered.txt", 4000);
        this.iterator();
        this.iterate();
        this.contains();

        
        System.out.println("\n");
        System.out.println("\n");
        reset();
        this.buildTime("reverse_ordered.txt", 8000);
        this.iterator();
        this.iterate();
        this.contains();

        System.out.println("\n");
        System.out.println("\n");
        reset();
        this.buildTime("reverse_ordered.txt", 16000);
        this.iterator();
        this.iterate();
        this.contains();

        System.out.println("-----------------------"
                + "----------------------------");

        System.out.println("\n");
        System.out.println("\n");
        System.out.println("StringReverseByLex");
        System.out.println("lexicographically_ordered.txt");
        reset();
        this.buildTime2("lexicographically_ordered.txt", 2000);
        this.iterator2();
        this.iterate2();
        this.contains2();

        System.out.println("\n");
        System.out.println("\n");
        reset();
        this.buildTime2("lexicographically_ordered.txt", 4000);
        this.iterator2();
        this.iterate2();
        this.contains2();

        
        System.out.println("StringReverseByLex");
        System.out.println("lexicographically_ordered.txt");
        System.out.println("\n");
        System.out.println("\n");
        reset();
        this.buildTime2("lexicographically_ordered.txt", 8000);
        this.iterator2();
        this.iterate2();
        this.contains2();

        System.out.println("\n");
        reset();
        System.out.println("StringReverseByLex");
        System.out.println("lexicographically_ordered.txt");
        System.out.println("\n");
        System.out.println("\n");
        this.buildTime2("lexicographically_ordered.txt", 16000);
        this.iterator2();
        this.iterate2();
        this.contains2();

        System.out.println("\n");
        System.out.println("\n");
        System.out.println("StringReverseByLex");
        System.out.println("random_order.txt");
        reset();
        this.buildTime2("random_order.txt", 2000);
        this.iterator2();
        this.iterate2();
        this.contains2();

        System.out.println("\n");
        System.out.println("\n");
        reset();
        this.buildTime2("random_order.txt", 4000);
        this.iterator2();
        this.iterate2();
        this.contains2();

        System.out.println("StringReverseByLex");
        System.out.println("random_order.txt");
        System.out.println("\n");
        System.out.println("\n");
        reset();
        this.buildTime2("random_order.txt", 8000);
        this.iterator2();
        this.iterate2();
        this.contains2();

        System.out.println("\n");
        reset();
        System.out.println("StringReverseByLex");
        System.out.println("random_order.txt");
        System.out.println("\n");
        System.out.println("\n");
        this.buildTime2("random_order.txt", 16000);
        this.iterator2();
        this.iterate2();
        this.contains2();

        // test reverse_ordered NoComparator
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("NoComparator");
        System.out.println("reverse_ordered.txt");
        System.out.println("\n");
        reset();
        this.buildTime2("reverse_ordered.txt", 2000);
        this.iterator2();
        this.iterate2();
        this.contains2();

        System.out.println("\n");
        System.out.println("\n");
        reset();
        this.buildTime2("reverse_ordered.txt", 4000);
        this.iterator2();
        this.iterate2();
        this.contains2();

        System.out.println("\n");
        System.out.println("\n");
        reset();
        this.buildTime2("reverse_ordered.txt", 8000);
        this.iterator2();
        this.iterate2();
        this.contains2();

        System.out.println("\n");
        System.out.println("\n");
        reset();
        this.buildTime2("reverse_ordered.txt", 16000);
        this.iterator2();
        this.iterate2();
        this.contains2();

        System.out.println("-----------------------"
                + "----------------------------");

        // test lexicographically NoComparator
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("NoComparator");
        System.out.println("lexicographically_ordered.txt");
        System.out.println("\n");
        reset();
        this.buildTime3("lexicographically_ordered.txt", 2000);
        this.iterator3();
        this.iterate3();
        this.contains3();

        System.out.println("\n");
        System.out.println("\n");
        reset();
        this.buildTime3("lexicographically_ordered.txt", 4000);
        this.iterator3();
        this.iterate3();
        this.contains3();

        System.out.println("\n");
        System.out.println("\n");
        reset();
        this.buildTime3("lexicographically_ordered.txt", 8000);
        this.iterator3();
        this.iterate3();
        this.contains3();

        System.out.println("\n");
        System.out.println("\n");
        reset();
        this.buildTime3("lexicographically_ordered.txt", 16000);
        this.iterator3();
        this.iterate3();
        this.contains3();

        // test reverse_ordered NoComparator
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("NoComparator");
        System.out.println("reverse_ordered.txt");
        System.out.println("\n");
        reset();
        this.buildTime3("reverse_ordered.txt", 2000);
        this.iterator3();
        this.iterate3();
        this.contains3();

        System.out.println("\n");
        System.out.println("\n");
        reset();
        this.buildTime3("reverse_ordered.txt", 4000);
        this.iterator3();
        this.iterate3();
        this.contains3();

        System.out.println("\n");
        System.out.println("\n");
        reset();
        this.buildTime3("reverse_ordered.txt", 8000);
        this.iterator3();
        this.iterate3();
        this.contains3();

        System.out.println("\n");
        System.out.println("\n");
        reset();
        this.buildTime3("reverse_ordered.txt", 16000);
        this.iterator3();
        this.iterate3();
        this.contains3();

        // test lexicographically NoComparator
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("NoComparator");
        System.out.println("random_order.txt");
        System.out.println("\n");
        reset();
        this.buildTime3("random_order.txt", 2000);
        this.iterator3();
        this.iterate3();
        this.contains3();

        System.out.println("\n");
        System.out.println("\n");
        reset();
        this.buildTime3("random_order.txt", 4000);
        this.iterator3();
        this.iterate3();
        this.contains3();

        System.out.println("\n");
        System.out.println("\n");
        reset();
        this.buildTime3("random_order.txt", 8000);
        this.iterator3();
        this.iterate3();
        this.contains3();

        System.out.println("\n");
        System.out.println("\n");
        reset();
        this.buildTime3("random_order.txt", 16000);
        this.iterator3();
        this.iterate3();
        this.contains3();
        
        System.out.println("-----------------------"
                + "----------------------------");
     
        
        /////////////////////////////////////
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("StringByLex");
        System.out.println("hippooath.txt");
        System.out.println("\n");
        reset();
        this.buildTimeSBL("hippooath.txt");
        this.iteratorSBL();
        this.iterateSBL();
        this.containsSBL();
        
        
        
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("StringByLex");
        System.out.println("Apology_Plato.txt");
        System.out.println("\n");
        reset();
        this.buildTimeSBL("Apology_Plato.txt");
        this.iteratorSBL();
        this.iterateSBL();
        this.containsSBL();
    
        
        
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("StringByLex");
        System.out.println("Confucius_The_Great_Learning.txt");
        System.out.println("\n");
        reset();
        this.buildTimeSBL("Confucius_The_Great_Learning.txt");
        this.iteratorSBL();
        this.iterateSBL();
        this.containsSBL();
       //////////////////////////////////////////////////
        
        
        
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("StringReverseByLex");
        System.out.println("hippooath.txt");
        System.out.println("\n");
        reset();
        this.buildTimeSRBL("hippooath.txt");
        this.iteratorSRBL();
        this.iterateSRBL();
        this.containsSRBL();
        
        
        
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("StringReverseByLex");
        System.out.println("Apology_Plato.txt");
        System.out.println("\n");
        reset();
        this.buildTimeSRBL("Apology_Plato.txt");
        this.iteratorSRBL();
        this.iterateSRBL();
        this.containsSRBL();
        
        
        
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("StringReverseByLex");
        System.out.println("Confucius_The_Great_Learning.txt");
        System.out.println("\n");
        reset();
        this.buildTimeSRBL("Confucius_The_Great_Learning.txt");
        this.iteratorSRBL();
        this.iterateSRBL();
        this.containsSRBL();
       ////////////////////////////////////////////////////
        
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("NoComparator");
        System.out.println("hippooath.txt");
        System.out.println("\n");
        reset();
        this.buildTimeno("hippooath.txt");
        this.iteratorno();
        this.iterateno();
        this.containsno();
        
        
        
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("No Comparator");
        System.out.println("Apology_Plato.txt");
        System.out.println("\n");
        reset();
        this.buildTimeno("Apology_Plato.txt");
        this.iteratorno();
        this.iterateno();
        this.containsno();
        
        
        
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("No Comparator");
        System.out.println("Confucius_The_Great_Learning.txt");
        System.out.println("\n");
        reset();
        this.buildTimeno("Confucius_The_Great_Learning.txt");
        this.iteratorno();
        this.iterateno();
        this.containsno();

    }

}
