package uk.co.jezuk.mango;

import junit.framework.*;

public class BinaryOrTest  extends TestCase
{
  public BinaryOrTest(String name) { super(name); }
  public static Test suite() { return new TestSuite(BinaryOrTest.class); }

    private static class t implements BinaryPredicate { public boolean test(Object x, Object y) { return true; } }
    private static class f implements BinaryPredicate { public boolean test(Object x, Object y) { return false; } }

  public void test1()
  {
    BinaryPredicate o = BinaryPredicates.Or(new t(), new t());
    assertEquals(true, o.test(null, null));
  } // test1

  public void test2()
  {
    BinaryPredicate o = BinaryPredicates.Or(new f(), new t());
    assertEquals(true, o.test(null, null));
  } // test2

  public void test3()
  {
    BinaryPredicate o = BinaryPredicates.Or(new t(), new f());
    assertEquals(true, o.test(null, null));
  } // test3

  public void test4()
  {
    BinaryPredicate o = BinaryPredicates.Or(new f(), new f());
    assertEquals(false, o.test(null, null));
  } // test4
} // BinaryOrTest
