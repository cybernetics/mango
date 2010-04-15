package uk.co.jezuk.mango;

import java.util.Collection;
import java.util.Iterator;

import uk.co.jezuk.mango.iterators.ArrayIterator;

import uk.co.jezuk.mango.unarypredicates.*;

/**
 * <strong>The Mango Library Unary Predicates</strong>
 * <br/><br/>
 * A <code>{@link Predicate}</code> is a special form of a <code>Function</code>, 
 * whose result represents the truth or otherwise of some condition.
 * Returns <code>true</code> if the condition the Predicate tests for 
 * is satisfied, <code>false</code> otherwise.
 * @see Predicate
 * @author Jez Higgins, jez@jezuk.co.uk
 */
public class Predicates
{
  ///////////////////////////////////////////////////////
  // Unary Predicates
  /**
   * A <code>Predicate</code> which always returns <code>true</code>
   */
  static public <T> Predicate<T> True() 
  { 
    return (Predicate<T>)True.INSTANCE; 
  } // True
 
  /**
   * A <code>Predicate</code> which always returns <code>false</code>
   */
  static public <T> Predicate<T> False() 
  { 
    return (Predicate<T>)False.INSTANCE;
  } // False

  /** 
   * A <code>Predicate</code> which returns a precomputed constant value
   */
  static public <T> Predicate<T> Constant(boolean constant)
  {

    return constant ? (Predicate<T>)True.INSTANCE : (Predicate<T>)False.INSTANCE;
  } // Constant

  /**
   * A <code>Predicate</code> which is the logical negation of some other <code>Predicate</code>.  If <code>n</code>
   * is a <code>Not</code> object, and <code>pred</code> is the <code>Predicate</code> it was constructed with,
   * then <code>n.test(x)</code> returns <code>!pred.test(x)</code>.
   */
  static public <T> Predicate<T> Not(Predicate<T> pred) { return new Not<T>(pred); }

  /**
   * A <code>Predicate</code> which returns the logical AND of two other <code>Predicate</code>.  If <code>a</code>
   * is an <code>And</code> object, constructed with <code>pred1</code> and <code>pred2</code>, then 
   * <code>a.test(x)</code> returns <code>pred1.test(x) && pred2.test(x)</code>
   */
  static public <T> Predicate<T> And(Predicate<T> pred1, Predicate<T> pred2) { return new And<T>(pred1, pred2); }

  /**
   * A <code>Predicate<T></code> which returns the logical OR of two other <code>Predicate<T></code>.  If <code>a</code>
   * is an <code>Or</code> object, constructed with <code>pred1</code> and <code>pred2</code>, then 
   * <code>a.test(x)</code> returns <code>pred1.test(x) || pred2.test(x)</code>
   */
  static public <T> Predicate<T> Or(Predicate<T> pred1, Predicate<T> pred2) { return new Or<T>(pred1, pred2); }

  /**
   * A <code>Predicate</code> which returns <code>true</code> if all of the supplied <code>Predicate</code>s are true.  It is an AND generalised to any number of arguments.
   */
  static public <T> Predicate<T> All(Object... preds) { return All(new ArrayIterator<Predicate<T>>(preds)); }
  static public <T> Predicate<T> All(Collection<Predicate<T>> preds) { return All(preds.iterator()); }
  static public <T> Predicate<T> All(Iterator<Predicate<T>> preds) { return new All<T>(preds); }

  /**
   * A <code>Predicate<T></code> which checks whether the passed object 
   * reference is null.
   */
  static public <T> Predicate<T> IsNull()
  {
    return (Predicate<T>)IsNull.INSTANCE;
  } // IsNull

  /**
   * A <code>Predicate<T></code> which checks whether the passed object 
   * reference is not null.
   */
  static public <T> Predicate<T> NotNull()
  {
    return (Predicate<T>)NotNull.INSTANCE;
  } // NotNull

  //////////////////////////////////
  private Predicates() { }
} // Predicates


