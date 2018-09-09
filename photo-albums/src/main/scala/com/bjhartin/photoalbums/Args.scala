package com.bjhartin.photoalbums

import com.bjhartin.photoalbums.Models.{AlbumId, UsageException}

object Args {
  val usageMessage = "USAGE: run PhotoAlbums ALBUM_ID"

  def parseArgs(providedArgs: List[String]): Either[UsageException, AlbumId] = {
    providedArgs match {
      case s :: Nil => Right(AlbumId(s))
      case _ => Left(UsageException(usageMessage))
    }
  }
}
