package dal.inter

import scala.concurrent.Future
import com.google.inject.ImplementedBy
import dal.impl.PersonRepositoryImpl
import models.Person

@ImplementedBy(classOf[PersonRepositoryImpl])
trait PersonRepository {

  /**
    * Create a person with the given name and age.
    *
    * This is an asynchronous operation, it will return a future of the created person, which can be used to obtain the
    * id for that person.
    */
  def create(name: String, age: Int): Future[Person]


  /**
    * List all the people in the database.
    */
  def list(): Future[Seq[Person]]
}
