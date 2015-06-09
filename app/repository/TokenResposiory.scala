package repository

import com.datastax.driver.core.{ResultSet, Row}
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.dsl._
import com.websudos.phantom.keys.PartitionKey
import conf.connection.DataConnection
import domain.Token

import scala.concurrent.Future
import scala.concurrent.duration._
/**
 * Created by hashcode on 2015/06/09.
 */
class TokenResposiory extends CassandraTable[TokenResposiory, Token] {

  object id extends StringColumn(this) with PartitionKey[String]

  object token extends StringColumn(this)

  override def fromRow(row: Row): Token = {
    Token(
      id(row),
      token(row)
    )
  }
}

object TokenResposiory extends TokenResposiory with DataConnection {
  override lazy val tableName = "tokens"

  def save(token: Token): Future[ResultSet] = {
    insert
      .value(_.id, token.id)
      .value(_.token, token.token)
      .ttl(12.hours)
      .future()
  }

  def getTokenById(id:String)=Future[Option[Token]] = {
    select.where(_.id eqs id).one()

  }
  def deleteToken(id:String): Future[ResultSet] = {
    delete.where(_.id eqs id).future()
  }

}
