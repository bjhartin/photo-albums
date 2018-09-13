package com.bjhartin.photoalbums

import org.http4s.client.blaze.PooledHttp1Client
import scalaz.concurrent.{Task, TaskApp}

object Main extends TaskApp {
  override def runl(args: List[String]): Task[Unit] =
    for {
      albumId <- Args.parseArgs(args)
      client = PooledHttp1Client()
      uri = Config.photosUri
      photos <- PhotosClient.getPhotos(uri, albumId, client)
    } yield {
      photos.foreach(p => println(CommandLineCodec.format(p)))
    }
}
