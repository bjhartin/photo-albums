package com.bjhartin.photoalbums

import eu.timepit.refined.refineV
import eu.timepit.refined.numeric.Positive

import scala.util.Try
import scala.util.control.NoStackTrace

object CliCodec {
  import Models._
  import Models.Args._

  def decodeAlbumId(args: Array[String]): Either[InvalidArguments, AlbumId] =
    (for {
      singleArg <- refineV[HasOneElement](args)
      intArg <- Try(singleArg.value(0).toInt).toEither
      positiveInt <- refineV[Positive](intArg)
    } yield AlbumId(positiveInt)).left
      .map(_ => InvalidArguments(args))

  final case class InvalidArguments(args: Array[String]) extends RuntimeException with NoStackTrace
}
