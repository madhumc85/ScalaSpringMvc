package my.scala.data.dao

import java.io.{Serializable => JSerial}
import my.scala.data.model.Model

import my.scala.util.toOption

/**
  * Created by dionis on 2/1/14.
  */
trait BaseDAO[T <: Model[ID], ID <: JSerial] extends EntityManagerAware {
  def persist(entity: T): Unit = {
    if (entity.isNew) {
      entity.assignId()
    }

    entityManager.persist(entity)
    entityManager.flush()
  }

  def find(id: ID): Option[T] = toOption(entityManager.find(entityClass, id))

  def entityClass: Class[T]

  def delete(entity: T): Unit = entityManager.remove(entity)
}
