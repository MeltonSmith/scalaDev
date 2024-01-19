package r.ian
package algo.yandex.easy.twosum

import scala.util.control.Breaks.{break, breakable}

/**
 * @author Melton Smith
 * @since 22.09.2023
 */
object Solution {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val map = scala.collection.mutable.Map[Int, Int]()

    var result:Array[Int] = null

    breakable{
      for (i <- nums.indices) {
        map.get(target - nums(i)) match {
          case Some(value) =>
            result = Array(value, i)
            break
          case _ =>
        }
        map += ((nums(i), i))
      }
    }
    result
  }
}
