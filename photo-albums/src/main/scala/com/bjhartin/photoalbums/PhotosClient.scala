package com.bjhartin.photoalbums

import com.bjhartin.photoalbums.Models.{AlbumId, Photo}
import org.http4s.Uri
import org.http4s.client.Client
import scalaz.concurrent.Task

// NOTE: This is an initial naive implementation which would
// pull all photos into memory.
object PhotosClient {
  def getPhotos(uri: Uri, albumId: AlbumId, client: Client): Task[List[Photo]] = {
    val newUri = uri.withQueryParam("albumId", albumId.value)
    client.expect[List[Photo]](newUri)(HttpCodec.photosEntityDecoder)
  }
}
