package uk.co.jezuk.mango.algorithms;

import uk.co.jezuk.mango.iterators.FilteredIterator;
import uk.co.jezuk.mango.unarypredicates.Not;
import java.util.Iterator;

/**
 * Searchs the sequence traversed by the Iterator and returns the first
 * object encountered for which the Predicate returns <code>false</code>.
 * @see Find
 * @see FindIf
 * @version $Id$
 */
public class FindIfNot
{
  static public Object execute(java.util.Iterator iterator, uk.co.jezuk.mango.Predicate test)
  {
    if((iterator == null) || (test == null))
      return null;  

    Iterator filter = new FilteredIterator(iterator, new Not(test));
    return filter.hasNext() ? filter.next() : null;
  } // execute

  private FindIfNot() { }
} // FindIfNot





