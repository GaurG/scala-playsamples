package controllers.httprouting

import javax.inject._
import play.api._
import play.api.mvc._

@Singleton
class SessionFlashController @Inject() extends Controller {
	
	def sessionMail(mailId: String) = Action {
		Ok("Mail id is in session -> " + mailId).withSession(
			"mail" -> mailId)
	}

	def addAnotherSessionMail(mailId: String) = Action { request =>
		Ok("Another Mail id is in session -> " + mailId).withSession(
			request.session + ("anothermail" -> mailId))
	}

	def removeMailFromSession(mailId: String) = Action { request =>
		val mail = (key:String) => request.session.get(key).map{mailId => mailId}.getOrElse{"No mail id saved"}
		Ok("Your session mail id is: \n" + mail("mail")).withSession(request.session - mailId)
	}

	def removeSession = Action { 
		Ok("New session").withNewSession
	}

	def fetchSessionMailId = Action { request =>
		val mail = (key:String) => request.session.get(key).map{mailId => mailId}.getOrElse{"No mail id saved"}
		Ok("Your session mail id is: \n" + mail("mail") + "\n" + mail("anothermail"))
	}
}