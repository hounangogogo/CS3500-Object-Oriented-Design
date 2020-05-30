/**
 * Simple example test program for MyList
 *
 * @author Haonan Zhao
 * @version 01/18/2014 to represent test for MyList
 */
public class TestMyList {

  /**
   * runs the tests
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    TestMyList test = new TestMyList();
    test.creation(); // create the example for tests
    test.accessors(); // test for static method
    test.dynamic(); // test for dynamic method
    test.summarize(); // summarize for the test
  }

  /**
   * Prints a summary of the tests.
   */
  private void summarize() {
    System.out.println();
    System.out.println(
            totalErrors + " errors found in " + totalTests
                    + " tests.");
  }

  private final String s1 = "a";
  private final String s2 = "b";
  private final String s3 = "c";

  private MyList l0; // '()
  private MyList l1; // '("a")
  private MyList l2; // '("b", "a")
  private MyList l3; // '("c", "b", "a")
  private MyList l4; // '("c", "b", "z")
  private MyList l5; // '("c")
  private MyList l6; // '("b", "c")
  private MyList l7; // '(a", "b", "c")

  /**
   * Creates some MyList objects
   */
  private void creation() {
    try {
      l0 = MyList.emptyList(); // '()
      l1 = MyList.add(l0, s1); // '("a")
      l2 = MyList.add(l1, s2); // '("b", "a")
      l3 = MyList.add(l2, s3); // '("c", "b", "a")

      l4 = MyList.add(l2, "z"); // '("c", "b", "z")

      l5 = MyList.add(l0, s3); // '("c")
      l6 = MyList.add(l5, s2); // '("b", "c")
      l7 = MyList.add(l6, s1); // '(a", "b", "c")

    } catch (Exception e) {
      assertTrue("creation", false);
    }
  }

  /**
   * Tests the accessors.
   */
  private void accessors() {
    try {
      // test isEmpty Method
      assertTrue("isEmpty:l0", MyList.isEmpty(l0));
      assertFalse("isEmpty:l2", MyList.isEmpty(l2));
      assertFalse("isEmpty:l1", MyList.isEmpty(l1));

      // test get Method
      assertTrue("get(1):l3",
              MyList.get(l3, 1).equals("b"));

      assertTrue("get(2):l3",
              MyList.get(l3, 2).equals("a"));

      assertTrue("get(3):l3",
              MyList.get(l3, 0).equals("c"));

      assertFalse("get(1):l3",
              MyList.get(l3, 1).equals("c"));

      assertFalse("get(0):l6",
              MyList.get(l6, 0).equals("c"));

      // test size Method
      assertTrue("size:l0", MyList.size(l0) == 0);
      assertTrue("size:l1", MyList.size(l1) == 1);
      assertTrue("size:l2", MyList.size(l2) == 2);
      assertTrue("size:l3", MyList.size(l3) == 3);
      assertFalse("size:l3", MyList.size(l3) == 2);
      assertFalse("size:l7", MyList.size(l3) == 2);

      // test set Method
      assertTrue("set(0, p):l3",
              MyList.get(MyList.set(l3, 0, "p"), 0)
                      .equals("p"));

      assertTrue("set(1, p):l3",
              MyList.get(MyList.set(l3, 1, "p"), 1)
                      .equals("p"));

      assertTrue("set(1, p):l3",
              MyList.get(MyList.set(l3, 1, "p"), 0)
                      .equals("c"));

      assertTrue("set(1, p):l3",
              MyList.get(MyList.set(l3, 1, "p"), 2)
                      .equals("a"));

      assertFalse("set(1, p):l3",
              MyList.get(MyList.set(l3, 1, "p"), 1)
                      .equals("b"));


      // Test contains Method
      assertFalse("contains(a):l0",
              MyList.contains(l0, "a"));

      assertFalse("contains(g):l3",
              MyList.contains(l0, "g"));

      assertTrue("contains(a):l1",
              MyList.contains(l1, "a"));

      assertTrue("contains(a):l2",
              MyList.contains(l2, "a"));

      assertTrue("contains(b):l2",
              MyList.contains(l2, "b"));

      assertTrue("contains(a):l3",
              MyList.contains(l3, "a"));

      assertTrue("contains(b):l3",
              MyList.contains(l3, "b"));

      assertTrue("contains(c):l3",
              MyList.contains(l3, "c"));

    } catch (Exception e) {
      assertTrue("accessors", false);
    }
  }

  /**
   * Tests the dynamic methods
   */
  private void dynamic() {
    try {
      // test toString method
      assertTrue("toString:l0",
              l0.toString().equals("[]"));

      assertFalse("toString:l0",
              l0.toString().equals(" "));

      assertTrue("toString:l3",
              l3.toString().equals("[c, b, a]"));

      assertFalse("toString:l0",
              l3.toString().equals("[a, b, c]"));

      // test equals method
      assertTrue("equals: l0",
              l0.equals(MyList.emptyList()));

      assertTrue("equals(l1): l1", l1.equals(l1));
      assertFalse("equals(null): l2", l2.equals(null));
      assertFalse("equals(a): l2", l2.equals("a"));
      assertFalse("equals(l4): l2", l2.equals(l4));

      // compare whether '("c", "b", "a")
      // and '("a", "b", "c") are equal
      assertFalse("equals(l3): l7", l7.equals(l3));


      // test hashCode method
      assertTrue("hashCode: l0",
              l0.hashCode() == l0.hashCode());

      assertTrue("hashCode: l1",
              l1.hashCode() == l1.hashCode());

      assertTrue("hashCode: l2",
              l2.hashCode() == l2.hashCode());

      assertFalse("hashCode: l3",
              l3.hashCode() == l4.hashCode());

      // compare'("c", "b", "a") and '("a", "b", "c")
      // hashCode
      assertFalse("hashCode: l7",
              l7.hashCode() == l3.hashCode());
    } catch (Exception e) {
      assertTrue("accessors", false);
    }
  }

  private int totalTests = 0; // tests run so far
  private int totalErrors = 0; // errors so far

  /**
   * Prints failure report if the result is not true.
   *
   * @param name   the name of the test
   * @param result the result to test
   */
  private void assertTrue(String name, boolean result) {
    if (!result) {
      System.out.println();
      System.out.println(
              "***** Test failed ***** " + name + ": "
                      + totalTests);
      totalErrors = totalErrors + 1;
    } else {
      System.out.println(
              "----- Test passed ----- " + name + ": "
                      + totalTests);
    }
    totalTests = totalTests + 1;
  }

  /**
   * Prints failure report if the result is not false.
   *
   * @param name   the name of the test
   * @param result the result to test
   */
  private void assertFalse(String name, boolean result) {
    assertTrue(name, !result);
  }

}
