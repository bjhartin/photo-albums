package com.bjhartin.photoalbums

import com.bjhartin.photoalbums.Models.AlbumId
import org.http4s.client.{Client, UnexpectedStatus}
import org.http4s.{HttpService, MalformedMessageBodyFailure, Response, Status}
import org.specs2.matcher.TaskMatchers
import org.specs2.mutable.Specification
import org.specs2.specification.Scope
import scalaz.concurrent.Task

object PhotosClientSpec extends Specification with TaskMatchers {
  "PhotosClient" should {
    "Report a non-200 as a failure" in new context {
      val task = PhotosClient.getPhotos(Config.photosUri, AlbumId(1), clientWhich(Response(Status.NotFound)))
      task must failWith[UnexpectedStatus]
    }

    "Report a malformed response body as a failure" in new context {
      val task = PhotosClient.getPhotos(Config.photosUri, AlbumId(1), clientWhich(Response(Status.Ok).withEmptyBody))
      task must failWith[MalformedMessageBodyFailure]
    }

    "Return a list of photos when successful" in new context {
      // Returns a task because, technically, the body could fail to encode.
      // (not possible here since encoding a String to String)
      val validResponse = Response(Status.Ok).withBody[String](validBody).unsafePerformSync
      val task = PhotosClient.getPhotos(Config.photosUri, AlbumId(1), clientWhich(validResponse))

      task.unsafePerformSync // must returnOk
    }
  }

  trait context extends Scope {
    def clientWhich(response: Response) =
      Client
        .fromHttpService(service(response))

    val validBody =
      """
        |[
        |  {
        |    "albumId": 3,
        |    "id": 101,
        |    "title": "incidunt alias vel enim",
        |    "url": "https://via.placeholder.com/600/e743b",
        |    "thumbnailUrl": "https://via.placeholder.com/150/e743b"
        |  },
        |  {
        |    "albumId": 3,
        |    "id": 102,
        |    "title": "eaque iste corporis tempora vero distinctio consequuntur nisi nesciunt",
        |    "url": "https://via.placeholder.com/600/a393af",
        |    "thumbnailUrl": "https://via.placeholder.com/150/a393af"
        |  }
        |]
      """.stripMargin

    private def service(response: Response) =
      new HttpService({ req =>
        Task.now(response)
      })
  }
}
