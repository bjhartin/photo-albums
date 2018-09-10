package com.bjhartin.photoalbums

import com.bjhartin.photoalbums.Models.Photo
import io.circe._
import io.circe.syntax._
import org.specs2.mutable.Specification
import org.specs2.specification.Scope

object Http4CodecSpec extends Specification {
  "Http4Codec" should {
    "Decode a photo" in new context {
      HttpCodec.photoDecoder
        .decodeJson(validPhotoJson) must beRight(Photo(1, 2, "a", "b", "c"))
    }

    "Decode a list of photos" in new context {
      HttpCodec.photosDecoder
        .decodeJson(validPhotoList) must beRight
    }
  }

  trait context extends Scope {
    val validPhotoJson = Json.obj(
      "id" -> 1.asJson,
      "albumId" -> 2.asJson,
      "title" -> "a".asJson,
      "url" -> "b".asJson,
      "thumbnailUrl" -> "c".asJson
    )

    val validPhotoList = Json.arr(
      validPhotoJson,
      validPhotoJson
    )
  }
}
