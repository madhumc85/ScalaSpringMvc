package my.scala.data.dao

import my.scala.data.model.Person
import java.util.UUID
import org.springframework.stereotype.Repository
import scala.collection.JavaConversions._

/**
 * Created by dionis on 2/2/14.
 */
trait PersonDAO extends BaseDAO[Person, UUID] {
  override def entityClass: Class[Person] = classOf[Person]

  def findAll: Seq[Person]
}


@Repository
class PersonDAOImpl extends PersonDAO {
  override def findAll: Seq[Person] = entityManager
    .createQuery("select p from Person p", classOf[Person])
    .getResultList
}
