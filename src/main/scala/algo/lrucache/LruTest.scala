package r.ian
package algo.lrucache

import java.util.concurrent.{ExecutorService, Executors}
import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, ExecutionContext, ExecutionContextExecutorService, Future, Promise}
import scala.util.Success


object LruTest extends App {
  private implicit val service: ExecutionContextExecutorService = ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(2))

  private val lruCache = new LRUCache[String, String](3)


  val fillFuture: (String, Long) => Future[Unit] = {
    (name, sleepDelay) => Future {
      var count: Int = 0

      while (count < 100) {
        Thread.sleep(sleepDelay)
        lruCache.getOrElseApply(s"${name} $count", () => s"${name}_${count}_value")
        count += 1
      }
    }

  }

  private val eventualUnit: Future[Unit] = fillFuture.apply("future1", 10)
  private val eventualUnit1: Future[Unit] = fillFuture.apply("future2", 10)

  val p = Promise[Unit]

  private val eventualUnits: Seq[Future[Unit]] = Seq(eventualUnit, eventualUnit1)


  eventualUnits.foreach(_.failed.foreach(p.tryFailure))



  Future.sequence(eventualUnits).foreach(_ => p.trySuccess())



  Await.result(p.future, 10.minute)

//  Await.result(eventualUnit, 10.minute)
//  Await.result(eventualUnit1, 10.minute)

  service.shutdown()

  println(lruCache.mkString())

}
