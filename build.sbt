val V = new {
  val distage = "0.10.0-M10"
  val zio = "1.0.0-RC17"
  val zioMacros = "0.6.3-M1"
}

val Deps = new {
  val zio = "dev.zio" %% "zio" % V.zio
  val zioMacros = "dev.zio" %% "zio-macros-core" % V.zioMacros
  val distageCore = "io.7mind.izumi" %% "distage-core" % V.distage
  val distageTestkitScalatest = "io.7mind.izumi" %% "distage-testkit-scalatest" % V.distage
}

ThisBuild / scalaVersion := "2.13.1"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.example"
ThisBuild / organizationName := "example"

lazy val `chat-bot` = (project in file("."))
  .settings(
    scalacOptions += "-Ymacro-annotations",
    libraryDependencies ++= Seq(
      Deps.zio,
      Deps.zioMacros,
      Deps.distageCore,
      Deps.distageTestkitScalatest % Test,
    )
  )
