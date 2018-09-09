package com.bjhartin.photoalbums

object Models {
  final case class AlbumId(id: String)
  final case class PhotoId(id: String)
  final case class Photo(photoId: PhotoId, albumId: AlbumId, title: String, url: String, thumbnailUrl: String)

  final case class UsageException(message: String) extends Exception
  final case class PhotoRetrievalException(message: String) extends Exception
}
