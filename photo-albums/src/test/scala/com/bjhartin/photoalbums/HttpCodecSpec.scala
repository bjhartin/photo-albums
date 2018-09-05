package com.bjhartin.photoalbums

import com.bjhartin.photoalbums.test.Generators

import io.circe.Json
import io.circe.syntax._
import io.circe.refined._
import org.scalacheck.Properties
import org.scalacheck.Prop.forAll
import org.scalacheck.ScalacheckShapeless._

object HttpCodecSpec extends Properties("HttpCodec") {
  import Generators._
  import HttpCodec._
  import Models._

  property("Can decode a PhotoAlbum") = forAll { p: PhotoAlbum =>
    p.asJson == expectedJson(p)
  }

  property("Can encode a PhotoAlbum") = forAll { p: PhotoAlbum =>
    expectedJson(p).as[PhotoAlbum].map(_ == p).getOrElse(false)
  }

  private def expectedJson(p: PhotoAlbum): Json = {
    Json.obj {
      "albumId" -> Json.fromInt(p.albumId.value.value)
    }
  }
}
