package com.bjhartin.photoalbums

import com.bjhartin.photoalbums.Models.{AlbumId, UsageException}
import scalaz.concurrent.Task

object Args {
  val usageMessage = "USAGE: run PhotoAlbums ALBUM_ID"

  def parseArgs(providedArgs: List[String]): Task[AlbumId] = {
    providedArgs match {
      // Parsing the int can fail
      case s :: Nil => parseAlbumId(s)
      case _ => fail
    }
  }

  private def parseAlbumId(s: String): Task[AlbumId] =
    // Parsing int can throw exception
    Task
      .delay(AlbumId(s.toInt))
      .handleWith { case _ => fail }

  private def fail = Task.fail(UsageException(usageMessage))
}
