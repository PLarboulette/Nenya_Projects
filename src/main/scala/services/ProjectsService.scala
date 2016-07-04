package services

import java.util.logging.Logger
import database.mongo.MongoHelper
import play.api.libs.json.JsValue
import scala.collection.mutable

/**
  * Created by Pierre on 02/07/16.
  */
object ProjectsService {

  val logger : Logger = Logger.getLogger("ProjectsService Logger")

  /**
    * Insert new project in database
    *
    * @param project Project to insert
    * @return The project created
    */
  def createProject (project : JsValue): JsValue = {
    logger.info("create_project request / Data :" + project)
    MongoHelper.createProject(project)
  }

  /**
    * Update project in database
    *
    * @param project Project to update
    * @return The project updated
    */
  def updateProject (project : JsValue) : JsValue = {
    logger.info("update_project request / Data :" + project)
    MongoHelper.updateProject(project)
  }

  /**
    * Delete project in database
    *
    * @param project Project to delete
    * @return The project deleted
    */
  def deleteProject (project : JsValue) : JsValue = {
    logger.info("delete_project request / Data :" + project)
    MongoHelper.deleteProject(project)
  }

  /**
    * Return all projects
    * @param filters fields to filter the result
    * @return projects matching with the specified filters
    */
  def getProjects (filters : JsValue) : mutable.Set[JsValue] = {
    logger.info("get_projects request / Data :" + filters)
    MongoHelper.getProjects(filters)
  }

  /**
    * Get the project matching with the specified id
    * @param project a json containing the id of the searched project
    * @return the project matching with the specified id
    */
  def getProject (project : JsValue) : JsValue = {
    logger.info("get_project request / Data :" + project)
    MongoHelper.getProject(project)
  }
}
