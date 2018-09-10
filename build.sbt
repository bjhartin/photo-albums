import sbt.Keys.libraryDependencies

val circeV = "0.8.0"
val http4sV = "0.16.6a"
val specs2V = "4.2.0"

lazy val `photo-albums` =
  project
  .in(file("photo-albums"))
  .settings(
    name := "photo-albums",
    libraryDependencies ++= Seq(
      "io.circe"              %% "circe-generic"            % circeV,
      "io.circe"              %% "circe-parser"             % circeV % Test,
      "org.http4s"            %% "http4s-blaze-client"      % http4sV,
      "org.http4s"            %% "http4s-circe"             % http4sV,
      "org.specs2"            %% "specs2-core"              % specs2V % Test,
      "org.specs2"            %% "specs2-scalaz"            % specs2V % Test
    )
  )

lazy val root = project
  .in(file("."))
  .settings(
    name := "photo-albums",
    inThisBuild(
      Seq(
        scalaVersion := "2.12.6",
        scalafmtOnCompile := true))
  )
  .aggregate(
    `photo-albums`
  )
