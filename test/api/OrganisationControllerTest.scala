package api

import java.util.Date

import com.google.gson.Gson
import controllers.organisation.OrganisationController
//import domain.organisation.{Organisation, OrganisationModel}
//import org.specs2.mutable._
//import org.specs2.runner._
import org.junit.runner._
import play.api.Logger
import play.api.libs.json._
import play.api.test.Helpers._
//import play.api.test.{FakeRequest, WithApplication}

import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by user42 on 2016/09/27.
  */
//@RunWith(classOf[JUnitRunner])
class OrganisationControllerTest /*extends Specification*/{

//  val gson = new Gson()
//
//  "Organisation Controller" should {
//
//    "should save " in new WithApplication {
//
//      val organisation = Organisation("5", "NGO", Map("34.157789" -> "19.015227"),
//        "", new Date(), "current state")
//
//      val orgString = gson.toJson(organisation).stripMargin
//      val jsonStr: JsValue = JsObject (Seq
//          ("organisation" -> JsString(orgString))
//      )
//
//      val Some(result) = route(FakeRequest(
//       POST, "/api/organisation/post/:org").withJsonBody(jsonStr))
//
//      status(result) must equalTo(OK)
//      Logger.debug(" The Result is " + result)
//      contentType(result) must beSome("application/json")
//
//    }
//
//  }



}
