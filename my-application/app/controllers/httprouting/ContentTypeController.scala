package controllers.httprouting

import javax.inject._
import play.api._
import play.api.mvc._

@Singleton
class ContentTypeController @Inject extends Controller {

	/**
	 * Set the content type of response as HTML
	 **/
    def htmlContentType() = Action {
        Ok(<h1>Hello HTML World!</h1>).as(HTML)
    }

	/**
	 * Set the https headers of the response
	 **/
    def htmlContentSetHeaders() = Action {
    	val html: String = """<h1>Hello World With Headers!</h1><br><p>To view headers press F12 -> networks -> press f5 -> select headers</p>"""
    	Ok(html).as(HTML).withHeaders(
    		CACHE_CONTROL -> "max-age=3600",
  			ETAG -> "xx")
    }

	/**
	 * Set cookies in HTTP response
	 * if you only want to set up the cookie then get rid of discard statment
	 **/
    def htmlSetDiscardCookies = Action {
    	val html: String = """<h1>Hello World With Cookies!</h1><br><p>To view headers press F12 -> resources -> select cookies</p>"""
    	Ok(html).as(HTML).withCookies(
  			Cookie("name", "Gaur-@v-Gaur")).discardingCookies(
  			DiscardingCookie("discardCookieName"))
    }
}