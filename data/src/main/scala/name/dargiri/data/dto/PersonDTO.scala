package my.scala.data.dto

import java.util.UUID

/**
 * Created by dionis on 2/2/14.
 */
case class PersonDTO(id: UUID, username: String) {
  def this() = this(null, null)
}
