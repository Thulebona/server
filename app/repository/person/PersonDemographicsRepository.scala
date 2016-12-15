package repository.person

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
//import com.websudos.phantom.column.PrimitiveColumn
import com.websudos.phantom.dsl._
import com.websudos.phantom.reactivestreams._
import com.websudos.phantom.keys.PartitionKey
import conf.connection.DataConnection
import domain.person.PersonDemographics

import scala.concurrent.Future

/**
 * Created by hashcode on 2015/12/17.
 */
class PersonDemographicsRepository extends CassandraTable[PersonDemographicsRepository, PersonDemographics] {

  object personId extends StringColumn(this) with PartitionKey[String]

  object id extends StringColumn(this) with PrimaryKey[String]

  object genderId extends StringColumn(this)

  object raceId extends StringColumn(this)

  object dateOfBirth extends DateColumn(this)

  object maritalStatusId extends StringColumn(this)

  object numberOfDependencies extends IntColumn(this)

  object date extends DateColumn(this)

  object state extends StringColumn(this)

  override def fromRow(r: Row): PersonDemographics = {
    PersonDemographics(
      id(r),
      personId(r),
      genderId(r),
      raceId(r),
      dateOfBirth(r),
      maritalStatusId(r),
      numberOfDependencies(r),
      date(r),
      state(r))
  }
}

object PersonDemographicsRepository extends PersonDemographicsRepository with RootConnector {
  override lazy val tableName = "pdemog"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(demographics: PersonDemographics): Future[ResultSet] = {
    insert
      .value(_.personId, demographics.personId)
      .value(_.id, demographics.id)
      .value(_.genderId, demographics.genderId)
      .value(_.raceId, demographics.raceId)
      .value(_.dateOfBirth, demographics.dateOfBirth)
      .value(_.date, demographics.date)
      .value(_.maritalStatusId, demographics.maritalStatusId)
      .value(_.numberOfDependencies, demographics.numberOfDependencies)
      .value(_.state, demographics.state)
      .future()
  }

  def findById(personId: String, id: String): Future[Option[PersonDemographics]] = {
    select.where(_.personId eqs personId).and(_.id eqs id).one()
  }

  def findPersonDemographics(personId: String): Future[Seq[PersonDemographics]] = {
    select.where(_.personId eqs personId).fetchEnumerator() run Iteratee.collect()
  }

}

