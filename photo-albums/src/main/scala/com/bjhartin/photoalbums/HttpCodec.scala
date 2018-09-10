package com.bjhartin.photoalbums

import com.bjhartin.photoalbums.Models.{AlbumId, Photo}
import io.circe.{Decoder, Json, Printer}
import io.circe.generic.semiauto._
import org.http4s.EntityDecoder
import org.http4s.circe.CirceInstances

object HttpCodec extends CirceInstances {
  override implicit def jsonDecoder: EntityDecoder[Json] = CirceInstances.defaultJsonDecoder
  override protected def defaultPrinter: Printer = Printer.noSpaces

  /*
    Circe can derive decoders for any Case class for which
    there are implicit decoders for its members.
    It provides them for primitive and common types,
    but we must provide others.

    Alternately, we could use 'full auto' derivation,
    but it may be 'too much magic' for some.
   */
  implicit val albumIdDecoder = deriveDecoder[AlbumId]
  implicit val photoDecoder = deriveDecoder[Photo]
  implicit val photosDecoder = Decoder[List[Photo]]

  lazy val photosEntityDecoder = jsonOf[List[Photo]]
}
