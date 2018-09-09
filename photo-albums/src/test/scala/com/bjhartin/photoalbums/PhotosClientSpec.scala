package com.bjhartin.photoalbums

import org.specs2.mutable.Specification

object PhotosClientSpec extends Specification {
  "PhotosClient" should {
    "Report a non-200 as a failure" in {
      ko
    }.pendingUntilFixed

    "Report a malformed response body as a failure" in {
      ko
    }.pendingUntilFixed

    "Return a list of photos when successful" in {
      ko
    }.pendingUntilFixed
  }
}
