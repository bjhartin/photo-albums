lazy val refinedV = "0.9.2"
lazy val catsV = "1.3.0"

lazy val `photo-albums` =
  project
  .in(file("photo-albums"))
  .settings(
    name := "photo-albums",
    libraryDependencies ++= Seq(
        "eu.timepit"    %% "refined"        % refinedV,
        "org.typelevel" %% "cats-core"      % catsV
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
