package name.dargiri.data

import org.scalatest.{OptionValues, BeforeAndAfter, Matchers, FlatSpec}
import org.springframework.test.context.{TestContextManager, ContextConfiguration}
import javax.persistence.{PersistenceContext, EntityManager}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.{TransactionStatus, PlatformTransactionManager}
import org.springframework.transaction.support.DefaultTransactionDefinition

/**
 * Created by dionis on 2/1/14.
 */
@ContextConfiguration(locations = Array("classpath:test-config.xml"))
abstract class SpringDbTest extends FlatSpec with Matchers with BeforeAndAfter {
  @PersistenceContext
  val em: EntityManager = null
  @Autowired
  private val txManager: PlatformTransactionManager = null

  new TestContextManager(getClass).prepareTestInstance(this)

  private var transaction: TransactionStatus = _

  before {
    println("Creating transaction")
    transaction = txManager.getTransaction(new DefaultTransactionDefinition())
    println("Transaction created")
  }

  after {
    println("Rolling back transaction")
    txManager.rollback(transaction)
    println("Transaction roled back")
  }

  def flushAndClear() : Unit = {
    em.flush()
    em.clear()
  }
}
