package livecode

import java.time.LocalDateTime

import com.typesafe.scalalogging.StrictLogging
import distage.{DIKey, GCMode, Injector, ModuleDef}
import zio._
import zio.console._
import zio.macros.annotation.accessible

@accessible(">")
trait Bot {
  def prompt: UIO[Unit]

  def userInput: UIO[String]

  def parseInput: UIO[String => UIO[Action]]

  def applyAction: UIO[Action => UIO[Unit]]
}

case class State(
    name: Option[String],
    nextHeroOfTheDay: LocalDateTime,
    nextSweetCoupleOfTheDay: LocalDateTime,
)

object Bot {
  val make =
    (state: Ref[State]) =>
      ZIO.access[Console] { env =>
        new Bot {
          def prompt: UIO[Unit] =
            putStrLn("Enter your name")
              .provide(env)

          def userInput: UIO[String] = ???

          def parseInput: UIO[String => UIO[Action]] = ???

          def applyAction: UIO[Action => UIO[Unit]] = ???
        }
      }
}

object Main extends App with StrictLogging {
  def run(args: List[String]) = {
    val makeApp = putStrLn("hello").as(0)

    val definition = new ModuleDef {
      make[Console.Service[Any]].fromValue(Console.Live.console)
      make[UIO[Int]].from(provideCake(makeApp.provide))
    }

    Injector()
      .produceF[Task](definition, GCMode(DIKey.get[UIO[Int]]))
      .use(_.get[UIO[Int]])
      .catchAll(e => UIO(logger.error("failed to start", e)).as(1))
  }
}
