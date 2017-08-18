package com.packt.akka.router

import akka.actor.{ActorSystem, Props}
import com.packt.akka.router.Worker.Work

/**
  * Created by USER on 2017-08-18.
  */
object RouterApp extends App {
  val system = ActorSystem("router")
  val router = system.actorOf(Props[Router])

  router ! Work()
  router ! Work()
  router ! Work()
  router ! Work()

  Thread.sleep(100)
  system.terminate()
}
