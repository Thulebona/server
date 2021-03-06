package repository.content

import com.datastax.driver.core.{ResultSet, Row}
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.dsl._
import com.websudos.phantom.reactivestreams._
import com.websudos.phantom.keys.PartitionKey
import conf.connection.DataConnection
import domain.content.EditedContent

import scala.concurrent.Future

/**
  * Created by hashcode on 2016/02/11.
  */
class EditedContentRepository extends CassandraTable[EditedContentRepository, EditedContent] {

  object org extends StringColumn(this) with PartitionKey[String]

  object id extends StringColumn(this) with PrimaryKey[String]

  object dateCreated extends DateColumn(this)

  object creator extends StringColumn(this)

  object source extends StringColumn(this)

  object category extends StringColumn(this)

  object title extends StringColumn(this)

  object content extends StringColumn(this)

  object contentType extends StringColumn(this)

  object status extends StringColumn(this)

  object state extends StringColumn(this)

  override def fromRow(row: Row): EditedContent = {
    EditedContent(
      org(row),
      id(row),
      dateCreated(row),
      creator(row),
      source(row),
      category(row),
      title(row),
      content(row),
      contentType(row),
      status(row),
      state(row)
    )
  }
}

object EditedContentRepository extends EditedContentRepository with RootConnector {
  override lazy val tableName = "econtent"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session


  def save(content: EditedContent): Future[ResultSet] = {
    insert
      .value(_.org, content.org)
      .value(_.id, content.id)
      .value(_.dateCreated, content.dateCreated)
      .value(_.creator, content.creator)
      .value(_.source, content.source)
      .value(_.category, content.category)
      .value(_.title, content.title)
      .value(_.content, content.content)
      .value(_.contentType, content.contentType)
      .value(_.status, content.status)
      .value(_.state, content.state)
      .future()
  }

  def getContentById(org:String, id: String): Future[Option[EditedContent]] = {
    select.where(_.org eqs org).and(_.id eqs id).one()
  }

  def getAllContents(org:String): Future[Seq[EditedContent]] = {
    select.where(_.org eqs org).fetchEnumerator() run Iteratee.collect()
  }

  def getContents(org:String,startValue: Int): Future[Iterator[EditedContent]] = {
    select.where(_.org eqs org).fetchEnumerator() run Iteratee.slice(startValue, 20)
  }
}

