package com.packt.akka.router

import akka.actor.{Actor, ActorRef, Props}
import akka.actor.Actor.Receive
import com.packt.akka.router.Worker.Work

/**
  * Created by USER on 2017-08-18.
  */
class Router extends Actor{
  var routees: List[ActorRef] = _

  override def preStart(): Unit = {
    routees = List.fill(5)(context.actorOf(Props[Worker]))
  }

  override def receive: Receive = {
    case msg: Work =>
      println("I'm a Router and I received a Message ...........")
      routees(util.Random.nextInt(routees.size)) forward(msg)
  }
}

class RouterGroup(routees: List[String]) extends Actor {
  override def receive: Receive = {
    case msg : Work =>
      println(s"I'm a Router Group and I received Work Messag...")
      context.actorSelection(routees(util.Random.nextInt(routees.size))) forward(msg)
  }
}
