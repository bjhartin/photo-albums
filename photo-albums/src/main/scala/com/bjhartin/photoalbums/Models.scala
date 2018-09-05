package com.bjhartin.photoalbums

import eu.timepit.refined._
import eu.timepit.refined.api.Refined
import eu.timepit.refined.collection.Size
import eu.timepit.refined.generic.Equal
import eu.timepit.refined.numeric._

object Models {
  type PositiveInt = Int Refined Positive

  final case class AlbumId(value: PositiveInt)

  object Args {
    type HasOneElement = Size[Equal[W.`1`.T]]
    type Arguments = Array[String] Refined HasOneElement
  }
}
