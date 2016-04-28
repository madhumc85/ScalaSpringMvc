package my.scala.data.dao

import javax.persistence.{EntityManager, PersistenceContext}

/**
  * Created by dionis on 2/1/14.
  */
trait EntityManagerAware {
  @PersistenceContext
  var entityManager: EntityManager = _
}
