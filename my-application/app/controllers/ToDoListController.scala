package controllers

import javax.inject._
import play.api._
import play.api.mvc._

@Singleton
class ToDoListController @Inject extends Controller {

    def toDoList = Action {
        //Ok(views.html.toDo)
        val toDoList = List("Code for different HTTP requests such as get/post/delete/put", "")
         Ok(views.html.toDo(toDoList))
    }

} 