package com.bjhartin.photoalbums

import scalaz.concurrent.{Task, TaskApp}

object Main extends TaskApp {
  override def runl(args: List[String]): Task[Unit] =
    Task.delay(())
}
