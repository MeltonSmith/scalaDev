package r.ian
package yandex.easy.twosum

import org.scalatest.Assertions
import org.scalatest.flatspec.AnyFlatSpec
import r.ian.algo.yandex.easy.twosum.Solution

/**
 * @author Melton Smith
 * @since 22.09.2023
 */
class TwoSumTests extends AnyFlatSpec{

  it should "test1" in {
    Assertions.assert(Solution.twoSum(Array(2, 7, 11, 15), 9) sameElements Array(0, 1))
  }

  it should "test2" in {
    Assertions.assert(Solution.twoSum(Array(3,2,4), 6) sameElements Array(1, 2))
  }

  it should "test3" in {
    Assertions.assert(Solution.twoSum(Array(3, 3), 6) sameElements Array(0, 1))
  }

}
