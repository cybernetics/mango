package uk.co.jezuk.mango.iterators;

import java.util.Iterator;
import uk.co.jezuk.mango.Predicate;

/**
 * A <code>SelectingIterator</code> enumerates only those elements of a collection
 * that match the supplied <code>Predicate</code>.
 * 
 * @author Jez Higgins, jez@jezuk.co.uk
 */
public class SelectingIterator<T> implements Iterator<T>
{
  public SelectingIterator(Iterator<? extends T> iterator, Predicate<T> predicate)
  {
    iter_ = (Iterator<T>)iterator;
    pred_ = predicate;
  } // SelectingIterator

  public boolean hasNext()
  {
    next_ = null;
    while(iter_.hasNext() && next_ == null)
    {
      T candidate = iter_.next();
      if(pred_.test(candidate))
        next_ = candidate;
    } // while
    return next_ != null;
  } // hasNext

  public T next()
  {
    return next_;
  } // next

  public void remove()
  {
		iter_.remove();
  } // remove

  ////////////////////////
  private Iterator<T> iter_;
  private Predicate<T> pred_;
  private T next_;
} // SelectingIterator


