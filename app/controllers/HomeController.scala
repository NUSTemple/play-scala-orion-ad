package controllers

import javax.inject._
import java.io._

import play.api._
import play.api.mvc._
import play.api.libs.json._
import models.AppVersion


/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok("Welcome to AD API")
  }

  def version() = Action { implicit request: Request[AnyContent] => {
    import com.typesafe.config._

    val conf = ConfigFactory.parseFile(new File("conf/application.conf")).resolve()
    val appVersion = conf.getString("app.version")
    val playVersion = play.core.PlayVersion.current.toString
    val appVersionFormat = AppVersion(playVersion, appVersion)
    implicit val resFormat: OWrites[AppVersion] = Json.writes[AppVersion]
    val jsonValue = Json.toJson(appVersionFormat)
    Ok(jsonValue) }
  }

  def changeLog() = TODO

}
