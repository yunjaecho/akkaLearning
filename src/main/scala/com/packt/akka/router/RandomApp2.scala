package com.packt.akka.router

import akka.actor.{ActorSystem, Props}
import akka.routing.RandomGroup
import com.packt.akka.router.Worker.Work

/**
  * Created by USER on 2017-08-18.
  */
object RandomApp2 extends App{
  val system = ActorSystem("Random-Router2")

  system.actorOf(Props[Worker], "w1")
  system.actorOf(Props[Worker], "w2")
  system.actorOf(Props[Worker], "w3")

  val paths = List("/user/w1", "/user/w2", "/user/w3")

  val routerGroup = system.actorOf(RandomGroup(paths).props(), "random-router-group")

  routerGroup ! Work()
  routerGroup ! Work()
  routerGroup ! Work()
  routerGroup ! Work()

  Thread.sleep(100)
  system.terminate()

}
