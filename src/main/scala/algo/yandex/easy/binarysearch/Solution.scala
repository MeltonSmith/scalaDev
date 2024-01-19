package r.ian
package algo.yandex.easy.binarysearch

import scala.util.control.Breaks.{break, breakable}

/**
 * @author Melton Smith
 * @since 22.09.2023
 */
object Solution {

  def search(nums: Array[Int], target: Int): Int = {
    var start = 0;
    var end = nums.length - 1
    var result = -1;

    breakable {
      while (start <= end) {
        if (start == end && nums.apply(start) != target)
          break
        val mid = (start + end) / 2
        if (nums.apply(mid) == target) {
          result = mid
          break()
        } else if (nums.apply(mid) < target)
          start = mid + 1
        else
          end = mid
      }
    }
    result
  }

  def main(args: Array[String]): Unit = {
    println(search(Array(-1, 0, 3, 5, 9, 12), 12))
  }
}
