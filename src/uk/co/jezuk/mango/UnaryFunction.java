package uk.co.jezuk.mango;

/**
 * A <code>Generator</code> describes a function which takes no arguments - <code>fn()</code>.
 * It returns some <code>Object</code>, and may return the same object or different objects for
 * each invocation.  It can refer to local state, perform disk reads or writes, or whatever.  
 * @author Jez Higgins, jez@jezuk.co.uk
 * @version $Id$
 */
public interface UnaryFunction
{
  abstract public Object fn(Object x);
} // UnaryFunction

