package controllers.organisation

import com.websudos.phantom.dsl.ResultSet
import domain.organisation.{Organisation}
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import service.organisation.OrganisationService

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
  * Created by hashcode on 2016/02/28.
  */
class OrganisationController extends Controller {

  implicit val orgWrites = Json.writes[Organisation]

  def createOrUpdate(organisation: String) = Action.async(parse.json) {
    request =>
      val input = request.body
      val o = (input \ "organisation").as[String]
      val j = Json.parse(o)


//      val entity = Json.fromJson[Organisation](input).get
      val entity = Json.fromJson[Organisation](j).get
      val results = OrganisationService.saveOrUpdate(entity)
//      results.map(result =>
//        Ok(Json.toJson(entity)))

      results.map(result =>
        Ok(Json.toJson(entity)))
  }

  def getById(id: String) = Action.async {
    request =>
      OrganisationService.getById(id) map (result =>
        Ok(Json.toJson(result)))
  }

  def getAll = Action.async {
    request =>
      OrganisationService.getAll map (result =>
        Ok(Json.toJson(result)))
  }
}
