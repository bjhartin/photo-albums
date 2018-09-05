package com.bjhartin.photoalbums

import cats.effect.Sync
import eu.timepit.refined.numeric.Positive
import io.circe._
import io.circe.generic.semiauto._
import io.circe.refined._
import eu.timepit.refined.refineV
import org.http4s._
import org.http4s.circe._

object HttpCodec extends CirceInstances {
  import Models._

  val printer: Printer =
    Printer.noSpaces.copy(preserveOrder = false, dropNullValues = true)

  override protected def defaultPrinter: Printer = printer

  override def jsonDecoder[F[_]: Sync]: EntityDecoder[F, Json] =
    CirceInstances.defaultJsonDecoder

  implicit val albumIdEncoder = Encoder.encodeInt.contramap[AlbumId](_.value.value)
  implicit val albumIdDecoder = Decoder.decodeInt.emap { int =>
    (for {
      positiveInt <- refineV[Positive](int)
    } yield AlbumId(positiveInt)).left
      .map(_ => "Error")
  }

  implicit val photoAlbumEncoder = deriveEncoder[PhotoAlbum]
  implicit val photoAlbumDecoder = deriveDecoder[PhotoAlbum]

  implicit def entityDecoder[F[_]: Sync, A](implicit decoder: Decoder[A]): EntityDecoder[F, A] = jsonOf[F, A]
}
