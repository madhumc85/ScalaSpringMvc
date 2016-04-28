package my.scala.data.model

import java.io.{Serializable => JSerial}
import org.apache.commons.lang3.builder.{HashCodeBuilder, EqualsBuilder}

/**
 * Created by dionis on 2/2/14.
 */

/**
 * Created by dionis on 2/2/14.
 */
trait Model[ID <: JSerial] {
  def id: ID
  def isNew: Boolean = id == null
  def assignId(): Unit

  def canEqual(other: Any): Boolean = other.isInstanceOf[Model[ID]]

  override def equals(other: Any): Boolean = other match {
    case that: Person =>
      (that canEqual this) &&
        new EqualsBuilder()
          .append(id, that.id).isEquals
    case _ => false
  }

  override def hashCode(): Int = new HashCodeBuilder().append(id).toHashCode
}

