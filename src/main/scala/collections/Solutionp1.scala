package r.ian
package collections

object Solutionp1 {

  def main(args: Array[String]) {
    val ints1 = List(0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0)
    val ints: List[Int] = ints1

    val tuple = ints1.partition(_ == 0)

     println(tuple._1.mkString(","))
     println(tuple._2.mkString(","))

    // put your code here
  }
}
