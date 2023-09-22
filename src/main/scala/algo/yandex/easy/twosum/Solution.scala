package r.ian
package algo.yandex.easy.twosum

import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks.{break, breakable}

/**
 * @author Melton Smith
 * @since 22.09.2023
 */
object Solution {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val map = scala.collection.mutable.Map[Int, Int]()

    val result = ArrayBuffer[Int]()

    breakable{
      for (i <- nums.indices) {
        map.get(nums(i)) match {
          case Some(value) =>
            result.+=(value, i)
            break
          case _ =>
        }
        map += ((target - nums(i), i))
      }
    }


    result.toArray
  }
}
