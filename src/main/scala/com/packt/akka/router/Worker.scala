package com.packt.akka.router

import akka.actor.Actor
import akka.actor.Actor.Receive

/**
  * Created by USER on 2017-08-18.
  */
class Worker extends Actor {
  import Worker._
  override def receive: Receive = {
    case msg: Work =>
      println(s"I received Work Message and My ActorRef: ${self}")
  }
}

object Worker {
  case class Work()
}
