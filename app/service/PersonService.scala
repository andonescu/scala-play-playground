package service

import javax.inject.{Inject, Singleton}
import scala.concurrent.{Future, ExecutionContext}
import dal.inter.PersonRepository
import models.Person
import play.api.db.slick.DatabaseConfigProvider

import controllers.CreatePersonForm

@Singleton
class PersonService @Inject()(dbConfigProvider: DatabaseConfigProvider, personRepo: PersonRepository)(implicit ec: ExecutionContext) {

  def create(form: CreatePersonForm): Future[Person] =
    personRepo.create(form.name, form.age)

  def list(): Future[Seq[Person]] = personRepo.list()
}
