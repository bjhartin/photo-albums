package com.bjhartin.photoalbums

import com.bjhartin.photoalbums.Models.{AlbumId, UsageException}
import org.specs2.mutable.Specification

object ArgsSpec extends Specification {
  "Args" should {
    "Fail if no args are present" in {
      Args.parseArgs(List.empty[String]) must beLeft[UsageException]
    }

    "Fail if multiple args are present" in {
      Args.parseArgs(List("1", "2")) must beLeft[UsageException]
    }

    "Provide album ID if present" in {
      Args.parseArgs(List("1")) must beRight(AlbumId("1"))
    }
  }
}
