package com.bjhartin.photoalbums

object Models {
  final case class AlbumId(value: String) extends AnyVal
  final case class Photo(id: Int, albumId: Int, title: String, url: String, thumbnailUrl: String)

  final case class UsageException(message: String) extends Exception
}
