import java.util.Comparator;
import java.util.Iterator;

/**
 * Timing class is to test the time each method takes.
 *
 * @author Haonan Zhao
 * @version 2/14/2014
 */
public class Timing {

  Comparator<String> sbl;
  Comparator<String> srl;
  MyMap<String, Integer> normalMap;
  MyTree<String, Integer> sblTree;
  MyTree<String, Integer> srlTree;


  /**
   * Method to reset the map, and numbers
   */
  public void reset() {
    sbl = new StringByLex();
    srl = new StringReverseByLex();
    normalMap = MyMap.empty();
    sblTree = MyMap.empty(sbl);
    srlTree = MyMap.empty(srl);

  }


  /**
   * Build map and tree.
   * @param inputFile input file need to be tested.
   * @param numOfString number of strings in file to add.
   */
  public void buildTimeNoComparator(String inputFile, int numOfString) {
    long startTime = System.currentTimeMillis();
    Iterator<String> sit = new StringIterator(inputFile);
    int counter = 0;
    while (sit.hasNext() && counter < numOfString) {
      counter++;
      normalMap = normalMap.include(sit.next(), counter);
    }
    long endTime = System.currentTimeMillis();
    System.out.println(" build time is: " + (endTime - startTime));
    System.out.println("Size " + normalMap.size());
  }


  /**
   * Build map and tree.
   * @param inputFile input file need to be tested.
   * @param numOfString number of strings in file to add.
   */
  public void buildTimeStringByLex(String inputFile, int numOfString) {
    long startTime = System.currentTimeMillis();
    Iterator<String> sit = new StringIterator(inputFile);
    int counter = 0;
    while (sit.hasNext() && counter < numOfString) {
      counter++;
      sblTree = sblTree.include(sit.next(), counter);
    }
    long endTime = System.currentTimeMillis();
    System.out.println(" build time is: " + (endTime - startTime));
  }




  /**
   * Build map and tree.
   * @param inputFile input file need to be tested.
   * @param numOfString number of strings in file to add.
   */
  public void buildTimeStringReverseByLex(String inputFile, int numOfString) {
    long startTime = System.currentTimeMillis();
    Iterator<String> sit = new StringIterator(inputFile);
    int counter = 0;
    while (sit.hasNext() && counter < numOfString) {
      counter++;
      srlTree = srlTree.include(sit.next(), counter);
    }
    long endTime = System.currentTimeMillis();
    System.out.println(" build time is: " + (endTime - startTime));
  }

  /**
   * Method to print the time of iterate.
   */
  public void iteratorTime(MyMap<String, Integer> m) {
    long startTime = System.currentTimeMillis();
    m.iterator();
    long endTime = System.currentTimeMillis();
    System.out.println("iterator time: " + (endTime - startTime));
  }


  /**
   * Method to print the time of iterate.
   */
  public void iterateTime(MyMap<String, Integer> m) {
    long startTime = System.currentTimeMillis();
    Iterator<String> it = m.iterator();
    while (it.hasNext()) {
      it.next();
    }
    long endTime = System.currentTimeMillis();
    System.out.println("iterate time: " + (endTime - startTime));
  }

  /**
   * Method count contain time.
   * @param m the map or tree.
   * @param containsFile the input file.
   */
  public void containsTime(MyMap<String, Integer> m, String containsFile) {
    int countContainsTrue = 0;
    int countContains = 0;
    long startTime = System.currentTimeMillis();
    StringIterator si = new StringIterator(containsFile);
    for (String s : si) {
      if (m.containsKey(s)) {
        countContainsTrue++;
      }
      countContains++;
    }
    long endTime = System.currentTimeMillis();
    System.out.println(" contains timing: " + (endTime - startTime));
    System.out.println("NumberContained: " + countContainsTrue );
  }





  /**
   * Method to exam the time of build method
   * @param inputFile represent the file to be test
   */
  public void buildTimeStringByLexFile(String inputFile) {
    long startTime = System.currentTimeMillis();
    Iterator<String> sit = new StringIterator(inputFile);
    int counter = 0;
    while (sit.hasNext()) {
      counter++;
      sblTree = sblTree.include(sit.next(), counter);
    }
    long endTime = System.currentTimeMillis();
    System.out.println(" build time is: " + (endTime - startTime));
  }



