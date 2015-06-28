package controllers

import play.api.mvc._
import service.TokenService

class Application extends Controller {
  val token = TokenService()

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

}
