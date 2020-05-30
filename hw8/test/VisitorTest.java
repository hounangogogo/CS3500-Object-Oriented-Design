import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;

/**
 * Visitor Tests
 */
public class VisitorTest {
  private Comparator<Integer> intComp;
  private MyMap<Integer, Integer> emptyMap;
  private MyTree<Integer, Integer> emptyTree;
  private MyTree<Integer, String> emptyStringTree;
  private MyTree<Integer, Integer> rbtree;
  private MyTree<Integer, String> sntree;

  @Before
  public void setup() {
    intComp = new UsualIntegerComparator();
    emptyMap = MyMap.empty();
    emptyTree = MyMap.empty(intComp);
    rbtree = emptyTree.include(15,20);
    emptyStringTree = MyMap.empty(intComp);
    sntree = emptyStringTree.include(15, "a");
  }

  @Test
  public void testGCD() {
    GCD gcd = new GCD();
    assertEquals(emptyMap, emptyMap.accept(gcd));
    assertEquals(emptyTree, emptyTree.accept(gcd));
    assertEquals(5, (int)gcd.visit(15, 20));
    assertEquals(emptyTree.include(15, 5), rbtree.accept(gcd));
  }

  @Test
  public void testStringWithNumber() {
    StringWithNumber swn = new StringWithNumber();
    assertEquals(swn.visit(15, "a"), "a 15");
    assertEquals(emptyStringTree.include(15, "a 15"),
            sntree.accept(swn));
  }

  @Test
  public void testPath() {
    PathLengths<Integer, Integer> pl = new PathLengths<>();
    assertEquals(0, emptyTree.acceptRBT(pl).size());
    assertEquals(1, rbtree.acceptRBT(pl).size());
    rbtree.include(14, 2);
    rbtree.include(13, 3);
    assertEquals(1, rbtree.acceptRBT(pl).size());

    MyTree<Integer, String> tree0 = new EmptyTree<>(intComp);
    MyTree<Integer, String> tree4 = tree0.include(4, "d");
    MyTree<Integer, String> tree5 = tree4.include(5, "e");
    MyTree<Integer, String> tree6 = tree5.include(6, "f");
    MyTree<Integer, String> tree7 = tree6.include(7, "g");
    assertEquals(4,
            tree7.acceptRBT(new PathLengths<>()).size());

  }


  @Test
  public void testBlackHeight() {
    assertEquals(0,
            (int) emptyTree.acceptRBT(new BlackHeight<>()));

    assertEquals(0,
            (int) rbtree.acceptRBT(new BlackHeight<>()));

    MyTree<Integer, String> tree0 = new EmptyTree<>(intComp);
    MyTree<Integer, String> tree4 = tree0.include(4, "d");
    MyTree<Integer, String> tree5 = tree4.include(5, "e");
    MyTree<Integer, String> tree6 = tree5.include(6, "f");
    MyTree<Integer, String> tree7 = tree6.include(7, "g");
    assertEquals(3,
            (int) tree7.acceptRBT(new BlackHeight<>()));

  }
}
