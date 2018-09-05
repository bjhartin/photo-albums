package com.bjhartin.photoalbums

object Main extends App {
  import CliCodec._

  val result = for {
    albumId <- decodeAlbumId(args)
  } yield albumId

  Output.printResult(result)
}
