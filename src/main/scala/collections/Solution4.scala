package r.ian
package collections

object Solution4 extends App {

  private val strings: Stream[String] = Stream.continually(Console.readLine).takeWhile(a => a != "END")


  println(strings
    .zipWithIndex
    .filter(tuple => tuple._2 % 2 != 0)
    .map(_._1.toInt * 2)
    .sum)

}
