package name.dargiri

/**
 * Created by dionis on 2/1/14.
 */
package object util {
  def toOption[T](obj: T) : Option[T] = obj match {
    case o: T => Some(o)
    case _ => None
  }
}
