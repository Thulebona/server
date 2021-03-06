package service.util

import com.datastax.driver.core.ResultSet
import domain.util.Status
import repository.util.StatusRepository
import service.Service

import scala.concurrent.Future

/**
 * Created by hashcode on 2015/11/08.
 */
object  StatusService extends Service{
  def saveOrUpdate(entity: Status): Future[ResultSet] = {
    StatusRepository.save(entity)
  }
  def get(id:String):Future[Option[Status]] ={
    StatusRepository.findById(id)
  }

  def getAll:Future[Seq[Status]] ={
    StatusRepository.findAll
  }

}
