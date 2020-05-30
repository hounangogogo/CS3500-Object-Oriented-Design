import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The test class for MySet.
 */
public class MySetTest {

  private MySet emptySet;
  private MySet s1;
  private MySet s2;
  private MySet s3;
  private MySet s4;

  /**
   * Setup all the instance for tests.
   */
  @Before
  public void setup() {
    emptySet = new EmptySet();
    s1 = new ElementSet(1L, emptySet);
    s2 = new ElementSet(2L, s1);
    s3 = new ElementSet(3L, s2);
    s4 = new ElementSet(4L, s3);
  }

  @Test
  public void testEmpty() {
    assertEquals(0, MySet.size(MySet.empty()));
  }

  @Test
  public void testInsert() {
    assertEquals(1, MySet.size(MySet.insert(emptySet, 1L)));
    assertEquals(2, MySet.size(MySet.insert(s1, 2L)));
    assertEquals(3, MySet.size(MySet.insert(s2, 3L)));
    assertEquals(4, MySet.size(MySet.insert(s3, 4L)));
  }

  @Test
  public void testSize() {
    assertEquals(0, MySet.size(emptySet));
    assertEquals(1, MySet.size(s1));
    assertEquals(2, MySet.size(s2));
    assertEquals(3, MySet.size(s3));
    assertEquals(4, MySet.size(s4));
  }

  @Test
  public void testIsEmpty() {
    assertTrue(MySet.isEmpty(emptySet));
    assertFalse(MySet.isEmpty(s1));
  }

  @Test
  public void testContains() {
    assertFalse(MySet.contains(emptySet, 1L));
    assertTrue(MySet.contains(s1, 1L));
    assertTrue(MySet.contains(s2, 2L));
    assertTrue(MySet.contains(s3, 3L));
    assertTrue(MySet.contains(s4, 4L));
  }

  @Test
  public void isSubsetTest() {
    assertTrue(MySet.isSubset(emptySet, s1));
    assertTrue(MySet.isSubset(s1, s2));
    assertTrue(MySet.isSubset(s2, s3));
    assertTrue(MySet.isSubset(s3, s4));
  }

  @Test
  public void joinTest() {
    assertEquals(s1, MySet.join(emptySet, s1));
    assertEquals(s2, MySet.join(s1, s2));
    assertEquals(s3, MySet.join(s2, s3));
    assertEquals(s4, MySet.join(s3, s4));
  }


  @Test
  public void intersectTest() {
    assertEquals(emptySet, MySet.intersect(emptySet, s1));
    assertEquals(s1, MySet.intersect(s1, s2));
    assertEquals(s2, MySet.intersect(s2, s3));
    assertEquals(s3, MySet.intersect(s3, s4));
  }

  @Test
  public void replaceTest() {
    assertEquals(emptySet, MySet.replace(emptySet, 1L, 2L));
    assertFalse(MySet.contains(MySet.replace(s3, 3L, 1L), 3L));
    assertTrue(MySet.contains(MySet.replace(s3, 3L, 1L), 2L));
    assertTrue(MySet.contains(MySet.replace(s3, 3L, 1L), 1L));
    assertEquals(3, MySet.size(MySet.replace(s3, 3L, 1L)));
  }

  @Test
  public void toStringTest() {
    assertEquals("{...(This set contains 0 elements)...}", emptySet.toString());
    assertEquals("{...(This set contains 1 elements)...}", s1.toString());
    assertEquals("{...(This set contains 2 elements)...}", s2.toString());
  }

  @Test
  public void equalsTest() {
    assertNotEquals(s1, s2);
    MySet test = MySet.insert(MySet.empty(),1L);
    assertEquals(test, s1);
  }

  @Test
  public void hashCodeTest() {
    assertNotEquals(s1.hashCode(), s2.hashCode());
    MySet test = MySet.insert(MySet.empty(),1L);
    assertEquals(test.hashCode(), s1.hashCode());
  }
}