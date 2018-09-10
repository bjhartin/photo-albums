package com.bjhartin.photoalbums

import com.bjhartin.photoalbums.Models.{AlbumId, UsageException}
import org.specs2.matcher.TaskMatchers
import org.specs2.mutable.Specification

object ArgsSpec extends Specification with TaskMatchers {
  "Args" should {
    "Fail if no args are present" in {
      Args.parseArgs(List.empty[String]) must failWith[UsageException]
    }

    "Fail if multiple args are present" in {
      Args.parseArgs(List("1", "2")) must failWith[UsageException]
    }

    "Fail if album id is not an int" in {
      Args.parseArgs(List("a")) must failWith[UsageException]
    }

    "Provide album ID if present" in {
      Args.parseArgs(List("1")) must returnValue(AlbumId(1))
    }
  }
}
