package r.ian


import scala.+:

object ForComprehension {

  def main(args: Array[String]): Unit = {

//    val stringOrEither = service1.flatMap(a => {
//      service2(a)
//    })
//    val ints = List(1, 2, 3)


    val str = List(1, 2, 3).foldRight(4)((a, b) =>  a + b)
    println(str)

  }

  final case class Pair[T,S](first: T, second: S) {
    //...
    def swap: Pair[S,T] = {
      Pair(second, first)
    }
  }

  val pair = Pair(123, "Oleg").swap
  require(pair.first == "Oleg")
  require(pair.second == 123)

  class Dict [K, V, T[C] <: Seq[C]](items: T[(K,V)])
//  def service1: Either[String, Double]
//
//  def service2(res1: Double): Either[String, Int]
//
//  def service3: String
//
//  def service4(res1: Double, res2: Int, res3: String): Either[String, String]

//  def some = {
//    for { (k,v) <- Map("a" -> 1, "b" -> 2) } yield k
//    for { x <- List(1,2,3,4) } yield x
//    for { x <- Some(1) ; y <- Left("year") } yield x + y
//    for { x <- Some(2); y <- List(1,2,3,4) } yield x + y
//    for { x <- Some(1) ; y <- None } yield (x, y)
//  }

//  def result =
//    for {
//      resultS1 <- service1
//      resultS2 <- service2(resultS1)
//      resultS4 <- service4(resultS1, resultS2, service3)
//    }
//    yield resultS4


}
