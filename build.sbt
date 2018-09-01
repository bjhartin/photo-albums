lazy val `photo-albums` =
  project
  .in(file("photo-albums"))
  .settings(
    name := "photo-albums",
    libraryDependencies ++= Seq()
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
