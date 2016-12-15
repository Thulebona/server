package api

import com.google.gson.Gson
//import domain.User
//import model.UserModel
import org.junit.runner.RunWith
//import org.specs2.mutable.Specification
//import org.specs2.runner.JUnitRunner
import play.api.Logger
import play.api.libs.json.Json
import play.api.test.Helpers._
//import play.api.test.{FakeRequest, WithApplication}
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * Created by hashcode on 2015/07/29.
 */
//@RunWith(classOf[JUnitRunner])
class UserControllerTest /*extends Specification*/{

//  val gson = new Gson()
//
//  "User Controller" should {
//    "Save an Object " in new WithApplication {
////      val user = UserModel("other","first","lastname","username",true,"test13",Set("1234","777"),List("1234","3333"),List("1234"))
//////      val jsonstring = gson.toJson(user).stripMargin
//      val jsonstring ="""{"otherName":"other","firstName":"first","lastName":"lastname","username":"username","enable":true,"password":"test13","role":["23"],"contact":["56"],"address":["231"]}"""
//
//      val json = Json.parse(jsonstring)
//
//
//      val Some(result) = route(FakeRequest(
//        POST, "/api/user/create").withJsonBody(json)
//      )
//      status(result) must equalTo(OK)
//      Logger.debug(" The Result is " + result)
//      contentType(result) must beSome("application/json")
//      result map {
//        vallue => {
//          println(vallue.header)
//          println(vallue)
//          println(vallue.body)
//          println(vallue.body)
//        }
//      }
//      //contentAsString(role) must contain("Your new application is ready.")
//    }
//  }
}
