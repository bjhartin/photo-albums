package com.bjhartin.photoalbums

import cats.implicits._
import cats.effect.Sync
import org.http4s.client.Client

trait PhotosClient[F[_]] {
  import Models._

  def lookupPhotos(albumId: AlbumId): F[PhotoAlbum]
}

object PhotosClient {
  def impl[F[_]: Sync](client: Client[F]) =
    new PhotosClient[F] {
      import Models._
      import HttpCodec._

      override def lookupPhotos(albumId: Models.AlbumId): F[Models.PhotoAlbum] =
        for {
          photoAlbum <- client.expect[PhotoAlbum](
            s"https://jsonplaceholder.typicode.com/photos?albumId=${albumId.value}")
        } yield photoAlbum
    }
}
