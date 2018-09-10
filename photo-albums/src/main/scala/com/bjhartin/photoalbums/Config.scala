package com.bjhartin.photoalbums

import org.http4s.Uri

object Config {
  // Invalid URI would be rejected at compile-time by Http4s
  val photosUri = Uri.uri("https://jsonplaceholder.typicode.com/photos")
}
