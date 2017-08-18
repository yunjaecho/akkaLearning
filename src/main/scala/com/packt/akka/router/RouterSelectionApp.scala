package com.packt.akka.router

import akka.actor.{Actor, ActorSystem, Props}
import com.packt.akka.router.Worker.Work

/**
  * Created by USER on 2017-08-18.
  */
object RouterSelectionApp extends App{
  val system = ActorSystem("routerSelect")

  system.actorOf(Props[Worker], "w1")
  system.actorOf(Props[Worker], "w2")
  system.actorOf(Props[Worker], "w3")
  system.actorOf(Props[Worker], "w4")
  system.actorOf(Props[Worker], "w5")

  val workers: List[String] = List(
    "/user/w1",
    "/user/w2",
    "/user/w3",
    "/user/w4",
    "/user/w5"
  )

  val routerGroup = system.actorOf(Props(classOf[RouterGroup], workers))

  routerGroup ! Work()
  routerGroup ! Work()

  Thread.sleep(100)
  system.terminate()
}
