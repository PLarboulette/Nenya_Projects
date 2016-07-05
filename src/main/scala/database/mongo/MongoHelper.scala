package database.mongo

import java.util.logging.Logger
import com.mongodb.casbah.Imports._
import play.api.libs.json.{JsValue, Json}
import java.util.UUID

import scala.collection.mutable

/**
  * Created by Pierre on 04/07/2016.
  */

object MongoHelper {

  val logger : Logger = Logger.getLogger("MongoHelper Logger")

  val mongoClient = MongoClient("localhost", 27040)
  val db = mongoClient("projects")
  val coll = db("projects")

  /**
    * Insert new project
    * @param project the project to insert
    * @return the inserted project
    */
  def createProject (project : JsValue) : JsValue = {

    val doc = MongoDBObject(
      "_id" -> UUID.randomUUID().toString,
      "name" -> project.\("name").as[String],
      "author" -> project.\("author").as[String],
      "beginDate" -> project.\("beginDate").as[String],
      "endDate" -> project.\("endDate").as[String]
    )

    coll.insert(doc)
    Json.parse(doc.toString)
  }

  /**
    * Update project in database
    * @param project Project to update
    * @return The project updated
    */
  def updateProject (project : JsValue) : JsValue = {
    val query = MongoDBObject("_id" -> project.\("_id").as[String])
    val update = MongoDBObject(
      "name" -> project.\("name").as[String],
      "author" -> project.\("author").as[String],
      "beginDate" -> project.\("beginDate").as[String],
      "endDate" -> project.\("endDate").as[String]
    )
    val result = coll.update( query, update )
    Json.parse(result.toString)
  }

  /**
    * Delete project in database
    * @param project Project to delete
    * @return The project deleted
    */
  def deleteProject (project : JsValue) : JsValue = {
    val query = MongoDBObject("_id" -> project.\("_id").as[String])
    val result = coll.remove( query )
    Json.parse(result.toString)
  }

  /**
    * Get the project matching with the specified id
    * @param project a json containing the id of the searched project
    * @return the project matching with the specified id
    */
  def getProject (project : JsValue) : Option[JsValue] = {
    val query = MongoDBObject("_id" -> project.\("_id").as[String])
    val result = coll.findOne(query)
    if (result.nonEmpty) Some(Json.parse(result.get.toString)) else None
  }

  /**
    * Return all projects
    * @param filters fields to filter the result
    * @return projects matching with the specified filters
    */
  def getProjects (filters : Option[JsValue]) : mutable.Set[JsValue] = {
    // TODO filters
    val result : mutable.Set[JsValue] = mutable.Set[JsValue] ()
    val allDocs = coll.find()
    allDocs.foreach(doc => result += Json.parse(doc.toString))
    result
  }
}