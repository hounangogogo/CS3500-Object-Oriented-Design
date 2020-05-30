import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Test class for MyMap.
 */
public class MyMapTest {

  private MyMap<Integer, String> empty;
  private MyMap<Integer, String> m1; // {(1, "Alice")}
  private MyMap<Integer, String> m2; // {(1, "Alice"), (2, "Bob")}
  private MyMap<Integer, String> m3; // {(1, "Alice"), (2, "Bob"), (3, "Cindy")}


  @Before
  public void setup() {
    empty = new EmptyMap<>();
    m1 = new ElementMap<>(1, "Alice", empty);
    m2 = new ElementMap<>(2, "Bob", m1);
    m3 = new ElementMap<>(3, "Cindy", m2);

  }

  @Test
  public void testInclude() {
    assertFalse(empty.include(1, "Alice").isEmpty());
  }


  @Test
  public void testIsEmpty() {
    assertTrue(empty.isEmpty());
    assertFalse(m1.isEmpty());
  }

  @Test
  public void testSize() {
    assertEquals(0, empty.size());
    assertEquals(1, m1.size());
    assertEquals(2, m2.size());
    assertEquals(3, m3.size());
  }

  @Test
  public void testContainsKey() {
    assertFalse(empty.containsKey(1));
    assertTrue(m1.containsKey(1));
    assertTrue(m2.containsKey(1));
    assertTrue(m2.containsKey(2));
    assertTrue(m3.containsKey(1));
    assertTrue(m3.containsKey(2));
    assertTrue(m3.containsKey(3));
  }

  @Test
  public void testGet() {
    assertEquals("Alice", m1.get(1));
    assertEquals("Bob", m2.get(2));
    assertEquals("Cindy", m3.get(3));
  }

  @Test(expected = RuntimeException.class)
  public void testGetException() {
    empty.get(1);
    m1.get(10);
  }

  @Test
  public void testSet() {
    assertEquals(1, empty.set(1, "Alice").size());
    assertEquals("Alice", empty.set(1, "Alice").get(1));
    assertEquals(1, m1.set(1, "Ace").size());
    assertEquals("Ace", m1.set(1, "Ace").get(1));
  }

  @Test
  public void testToString() {
    assertEquals("{...(" + 0 + " key(s) mapped to value(s))...}", empty.toString());
    assertEquals("{...(" + 1 + " key(s) mapped to value(s))...}", m1.toString());
    assertEquals("{...(" + 2 + " key(s) mapped to value(s))...}", m2.toString());
    assertEquals("{...(" + 3 + " key(s) mapped to value(s))...}", m3.toString());
  }

  @Test
  public void testEquals() {
    MyMap<Integer, Integer> intMap = new EmptyMap<>();
    MyMap<Integer, String> m = new EmptyMap<>();
    MyMap<Integer, String> t1 = m.include(1, "Alice");
    assertEquals(t1, m1);
    assertEquals(intMap, m);
    assertNotEquals(t1, m2);
  }


  @Test
  public void testHashCode() {
    MyMap<Integer, String> m = new EmptyMap<>();
    MyMap<Integer, String> t1 = m.include(1, "Alice");
    assertEquals(m.hashCode(), empty.hashCode());
    assertEquals(m1.hashCode(), t1.hashCode());
  }

  @Test
  public void iteratorTest() {
    assertFalse(empty.iterator().hasNext());
    assertTrue(m1.iterator().hasNext());
    assertEquals(3, (int)m3.iterator().next());
  }


  @Test(expected = NoSuchElementException.class)
  public void testIteratorException() {
    empty.iterator().next();
  }

}