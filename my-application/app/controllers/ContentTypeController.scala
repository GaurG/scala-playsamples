package controllers

import javax.inject._
import play.api._
import play.api.mvc._

@Singleton
class ContentTypeController @Inject extends Controller {

    def htmlContentType() = Action {
        Ok(<h1>Hello HTML World!</h1>).as(HTML)
    }
}