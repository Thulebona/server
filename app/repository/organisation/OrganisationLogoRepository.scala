package repository.organisation

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.dsl._
import com.websudos.phantom.reactivestreams._
import com.websudos.phantom.keys.PartitionKey
import conf.connection.DataConnection
import domain.organisation.OrganisationLogo

import scala.concurrent.Future

/**
 * Created by hashcode on 2016/01/03.
 */
class OrganisationLogoRepository extends CassandraTable[OrganisationLogoRepository, OrganisationLogo] {


  object org extends StringColumn(this) with PartitionKey[String]

  object id extends StringColumn(this) with PrimaryKey[String]

  object url extends StringColumn(this)

  object description extends StringColumn(this)

  object size extends OptionalStringColumn(this)

  object mime extends StringColumn(this)

  object date extends DateColumn(this)

  override def fromRow(r: Row): OrganisationLogo = {
    OrganisationLogo(
      org(r),
      id(r),
      url(r),
      size(r),
      description(r),
      mime(r),
      date(r))
  }
}

object OrganisationLogoRepository extends OrganisationLogoRepository with RootConnector {
  override lazy val tableName = "orglogos"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(dept: OrganisationLogo) = {
    insert
      .value(_.org, dept.org)
      .value(_.id, dept.id)
      .value(_.url, dept.url)
      .value(_.size, dept.size)
      .value(_.mime, dept.mime)
      .value(_.date, dept.date)
      .value(_.description, dept.description)
      .future()
  }

  def findDCompanyLogo(org: String, id: String): Future[Option[OrganisationLogo]] = {
    select.where(_.org eqs org).and(_.id eqs id).one()
  }

  def findCompanyLogos(org: String): Future[Seq[OrganisationLogo]] = {
    select.where(_.org eqs org) fetchEnumerator() run Iteratee.collect()
  }
}
