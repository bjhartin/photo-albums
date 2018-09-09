package com.bjhartin.photoalbums

import com.bjhartin.photoalbums.Models.{AlbumId, Photo, PhotoRetrievalException}

// NOTE: This is an initial naive implementation which would
// pull all photos into memory.
object PhotosClient {
  def getPhotos(albumId: AlbumId): Either[PhotoRetrievalException, List[Photo]] = ???
}
