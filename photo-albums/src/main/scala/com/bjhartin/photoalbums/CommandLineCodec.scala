package com.bjhartin.photoalbums

import com.bjhartin.photoalbums.Models.Photo

object CommandLineCodec {
  def format(photo: Photo): String = s"[${photo.id}] ${photo.title}"
}
