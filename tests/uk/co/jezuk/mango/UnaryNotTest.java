package uk.co.jezuk.mango;

import junit.framework.*;

public class UnaryNotTest  extends TestCase
{
  public UnaryNotTest(String name) { super(name); }
  public static Test suite() { return new TestSuite(UnaryNotTest.class); }

  public void test1()
  {
    Predicate t = Predicates.Not(Predicates.True());
    assertEquals(false, t.test(new Integer(7)));
    assertEquals(false, t.test(t));
    assertEquals(false, t.test(new String("brainfart")));
  } // test1

  public void test2()
  {
    Predicate t = Predicates.Not(Predicates.False());
    assertEquals(true, t.test(new Integer(7)));
    assertEquals(true, t.test(t));
    assertEquals(true, t.test(new String("brainfart")));
  } // test2

} // UnaryNotTest
