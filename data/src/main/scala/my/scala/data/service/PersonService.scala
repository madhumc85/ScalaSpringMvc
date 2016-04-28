package my.scala.data.service

import my.scala.data.dto.PersonDTO
import java.util.UUID
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.beans.factory.annotation.Autowired
import my.scala.data.dao.PersonDAO
import my.scala.data.model.Person

/**
 * Created by dionis on 2/2/14.
 */
trait PersonService {
  def create(dto: PersonDTO): PersonDTO

  def update(dto: PersonDTO): Option[PersonDTO]

  def find(id: UUID): Option[PersonDTO]

  def delete(id: UUID): Unit

  def findAll: Seq[PersonDTO]
}

@Service
@Transactional(readOnly = true)
class PersonServiceImpl extends PersonService {
  @Autowired var personDAO: PersonDAO = _

  @Transactional
  override def create(dto: PersonDTO): PersonDTO = {
    val entity = toEntity(dto)
    personDAO.persist(entity)
    toDTO(entity)
  }

  @Transactional
  override def update(dto: PersonDTO): Option[PersonDTO] = personDAO.find(dto.id) match {
    case Some(value) => {
      //change values
      value.username = dto.username
      personDAO.persist(value)
      Some(toDTO(value))
    }
    case _ => None
  }


  @Transactional
  override def delete(id: UUID): Unit = {
    personDAO.find(id) match {
      case Some(value) => personDAO.delete(value)
      case _ =>
    }
  }

  override def find(id: UUID): Option[PersonDTO] = personDAO.find(id) match {
    case Some(person) => Some(toDTO(person))
    case _ => None
  }

  override def findAll: Seq[PersonDTO] = personDAO.findAll.map(p => toDTO(p))

  private def toDTO(person: Person) = PersonDTO(person.id, person.username)

  private def toEntity(dto: PersonDTO) = {
    val person = new Person
    person.id = dto.id
    person.username = dto.username
    person
  }
}
