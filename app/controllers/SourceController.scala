package controllers

import domain.Source
import model.SourceModel
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import service.SourceService
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * Created by hashcode on 2015/06/25.
 */
class SourceController extends Controller{
  val service = SourceService()

  def create = Action.async(parse.json) {
    request =>
      val input = request.body
      val sourceModel = Json.fromJson[SourceModel](input).get
      val source = sourceModel.getDomain()
      val results = service.create(source)
      results map(result =>Ok(Json.toJson(source)))
  }

  def getAll = Action.async {
    request =>
      service.getSources map (sources => Ok(Json.toJson(sources)))
  }

  def getSource(id: String) = Action.async {
    service.getSource(id) map (source => Ok(Json.toJson(source)))
  }

  def update = Action.async(parse.json) {
    request =>
      val input = request.body
      val source = Json.fromJson[Source](input).get
      val results = service.create(source)
      results map(result =>Ok(Json.toJson(source)))
  }
}