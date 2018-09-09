import sbt.Keys.libraryDependencies

val http4sV = "0.18.16"
val specs2V = "4.2.0"

lazy val `photo-albums` =
  project
  .in(file("photo-albums"))
  .settings(
    name := "photo-albums",
    libraryDependencies ++= Seq(
      "org.http4s"            %% "http4s-blaze-client"      % http4sV,
      "org.specs2"            %% "specs2-core"              % specs2V % Test
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
