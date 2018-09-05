package com.bjhartin.photoalbums.test

import com.bjhartin.photoalbums.Models.{AlbumId, PositiveInt}
import eu.timepit.refined._
import eu.timepit.refined.numeric.Positive
import org.scalacheck.{Arbitrary, Gen}

object Generators {
  implicit val positiveInt: Arbitrary[PositiveInt] =
    Arbitrary {
      Gen
        .chooseNum(0, 10000)
        .map(refineV[Positive](_))
        .flatMap {
          case Right(i) => Gen.const(i)
          case Left(_) => Gen.fail
        }
    }

  implicit val arbAlbumId: Arbitrary[AlbumId] =
    Arbitrary(positiveInt.arbitrary.map(AlbumId))

}
