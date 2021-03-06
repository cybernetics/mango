package uk.co.jezuk.mango;

import junit.framework.*;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class TeeIteratorTest extends TestCase
{
  public TeeIteratorTest(String name) { super(name); }
  public static Test suite() { return new TestSuite(TeeIteratorTest.class); }

  public void test1()
  {
    String[] strings = new String[] { "one", "two", "three" };
    List<Iterator<String>> iters = Iterators.TeeIterator(Iterators.ArrayIterator(strings), 3);

    assertEquals(3, iters.size());

    for(Iterator<String> i : iters)
    {
      assertTrue(i.hasNext());
      assertEquals("one", i.next());
      assertTrue(i.hasNext());
      assertEquals("two", i.next());
      assertTrue(i.hasNext());
      assertEquals("three", i.next());
      assertFalse(i.hasNext());
    } // for ...
  } // test1

  public void test2()
  {
    List<String> listOfStrings = new ArrayList<String>();
    listOfStrings.add("hello");
    listOfStrings.add("there");
    listOfStrings.add("chummy");

    List<Iterator<String>> iters = Iterators.TeeIterator(listOfStrings, 4);

    assertEquals(4, iters.size());

    for(Iterator<String> i : iters)
    {
      assertTrue(i.hasNext());
      assertEquals("hello", i.next());
      assertTrue(i.hasNext());
      assertEquals("there", i.next());
      assertTrue(i.hasNext());
      assertEquals("chummy", i.next());
      assertFalse(i.hasNext());
    } // for ...
  } // test2
} // TeeIteratorTest