import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Class test binary tree structure.
 */
public class MyTreeTest {
  private EmptyTree<Integer, String> emptyTree;
  private Node<Integer, String> root;


  private Comparator<Integer> comp = new UsualIntegerComparator();

  @Before
  public void setup() {
    emptyTree = MyMap.empty(comp);
    root = new Node<>(3, "Candy", emptyTree, emptyTree, comp, false);

  }

  @Test
  public void testInclude() {
    assertEquals(1, emptyTree.include(1, "Alice").size());
    assertEquals(2, root.include(2, "Bob").size());
    assertEquals(2, root.include(2, "bill").size());
  }

  @Test
  public void testIsEmpty() {
    assertTrue(emptyTree.isEmpty());
    assertFalse(root.isEmpty());
  }

  @Test
  public void testSize() {
    assertEquals(0, emptyTree.size());
    assertEquals(1, root.size());
  }

  @Test
  public void testContainsKey() {
    assertTrue(root.containsKey(3));
    assertFalse(emptyTree.containsKey(3));
    assertFalse(root.containsKey(1));
    assertTrue(root.include(1, "Alice").containsKey(1));
  }

  @Test
  public void testGet() {
    assertEquals("Candy", root.get(3));
  }

  @Test(expected = RuntimeException.class)
  public void testGetException() {
    emptyTree.get(2);
  }

  @Test
  public void testSet() {
    assertEquals(1, emptyTree.set(3, "Candy").size());
    assertEquals(1, root.set(3, "Cat").size());
    assertEquals(2, root.set(4, "Danny").size());
  }

  @Test
  public void testEquals() {
    assertEquals(root, emptyTree.set(3, "Candy"));
  }

  @Test
  public void testIterator() {
    assertTrue(root.iterator().hasNext());
    assertEquals(3, (int)root.iterator().next());
    assertFalse(emptyTree.iterator().hasNext());
  }
}
