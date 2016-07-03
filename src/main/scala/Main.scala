import rx.lang.scala.Observable
import services.ProjectsService

/**
  * Created by Pierre on 02/07/16.
  */
object Main extends App {

  override def main(args: Array[String]) {


     val o : Observable[String] = ProjectsService.projects
    o.subscribe(
      n => println(n),
      (ex : Throwable) => ex.printStackTrace(),
      () => println("Completed")
    )


  }

}
