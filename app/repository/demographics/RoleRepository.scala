package repository.demographics

import com.datastax.driver.core.{ResultSet, Row}
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.dsl._
import com.websudos.phantom.iteratee.Iteratee
import com.websudos.phantom.keys.PartitionKey
import conf.connection.DataConnection

import domain.demographics.Role

import scala.concurrent.Future

/**
 * Created by hashcode on 2015/04/17.
 */
//id: String, name: String, description: String,state:String
sealed class RoleRepository extends CassandraTable[RoleRepository, Role] {

  object id extends StringColumn(this) with PartitionKey[String]

  object name extends StringColumn(this)

  object description extends StringColumn(this)

  object state extends StringColumn(this)

  override def fromRow(row: Row): Role = {
    Role(
      id(row),
      name(row),
      description(row),
      state(row)
    )
  }
}

object RoleRepository extends RoleRepository with RootConnector {
  override lazy val tableName = "roles"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session


  def save(role: Role): Future[ResultSet] = {
    insert
      .value(_.id,role.id)
      .value(_.name, role.name)
      .value(_.description, role.description)
      .value(_.state, role.state)
      .future()
  }

  def getRoleById(id: String): Future[Option[Role]] = {
    select.where(_.id eqs id).one()
  }

  def getRoles: Future[Seq[Role]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }
}

