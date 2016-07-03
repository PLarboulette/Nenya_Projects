package services

import rx.lang.scala.Observable


/**
  * Created by pierre on 02/07/16.
  */
object ProjectsService {



  def projects : Observable[String] = {

    Observable(subscriber => {
      try {
        subscriber.onNext("Hello")
        subscriber.onCompleted()
      } catch {
        case ex : Throwable => subscriber.onError(ex)
      }

    }

    )
  }




}
