package com.bjhartin.photoalbums

import com.bjhartin.photoalbums.Models.Photo
import org.specs2.mutable.Specification

object CliCodecSpec extends Specification {
  "CliCodec" should {
    "render a photo" in {
      val photo = Photo(1, 2, "the title", "url", "thumbnail url")
      CommandLineCodec.format(photo) must_== "[1] the title"
    }
  }
}
