package com.bjhartin.photoalbums

import com.bjhartin.photoalbums.CliCodec.InvalidArguments
import com.bjhartin.photoalbums.Models.AlbumId

object Output {
  def printResult(result: Either[InvalidArguments, AlbumId]): Unit = result match {
    case Right(albumId) => println(s"Looking up album ID ${albumId.value}")
    case Left(e) =>
      System.err.println(s"Expected one argument, ALBUM_ID (a positive integer), received '${e.args.mkString(",")}'")
      System.exit(1)
  }
}
