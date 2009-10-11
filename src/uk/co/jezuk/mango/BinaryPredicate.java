package uk.co.jezuk.mango;

/**
 * A <code>BinaryPredicate</code> is some function taking two arguments -
 * <code>fn(x, y)</code> and returning the result of some test.
 * It returns <code>true</code> if the conditions of the test are satisfied,
 * <code>false</code> otherwise
 * @author Jez Higgins, jez@jezuk.co.uk
 */
public interface BinaryPredicate<T>
{
  public boolean test(T x, T y);
} // BinaryPredicate

