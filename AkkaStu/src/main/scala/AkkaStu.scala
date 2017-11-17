import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props

class HelloActor extends Actor{
  def receive = {
    case "hello"  => println("hello back to you.")
    case _        => println("huh?")
  }
}

object Test1_HelloActor extends App {
  // actor need an ActorSystem
  val system = ActorSystem("HelloSystem")
  // create and start the actor
  val helloActor = system.actorOf(Props[HelloActor], name="helloActor")
  // send two messages
  helloActor ! "hello"
  helloActor ! "what"
  // shutdown the actor system
  system.shutdown
}