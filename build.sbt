val catsV                 = "1.3.0"
val circeV                = "0.9.3"
val http4sV               = "0.18.16"
val refinedV              = "0.9.2"
val scalaCheckV           = "1.14.0"
val scalaCheckShapelessV  = "1.1.6"

val `photo-albums` =
  project
  .in(file("photo-albums"))
  .settings(
    name := "photo-albums",
    libraryDependencies ++= Seq(
        "eu.timepit"                  %% "refined"                    % refinedV,
        "eu.timepit"                  %% "refined-scalacheck"         % refinedV,
        "io.circe"                    %% "circe-core"                 % circeV,
        "io.circe"                    %% "circe-generic"              % circeV,
        "io.circe"                    %% "circe-refined"              % circeV,
        "org.typelevel"               %% "cats-core"                  % catsV,
        "org.http4s"                  %% "http4s-circe"               % http4sV,
        "org.http4s"                  %% "http4s-blaze-client"        % http4sV,
        "org.scalacheck"              %% "scalacheck"                 % scalaCheckV % Test,
        "com.github.alexarchambault"  %% "scalacheck-shapeless_1.13"  % scalaCheckShapelessV % Test
    )
  )

val root = project
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
