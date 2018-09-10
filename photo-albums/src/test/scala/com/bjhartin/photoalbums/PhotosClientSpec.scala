package com.bjhartin.photoalbums

import com.bjhartin.photoalbums.Models.AlbumId
import org.http4s.client.{Client, UnexpectedStatus}
import org.http4s.{HttpService, Response, Status}
import org.specs2.matcher.TaskMatchers
import org.specs2.mutable.Specification
import org.specs2.specification.Scope
import scalaz.concurrent.Task

object PhotosClientSpec extends Specification with TaskMatchers {
  "PhotosClient" should {
    "Report a non-200 as a failure" in new context {
      val task = PhotosClient.getPhotos(Config.photosUri, AlbumId("1"), clientWhich(Response(Status.NotFound)))
      task must failWith[UnexpectedStatus]
    }

    "Report a malformed response body as a failure" in {
      ko
    }.pendingUntilFixed

    "Return a list of photos when successful" in {
      ko
    }.pendingUntilFixed
  }

  trait context extends Scope {
    def clientWhich(response: Response) =
      Client
        .fromHttpService(service(response))

    private def service(response: Response) =
      new HttpService({ req =>
        Task.now(response)
      })
  }
}
