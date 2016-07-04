package database.mongo

import java.util.logging.Logger

import com.mongodb.casbah.Imports._
import org.joda.time.DateTime
import play.api.libs.json.{JsValue, Json}

/**
  * Created by Pierre on 04/07/2016.
  */
object MongoHelper {

  val logger : Logger = Logger.getLogger("MongoHelper Logger")

  val mongoClient = MongoClient("localhost", 27030)
  val db = mongoClient("projects")
  val coll = db("projects")


  /**
    * Insert new project
    * @param project the project to insert
    * @return the inserted project
    */
  def createProject (project : JsValue) : JsValue = {

    val doc = MongoDBObject(
      "name" -> project.\("name").as[String],
      "author" -> project.\("author").as[String],
      "beginDate" -> project.\("beginDate").as[DateTime],
      "endDate" -> project.\("endDate").as[DateTime]
    )

    coll.insert(doc)
    Json.parse(doc.toString)
  }

  def updateProject (project : JsValue) : JsValue = {
    // TODO
    project
  }

  def deleteProject ( project : JsValue) : JsValue = {
    // TODO
    project
  }

  def getProject (project : JsValue) : JsValue = {
    // TODO
    project
  }

  def getProjects (filters : JsValue) : JsValue = {
    val allDocs = coll.find()
    println( allDocs )
    Json.parse(allDocs.toString())
  }

}
