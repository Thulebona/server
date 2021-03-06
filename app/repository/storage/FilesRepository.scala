package repository.storage

import java.io.FileInputStream
import java.net.URLConnection

import com.mongodb.casbah.gridfs.{GridFS, GridFSDBFile}
import conf.connection.HashDB
import domain.storage.FileMeta
import org.bson.types.ObjectId

/**
  * Created by hashcode on 2016/02/11.
  */
object FilesRepository {
  val gridfs = GridFS(HashDB.getConnection())

  def getFileType(name: String): String = {
    URLConnection.guessContentTypeFromName(name)
  }

  def save(file: FileInputStream,meta:FileMeta):ObjectId = {
    val fileId = gridfs(file) { f =>
      f.filename = meta.fileName
      f.contentType = meta.contentType
    }

    fileId.get.asInstanceOf[ObjectId]
  }

  def getFileById(id: String): Option[GridFSDBFile] = {
    gridfs.findOne(new ObjectId(id))
  }

  def getFilesByName(fileName: String): Option[GridFSDBFile] = {
    gridfs.findOne(fileName)

  }

  def deleteFileById(id: String) = {
    gridfs.remove(new ObjectId(id))
  }

  def deleteFilesByName(fileName: String) = {
    gridfs.remove(fileName)
  }

}