  /**
   * Method to exam the time of build method
   * @param inputFile represent the file to be test
   */
  public void StringReverseByLexFile(String inputFile) {
    long startTime = System.currentTimeMillis();
    Iterator<String> sit = new StringIterator(inputFile);
    int counter = 0;
    while (sit.hasNext()) {
      counter++;
      srlTree = srlTree.include(sit.next(), counter);
    }
    long endTime = System.currentTimeMillis();
    System.out.println(" build time is: " + (endTime - startTime));
  }


  /**
   * Method to exam the time of build method
   * @param inputFile represent the file to be test
   */
  public void buildTimeNoComparatorFile(String inputFile) {
    long startTime = System.currentTimeMillis();
    Iterator<String> sit = new StringIterator(inputFile);
    int counter = 0;
    while (sit.hasNext()) {
      counter++;
      normalMap = normalMap.include(sit.next(), counter);
    }
    long endTime = System.currentTimeMillis();
    System.out.println(" build time is: " + (endTime - startTime));
  }


  /**
   * Run the timing test.
   */
  void run() {
    reset();
    System.out.println();
    System.out.println("****** lexicographically_ordered.txt - 2000 words******");

    // build time
    System.out.println(" --------------------");
    System.out.println("|   Build Time Test  |");
    System.out.println(" --------------------");

    System.out.print("[NoComparator]");
    buildTimeNoComparator("lexicographically_ordered.txt", 2000);

    System.out.print("[StringByLexComparator] ");
    buildTimeStringByLex("lexicographically_ordered.txt", 2000);

    System.out.print("[StringReverseByLex] ");
    buildTimeStringReverseByLex("lexicographically_ordered.txt", 2000);



    // iterator time
    System.out.println(" ----------------------");
    System.out.println("|  iterator Time Test  |");
    System.out.println(" ----------------------");

    System.out.print("[NoComparator]");
    iteratorTime(normalMap);
    System.out.print("[StringByLexComparator]");
    iteratorTime(sblTree);
    System.out.print("[StringReverseByLex]");
    iteratorTime(srlTree);

    // iterate time
    System.out.println(" --------------------");
    System.out.println("| iterate Time Test  |");
    System.out.println(" --------------------");

    System.out.print("[NoComparator]");
    iterateTime(normalMap);
    System.out.print("[StringByLexComparator]");
    iterateTime(sblTree);
    System.out.print("[StringReverseByLex]");
    iterateTime(srlTree);

    // Contains time
    System.out.println(" ----------------------");
    System.out.println("|  Contains Time Test  |");
    System.out.println(" ----------------------");

    System.out.print("[NoComparator]");
    containsTime(normalMap, "lexicographically_ordered.txt");
    System.out.print("[StringByLexComparator]");
    containsTime(sblTree, "lexicographically_ordered.txt");
    System.out.print("[StringReverseByLex]");
    containsTime(srlTree, "lexicographically_ordered.txt");





    reset();
    System.out.println();
    System.out.println("****** lexicographically_ordered.txt - 4000 words******");

    // build time
    System.out.println(" --------------------");
    System.out.println("|   Build Time Test  |");
    System.out.println(" --------------------");

    System.out.print("[NoComparator]");
    buildTimeNoComparator("lexicographically_ordered.txt", 4000);

    System.out.print("[StringByLexComparator] ");
    buildTimeStringByLex("lexicographically_ordered.txt", 4000);

    System.out.print("[StringReverseByLex] ");
    buildTimeStringReverseByLex("lexicographically_ordered.txt", 4000);



    // iterator time
    System.out.println(" ----------------------");
    System.out.println("|  iterator Time Test  |");
    System.out.println(" ----------------------");

    System.out.print("[NoComparator]");
    iteratorTime(normalMap);
    System.out.print("[StringByLexComparator]");
    iteratorTime(sblTree);
    System.out.print("[StringReverseByLex]");
    iteratorTime(srlTree);

    // iterate time
    System.out.println(" --------------------");
    System.out.println("| iterate Time Test  |");
    System.out.println(" --------------------");

    System.out.print("[NoComparator]");
    iterateTime(normalMap);
    System.out.print("[StringByLexComparator]");
    iterateTime(sblTree);
    System.out.print("[StringReverseByLex]");
    iterateTime(srlTree);

    // Contains time
    System.out.println(" ----------------------");
    System.out.println("|  Contains Time Test  |");
    System.out.println(" ----------------------");

    System.out.print("[NoComparator]");
    containsTime(normalMap, "lexicographically_ordered.txt");
    System.out.print("[StringByLexComparator]");
    containsTime(sblTree, "lexicographically_ordered.txt");
    System.out.print("[StringReverseByLex]");
    containsTime(srlTree, "lexicographically_ordered.txt");



    reset();
    System.out.println();
    System.out.println("****** lexicographically_ordered.txt - 8000 words******");

    // build time
    System.out.println(" --------------------");
    System.out.println("|   Build Time Test  |");
    System.out.println(" --------------------");

    System.out.print("[NoComparator]");
    buildTimeNoComparator("lexicographically_ordered.txt", 8000);

    System.out.print("[StringByLexComparator] ");
    buildTimeStringByLex("lexicographically_ordered.txt", 8000);

    System.out.print("[StringReverseByLex] ");
    buildTimeStringReverseByLex("lexicographically_ordered.txt", 8000);



    // iterator time
    System.out.println(" ----------------------");
    System.out.println("|  iterator Time Test  |");
    System.out.println(" ----------------------");

    System.out.print("[NoComparator]");
    iteratorTime(normalMap);
    System.out.print("[StringByLexComparator]");
    iteratorTime(sblTree);
    System.out.print("[StringReverseByLex]");
    iteratorTime(srlTree);

    // iterate time
    System.out.println(" --------------------");
    System.out.println("| iterate Time Test  |");
    System.out.println(" --------------------");

    System.out.print("[NoComparator]");
    iterateTime(normalMap);
    System.out.print("[StringByLexComparator]");
    iterateTime(sblTree);
    System.out.print("[StringReverseByLex]");
    iterateTime(srlTree);

    // Contains time
    System.out.println(" ----------------------");
    System.out.println("|  Contains Time Test  |");
    System.out.println(" ----------------------");

    System.out.print("[NoComparator]");
    containsTime(normalMap, "lexicographically_ordered.txt");
    System.out.print("[StringByLexComparator]");
    containsTime(sblTree, "lexicographically_ordered.txt");
    System.out.print("[StringReverseByLex]");
    containsTime(srlTree, "lexicographically_ordered.txt");



    reset();
    System.out.println();
    System.out.println("****** lexicographically_ordered.txt - 16000 words******");

    // build time
    System.out.println(" --------------------");
    System.out.println("|   Build Time Test  |");
    System.out.println(" --------------------");

    System.out.print("[NoComparator]");
    buildTimeNoComparator("lexicographically_ordered.txt", 16000);

    System.out.print("[StringByLexComparator] ");
    buildTimeStringByLex("lexicographically_ordered.txt", 16000);

    System.out.print("[StringReverseByLex] ");
    buildTimeStringReverseByLex("lexicographically_ordered.txt", 16000);



    // iterator time
    System.out.println(" ----------------------");
    System.out.println("|  iterator Time Test  |");
    System.out.println(" ----------------------");

    System.out.print("[NoComparator]");
    iteratorTime(normalMap);
    System.out.print("[StringByLexComparator]");
    iteratorTime(sblTree);
    System.out.print("[StringReverseByLex]");
    iteratorTime(srlTree);

    // iterate time
    System.out.println(" --------------------");
    System.out.println("| iterate Time Test  |");
    System.out.println(" --------------------");

    System.out.print("[NoComparator]");
    iterateTime(normalMap);
    System.out.print("[StringByLexComparator]");
    iterateTime(sblTree);
    System.out.print("[StringReverseByLex]");
    iterateTime(srlTree);

    // Contains time
    System.out.println(" ----------------------");
    System.out.println("|  Contains Time Test  |");
    System.out.println(" ----------------------");

    System.out.print("[NoComparator]");
    containsTime(normalMap, "lexicographically_ordered.txt");
    System.out.print("[StringByLexComparator]");
    containsTime(sblTree, "lexicographically_ordered.txt");
    System.out.print("[StringReverseByLex]");
    containsTime(srlTree, "lexicographically_ordered.txt");








    reset();
    System.out.println();
    System.out.println("****** random_order.txt - 2000 words******");

    // build time
    System.out.println(" --------------------");
    System.out.println("|   Build Time Test  |");
    System.out.println(" --------------------");

    System.out.print("[NoComparator]");
    buildTimeNoComparator("random_order.txt", 2000);

    System.out.print("[StringByLexComparator] ");
    buildTimeStringByLex("random_order.txt", 2000);

    System.out.print("[StringReverseByLex] ");
    buildTimeStringReverseByLex("random_order.txt", 2000);



    // iterator time
    System.out.println(" ----------------------");
    System.out.println("|  iterator Time Test  |");
    System.out.println(" ----------------------");

    System.out.print("[NoComparator]");
    iteratorTime(normalMap);
    System.out.print("[StringByLexComparator]");
    iteratorTime(sblTree);
    System.out.print("[StringReverseByLex]");
    iteratorTime(srlTree);

    // iterate time
    System.out.println(" --------------------");
    System.out.println("| iterate Time Test  |");
    System.out.println(" --------------------");

    System.out.print("[NoComparator]");
    iterateTime(normalMap);
    System.out.print("[StringByLexComparator]");
    iterateTime(sblTree);
    System.out.print("[StringReverseByLex]");
    iterateTime(srlTree);

    // Contains time
    System.out.println(" ----------------------");
    System.out.println("|  Contains Time Test  |");
    System.out.println(" ----------------------");

    System.out.print("[NoComparator]");
    containsTime(normalMap, "random_order.txt");
    System.out.print("[StringByLexComparator]");
    containsTime(sblTree, "random_order.txt");
    System.out.print("[StringReverseByLex]");
    containsTime(srlTree, "random_order.txt");





    reset();
    System.out.println();
    System.out.println("****** random_order.txt - 4000 words******");

    // build time
    System.out.println(" --------------------");
    System.out.println("|   Build Time Test  |");
    System.out.println(" --------------------");

    System.out.print("[NoComparator]");
    buildTimeNoComparator("random_order.txt", 4000);

    System.out.print("[StringByLexComparator] ");
    buildTimeStringByLex("random_order.txt", 4000);

    System.out.print("[StringReverseByLex] ");
    buildTimeStringReverseByLex("random_order.txt", 4000);



    // iterator time
    System.out.println(" ----------------------");
    System.out.println("|  iterator Time Test  |");
    System.out.println(" ----------------------");

    System.out.print("[NoComparator]");
    iteratorTime(normalMap);
    System.out.print("[StringByLexComparator]");
    iteratorTime(sblTree);
    System.out.print("[StringReverseByLex]");
    iteratorTime(srlTree);

    // iterate time
    System.out.println(" --------------------");
    System.out.println("| iterate Time Test  |");
    System.out.println(" --------------------");

    System.out.print("[NoComparator]");
    iterateTime(normalMap);
    System.out.print("[StringByLexComparator]");
    iterateTime(sblTree);
    System.out.print("[StringReverseByLex]");
    iterateTime(srlTree);

    // Contains time
    System.out.println(" ----------------------");
    System.out.println("|  Contains Time Test  |");
    System.out.println(" ----------------------");

    System.out.print("[NoComparator]");
    containsTime(normalMap, "random_order.txt");
    System.out.print("[StringByLexComparator]");
    containsTime(sblTree, "random_order.txt");
    System.out.print("[StringReverseByLex]");
    containsTime(srlTree, "random_order.txt");



    reset();
    System.out.println();
    System.out.println("****** random_order.txt - 8000 words******");

    // build time
    System.out.println(" --------------------");
    System.out.println("|   Build Time Test  |");
    System.out.println(" --------------------");

    System.out.print("[NoComparator]");
    buildTimeNoComparator("random_order.txt", 8000);

    System.out.print("[StringByLexComparator] ");
    buildTimeStringByLex("random_order.txt", 8000);

    System.out.print("[StringReverseByLex] ");
    buildTimeStringReverseByLex("random_order.txt", 8000);



    // iterator time
    System.out.println(" ----------------------");
    System.out.println("|  iterator Time Test  |");
    System.out.println(" ----------------------");

    System.out.print("[NoComparator]");
    iteratorTime(normalMap);
    System.out.print("[StringByLexComparator]");
    iteratorTime(sblTree);
    System.out.print("[StringReverseByLex]");
    iteratorTime(srlTree);

    // iterate time
    System.out.println(" --------------------");
    System.out.println("| iterate Time Test  |");
    System.out.println(" --------------------");

    System.out.print("[NoComparator]");
    iterateTime(normalMap);
    System.out.print("[StringByLexComparator]");
    iterateTime(sblTree);
    System.out.print("[StringReverseByLex]");
    iterateTime(srlTree);

    // Contains time
    System.out.println(" ----------------------");
    System.out.println("|  Contains Time Test  |");
    System.out.println(" ----------------------");

    System.out.print("[NoComparator]");
    containsTime(normalMap, "random_order.txt");
    System.out.print("[StringByLexComparator]");
    containsTime(sblTree, "random_order.txt");
    System.out.print("[StringReverseByLex]");
    containsTime(srlTree, "random_order.txt");



    reset();
    System.out.println();
    System.out.println("****** random_order.txt - 16000 words******");

    // build time
    System.out.println(" --------------------");
    System.out.println("|   Build Time Test  |");
    System.out.println(" --------------------");

    System.out.print("[NoComparator]");
    buildTimeNoComparator("random_order.txt", 16000);

    System.out.print("[StringByLexComparator] ");
    buildTimeStringByLex("random_order.txt", 16000);

    System.out.print("[StringReverseByLex] ");
    buildTimeStringReverseByLex("random_order.txt", 16000);



    // iterator time
    System.out.println(" ----------------------");
    System.out.println("|  iterator Time Test  |");
    System.out.println(" ----------------------");

    System.out.print("[NoComparator]");
    iteratorTime(normalMap);
    System.out.print("[StringByLexComparator]");
    iteratorTime(sblTree);
    System.out.print("[StringReverseByLex]");
    iteratorTime(srlTree);

    // iterate time
    System.out.println(" --------------------");
    System.out.println("| iterate Time Test  |");
    System.out.println(" --------------------");

    System.out.print("[NoComparator]");
    iterateTime(normalMap);
    System.out.print("[StringByLexComparator]");
    iterateTime(sblTree);
    System.out.print("[StringReverseByLex]");
    iterateTime(srlTree);

    // Contains time
    System.out.println(" ----------------------");
    System.out.println("|  Contains Time Test  |");
    System.out.println(" ----------------------");

    System.out.print("[NoComparator]");
    containsTime(normalMap, "random_order.txt");
    System.out.print("[StringByLexComparator]");
    containsTime(sblTree, "random_order.txt");
    System.out.print("[StringReverseByLex]");
    containsTime(srlTree, "random_order.txt");






    reset();
    System.out.println();
    System.out.println("****** reverse_ordered.txt - 2000 words******");

    // build time
    System.out.println(" --------------------");
    System.out.println("|   Build Time Test  |");
    System.out.println(" --------------------");

    System.out.print("[NoComparator]");
    buildTimeNoComparator("reverse_ordered.txt", 2000);

    System.out.print("[StringByLexComparator] ");
    buildTimeStringByLex("reverse_ordered.txt", 2000);

    System.out.print("[StringReverseByLex] ");
    buildTimeStringReverseByLex("reverse_ordered.txt", 2000);



    // iterator time
    System.out.println(" ----------------------");
    System.out.println("|  iterator Time Test  |");
    System.out.println(" ----------------------");

    System.out.print("[NoComparator]");
    iteratorTime(normalMap);
    System.out.print("[StringByLexComparator]");
    iteratorTime(sblTree);
    System.out.print("[StringReverseByLex]");
    iteratorTime(srlTree);

    // iterate time
    System.out.println(" --------------------");
    System.out.println("| iterate Time Test  |");
    System.out.println(" --------------------");

    System.out.print("[NoComparator]");
    iterateTime(normalMap);
    System.out.print("[StringByLexComparator]");
    iterateTime(sblTree);
    System.out.print("[StringReverseByLex]");
    iterateTime(srlTree);

    // Contains time
    System.out.println(" ----------------------");
    System.out.println("|  Contains Time Test  |");
    System.out.println(" ----------------------");

    System.out.print("[NoComparator]");
    containsTime(normalMap, "reverse_ordered.txt");
    System.out.print("[StringByLexComparator]");
    containsTime(sblTree, "reverse_ordered.txt");
    System.out.print("[StringReverseByLex]");
    containsTime(srlTree, "reverse_ordered.txt");





    reset();
    System.out.println();
    System.out.println("****** reverse_ordered.txt - 4000 words******");

    // build time
    System.out.println(" --------------------");
    System.out.println("|   Build Time Test  |");
    System.out.println(" --------------------");

    System.out.print("[NoComparator]");
    buildTimeNoComparator("reverse_ordered.txt", 4000);

    System.out.print("[StringByLexComparator] ");
    buildTimeStringByLex("reverse_ordered.txt", 4000);

    System.out.print("[StringReverseByLex] ");
    buildTimeStringReverseByLex("reverse_ordered.txt", 4000);



    // iterator time
    System.out.println(" ----------------------");
    System.out.println("|  iterator Time Test  |");
    System.out.println(" ----------------------");

    System.out.print("[NoComparator]");
    iteratorTime(normalMap);
    System.out.print("[StringByLexComparator]");
    iteratorTime(sblTree);
    System.out.print("[StringReverseByLex]");
    iteratorTime(srlTree);

    // iterate time
    System.out.println(" --------------------");
    System.out.println("| iterate Time Test  |");
    System.out.println(" --------------------");

    System.out.print("[NoComparator]");
    iterateTime(normalMap);
    System.out.print("[StringByLexComparator]");
    iterateTime(sblTree);
    System.out.print("[StringReverseByLex]");
    iterateTime(srlTree);

    // Contains time
    System.out.println(" ----------------------");
    System.out.println("|  Contains Time Test  |");
    System.out.println(" ----------------------");

    System.out.print("[NoComparator]");
    containsTime(normalMap, "reverse_ordered.txt");
    System.out.print("[StringByLexComparator]");
    containsTime(sblTree, "reverse_ordered.txt");
    System.out.print("[StringReverseByLex]");
    containsTime(srlTree, "reverse_ordered.txt");



    reset();
    System.out.println();
    System.out.println("****** reverse_ordered.txt - 8000 words******");

    // build time
    System.out.println(" --------------------");
    System.out.println("|   Build Time Test  |");
    System.out.println(" --------------------");

    System.out.print("[NoComparator]");
    buildTimeNoComparator("reverse_ordered.txt", 8000);

    System.out.print("[StringByLexComparator] ");
    buildTimeStringByLex("reverse_ordered.txt", 8000);

    System.out.print("[StringReverseByLex] ");
    buildTimeStringReverseByLex("reverse_ordered.txt", 8000);



    // iterator time
    System.out.println(" ----------------------");
    System.out.println("|  iterator Time Test  |");
    System.out.println(" ----------------------");

    System.out.print("[NoComparator]");
    iteratorTime(normalMap);
    System.out.print("[StringByLexComparator]");
    iteratorTime(sblTree);
    System.out.print("[StringReverseByLex]");
    iteratorTime(srlTree);

    // iterate time
    System.out.println(" --------------------");
    System.out.println("| iterate Time Test  |");
    System.out.println(" --------------------");

    System.out.print("[NoComparator]");
    iterateTime(normalMap);
    System.out.print("[StringByLexComparator]");
    iterateTime(sblTree);
    System.out.print("[StringReverseByLex]");
    iterateTime(srlTree);

    // Contains time
    System.out.println(" ----------------------");
    System.out.println("|  Contains Time Test  |");
    System.out.println(" ----------------------");

    System.out.print("[NoComparator]");
    containsTime(normalMap, "reverse_ordered.txt");
    System.out.print("[StringByLexComparator]");
    containsTime(sblTree, "reverse_ordered.txt");
    System.out.print("[StringReverseByLex]");
    containsTime(srlTree, "reverse_ordered.txt");



    reset();
    System.out.println();
    System.out.println("****** reverse_ordered.txt - 16000 words******");

    // build time
    System.out.println(" --------------------");
    System.out.println("|   Build Time Test  |");
    System.out.println(" --------------------");

    System.out.print("[NoComparator]");
    buildTimeNoComparator("reverse_ordered.txt", 16000);

    System.out.print("[StringByLexComparator] ");
    buildTimeStringByLex("reverse_ordered.txt", 16000);

    System.out.print("[StringReverseByLex] ");
    buildTimeStringReverseByLex("reverse_ordered.txt", 16000);



    // iterator time
    System.out.println(" ----------------------");
    System.out.println("|  iterator Time Test  |");
    System.out.println(" ----------------------");

    System.out.print("[NoComparator]");
    iteratorTime(normalMap);
    System.out.print("[StringByLexComparator]");
    iteratorTime(sblTree);
    System.out.print("[StringReverseByLex]");
    iteratorTime(srlTree);

    // iterate time
    System.out.println(" --------------------");
    System.out.println("| iterate Time Test  |");
    System.out.println(" --------------------");

    System.out.print("[NoComparator]");
    iterateTime(normalMap);
    System.out.print("[StringByLexComparator]");
    iterateTime(sblTree);
    System.out.print("[StringReverseByLex]");
    iterateTime(srlTree);

    // Contains time
    System.out.println(" ----------------------");
    System.out.println("|  Contains Time Test  |");
    System.out.println(" ----------------------");

    System.out.print("[NoComparator]");
    containsTime(normalMap, "reverse_ordered.txt");
    System.out.print("[StringByLexComparator]");
    containsTime(sblTree, "reverse_ordered.txt");
    System.out.print("[StringReverseByLex]");
    containsTime(srlTree, "reverse_ordered.txt");










    reset();
    System.out.println();
    System.out.println("****** hippooath.txt ******");

    // build time
    System.out.println(" --------------------");
    System.out.println("|   Build Time Test  |");
    System.out.println(" --------------------");

    System.out.print("[NoComparator]");
    buildTimeNoComparator("hippooath.txt", 2000);

    System.out.print("[StringByLexComparator] ");
    buildTimeStringByLex("hippooath.txt", 2000);

    System.out.print("[StringReverseByLex] ");
    buildTimeStringReverseByLex("hippooath.txt", 2000);



    // iterator time
    System.out.println(" ----------------------");
    System.out.println("|  iterator Time Test  |");
    System.out.println(" ----------------------");

    System.out.print("[NoComparator]");
    iteratorTime(normalMap);
    System.out.print("[StringByLexComparator]");
    iteratorTime(sblTree);
    System.out.print("[StringReverseByLex]");
    iteratorTime(srlTree);

    // iterate time
    System.out.println(" --------------------");
    System.out.println("| iterate Time Test  |");
    System.out.println(" --------------------");

    System.out.print("[NoComparator]");
    iterateTime(normalMap);
    System.out.print("[StringByLexComparator]");
    iterateTime(sblTree);
    System.out.print("[StringReverseByLex]");
    iterateTime(srlTree);

    // Contains time
    System.out.println(" ----------------------");
    System.out.println("|  Contains Time Test  |");
    System.out.println(" ----------------------");

    System.out.print("[NoComparator]");
    containsTime(normalMap, "hippooath.txt");
    System.out.print("[StringByLexComparator]");
    containsTime(sblTree, "hippooath.txt");
    System.out.print("[StringReverseByLex]");
    containsTime(srlTree, "hippooath.txt");



    reset();
    System.out.println();
    System.out.println("****** Confucius_The_Great_Learning.txt ******");

    // build time
    System.out.println(" --------------------");
    System.out.println("|   Build Time Test  |");
    System.out.println(" --------------------");

    System.out.print("[NoComparator]");
    buildTimeNoComparator("Confucius_The_Great_Learning.txt", 4000);

    System.out.print("[StringByLexComparator] ");
    buildTimeStringByLex("Confucius_The_Great_Learning.txt", 4000);

    System.out.print("[StringReverseByLex] ");
    buildTimeStringReverseByLex("Confucius_The_Great_Learning.txt", 4000);



    // iterator time
    System.out.println(" ----------------------");
    System.out.println("|  iterator Time Test  |");
    System.out.println(" ----------------------");

    System.out.print("[NoComparator]");
    iteratorTime(normalMap);
    System.out.print("[StringByLexComparator]");
    iteratorTime(sblTree);
    System.out.print("[StringReverseByLex]");
    iteratorTime(srlTree);

    // iterate time
    System.out.println(" --------------------");
    System.out.println("| iterate Time Test  |");
    System.out.println(" --------------------");

    System.out.print("[NoComparator]");
    iterateTime(normalMap);
    System.out.print("[StringByLexComparator]");
    iterateTime(sblTree);
    System.out.print("[StringReverseByLex]");
    iterateTime(srlTree);

    // Contains time
    System.out.println(" ----------------------");
    System.out.println("|  Contains Time Test  |");
    System.out.println(" ----------------------");

    System.out.print("[NoComparator]");
    containsTime(normalMap, "Confucius_The_Great_Learning.txt");
    System.out.print("[StringByLexComparator]");
    containsTime(sblTree, "Confucius_The_Great_Learning.txt");
    System.out.print("[StringReverseByLex]");
    containsTime(srlTree, "Confucius_The_Great_Learning.txt");



    reset();
    System.out.println();
    System.out.println("****** Apology_Plato.txt ******");

    // build time
    System.out.println(" --------------------");
    System.out.println("|   Build Time Test  |");
    System.out.println(" --------------------");

    System.out.print("[NoComparator]");
    buildTimeNoComparator("Apology_Plato.txt", 8000);

    System.out.print("[StringByLexComparator] ");
    buildTimeStringByLex("Apology_Plato.txt", 8000);

    System.out.print("[StringReverseByLex] ");
    buildTimeStringReverseByLex("Apology_Plato.txt", 8000);



    // iterator time
    System.out.println(" ----------------------");
    System.out.println("|  iterator Time Test  |");
    System.out.println(" ----------------------");

    System.out.print("[NoComparator]");
    iteratorTime(normalMap);
    System.out.print("[StringByLexComparator]");
    iteratorTime(sblTree);
    System.out.print("[StringReverseByLex]");
    iteratorTime(srlTree);

    // iterate time
    System.out.println(" --------------------");
    System.out.println("| iterate Time Test  |");
    System.out.println(" --------------------");

    System.out.print("[NoComparator]");
    iterateTime(normalMap);
    System.out.print("[StringByLexComparator]");
    iterateTime(sblTree);
    System.out.print("[StringReverseByLex]");
    iterateTime(srlTree);

    // Contains time
    System.out.println(" ----------------------");
    System.out.println("|  Contains Time Test  |");
    System.out.println(" ----------------------");

    System.out.print("[NoComparator]");
    containsTime(normalMap, "Apology_Plato.txt");
    System.out.print("[StringByLexComparator]");
    containsTime(sblTree, "Apology_Plato.txt");
    System.out.print("[StringReverseByLex]");
    containsTime(srlTree, "Apology_Plato.txt");
  }

  /**
   * Start point for the application.
   * @param args arguments.
   */
  public static void main(String[] args) {
    Timing test = new Timing();
    test.run();
  }

}
