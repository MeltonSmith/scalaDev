package r.ian
package collections

import scala.io.StdIn

object Solution2 {

  def main(args: Array[String]): Unit = {
    def kOrder(list: List[Int], k: Int): Int = {
      val list: List[Int] = StdIn.readLine().split(" ").map(_.toInt).toList
      val head = list.sorted.drop(k - 1).head
      println(head)
      head
    }


  }
}
