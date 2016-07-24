package controllers

import javax.inject._
import play.api._
import play.api.mvc._

@Singleton
class HttpRoutingSampleController @Inject() extends Controller {
    
    /**
     * Sample URL - http://localhost:9000/exactMatch
     **/
    def exactMatch = Action { 
        Ok("Exact\nMatch")
    }
    
    /**
     * Sample URL - http://localhost:9000/dynamic/9000
     **/
    def dynamicInput(id: Long) = Action {
        Ok("Dynamic Id: [" + id + "]")
    }
    
    /**
     * Sample URL - http://localhost:9000/httprouting/file/image/my.png
     **/
    def fetchFile(location: String) = Action {
        Ok("File to fetch: [" + location + "]")
    }
    
    /**
     * Sample URL - http://localhost:9000/httprouting/restricted/556
     * Sample wrong URL - http://localhost:9000/httprouting/restricted/234 -- N.B - id
     **/
    def fetchRestrictedId(id: Long) = Action { 
        Ok("Dynamic Id: [" + id + "]")
    }
    
    /**
     * Sample URL - http://localhost:9000/httprouting/fixedparam
     **/
    def fixedStringParam(param: String) = Action {
        Ok("Fixed parameter(the paramter is not provided in URL): [" + param + "]")
    }
    
    /**
     * Sample URL - http://localhost:9000/httprouting/fetchpage?name=mypage
     * Default Sample URL - http://localhost:9000/httprouting/fetchpage
     **/
    def fetchPage(name: String) = Action {
        name match {
            case "home" => Ok(s"You have not provided any value hence default is: $name")
            case _ => Ok(s"The requested page is: [$name]")
        }
    }
    
    /**
     * Sample URL - http://localhost:9000/httprouting/fetchList?param="myValue"
     * Sample URL - http://localhost:9000/httprouting/fetchList
     **/
    def fetchList(param: Option[String]) = Action {
        param match {
            case Some(value) => Ok(s"List will be fetched corresponding to [$value]")
            case _ => Ok("You have not provided any value, hence, an empty list")
        }
    }
    
}