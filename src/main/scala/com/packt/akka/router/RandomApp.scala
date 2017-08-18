package com.packt.akka.router

import akka.actor.{ActorSystem, Props}
import akka.routing.FromConfig
import com.packt.akka.router.Worker.Work

/**
  * Created by USER on 2017-08-18.
  */
object RandomApp extends App {
  val system = ActorSystem("Random-Router")

  val routerPool = system.actorOf(FromConfig.props(Props[Worker]), "random-router-pool")

  routerPool ! Work()
  routerPool ! Work()
  routerPool ! Work()
  routerPool ! Work()
  routerPool ! Work()

  Thread.sleep(100)
  system.terminate()
}
