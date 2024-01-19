package r.ian
package algo.validparentheses

import org.scalatest.Assertions
import org.scalatest.flatspec.AnyFlatSpec

/**
 * @author Melton Smith
 * @since 21.09.2023
 */
class ValidParenthesesTest extends AnyFlatSpec{

  it should "test1" in {
    Assertions.assert(true, Solution.isValid("{[]}"))
  }

  it should "test2" in {
    Assertions.assert(!Solution.isValid("["))
  }

  it should "test3" in {
    Assertions.assert(!Solution.isValid("]"))
  }

}
