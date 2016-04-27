package name.dargiri.data.dao

import name.dargiri.data.SpringDbTest
import name.dargiri.data.model.Person
import java.util.UUID

/**
 * Created by dionis on 2/2/14.
 */
class PersonDAOImplTest extends SpringDbTest {
  val dao = new PersonDAOImpl
  dao.entityManager = em

  "Person" should "have id assigned when created" in {
    val entity = new Person()
    entity.username = "dionis"
    dao.persist(entity)

    assert(entity.id !== null)
  }

  it should "be found by id after persisting" in {
    val entity = new Person()
    entity.username = "dionis"
    dao.persist(entity)

    assert(entity.id !== null)
    flushAndClear()

    val found: Option[Person] = dao.find(entity.id)
    found should equal (Some(entity))
  }

  it should "not be found by id if not found" in {
    val entity = new Person()
    entity.username = "dionis"
    dao.persist(entity)

    assert(entity.id !== null)

    flushAndClear()

    val found: Option[Person] = dao.find(UUID.randomUUID())
    found should equal (None)
  }

  "Find all" should "return al persisted" in {
    val e1 = new Person
    val e2 = new Person
    dao.persist(e1)
    dao.persist(e2)

    flushAndClear()

    val result: Seq[Person] = dao.findAll

    result should have size (2)
    result should contain (e1)
    result should contain (e2)
  }
}
