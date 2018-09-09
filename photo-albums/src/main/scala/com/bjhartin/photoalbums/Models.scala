package com.bjhartin.photoalbums

object Models {
  final case class AlbumId(id: String)

  final case class UsageException(message: String) extends Exception
}
