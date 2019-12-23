package livecode

import livecode.code.program
import zio._
import zio.console._

object code {

  case class Bot(name: String)

  sealed trait Action

  object EnterName extends Action

  object SaveName extends Action

  object ChoosePidorOfTheDay extends Action

  object ChooseSweetCoupleOfTheDay extends Action

  val program =
    putStrLn("hello")
}

object Main extends App {
  def run(args: List[String]) =
    program
      .as(0)
}
