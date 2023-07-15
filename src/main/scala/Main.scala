package r.ian

import scala.io.StdIn

object Main {

  def discount: PartialFunction[Jar, String] = {
    case jar: Jar if jar.value >= 5 && jar.value <= 10 => s"${jar.name} ${jar.price * 0.05}"
    case jar: Jar if jar.value > 10 => s"${jar.name} ${jar.price * 0.1}"
  }

  def main(args: Array[String]): Unit = {
//    println("A")
//    val jars = List(Jar("Морской синий 6л", 6, 3000), Jar("Огненно-красный 12л", 12, 5000))
//    jars.collect(discount)

//    val list: List[Int] = StdIn.readLine().split(" ").map(_.toInt).toList
//    println(kOrder(list, 2))

    val nums = Vector.range(1, 11)
    nums.slice(3, 7)
    nums.tail
    nums.init
    nums.take(3)
    nums.drop(3)
    nums.takeRight(3)
    nums.dropRight(3)
  }


  def kOrder(list: List[Int], k: Int): Int = {
    list.sorted.drop(k-1).head
  }
  val log: PartialFunction[Double, Double] =  {
    case d: Double if d > 0 => Math.log(d)
  }

  val collectPartFunc: PartialFunction[Option[Int], Int] = {
    case Some(d) => d
    case _ => 0
  }

  def swap3(tuple: (Int, Int, Int)): (Int, Int, Int) = {
    (tuple._3, tuple._2, tuple._1)
  }

  def foo(options: List[Option[Int]]): List[Int] = {
    options.filter(a => a != None).map(d => d.get)
  }

//  def divide(p: (Int, Int))(q: (Int, Int)): Either[String, (Int, Int)] = {
//    Left("zero").flatMap(_ => _ *2)
//  }

  def sqrt(x: Double): Either[String, Double] =
    if (x < 0) Left("negative number")
    else Right(Math.sqrt(x))

  def foo(list: List[Int]): Int = {
    list.find(_ % 3 == 0).getOrElse(0) * 2
//    Right(1).flatMap(_ => Left(2)).flatMap(_ => Left(3))
  }


}

case class Jar(name: String, value: Int, price: Double)

