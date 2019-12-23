package livecode

import zio._
import zio.console._

object code {
  val program =
    putStrLn("hello")
}

object Main extends App {
  def run(args: List[String]) =
    code.program
      .as(0)
}
