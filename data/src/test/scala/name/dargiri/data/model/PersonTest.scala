package my.scala.data.model

import org.scalatest.{Matchers, FlatSpec, FunSuite}
import java.util.UUID

/**
 * Created by dionis on 2/2/14.
 */
class PersonTest extends FlatSpec with Matchers {
  "Person" should "should be equal when have same id" in {
    val pair = personPairWithSameId
    pair._1 should equal(pair._2)
  }

  def personPairWithSameId = {
    val id = UUID.randomUUID()
    val p1 = new Person
    p1.id = id
    val p2 = new Person
    p2.id = id
    Pair(p1, p2)
  }

  it should "have the same hashCode when have same id" in {
    val pair = personPairWithSameId
    pair._1.hashCode() should equal(pair._2.hashCode())
  }
}
