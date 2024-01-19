package r.ian
package algo.validparentheses

import scala.collection.mutable.ListBuffer

/**
 * @author Melton Smith
 * @since 21.09.2023
 */
object Solution {

  def main(args: Array[String]): Unit = {
    println(isValid("["))
  }

  def isValid(s: String): Boolean = {
    val circles = new ListBuffer[Int]
    val parentheses = new ListBuffer[Int]
    val squares = new ListBuffer[Int]
    val pointers = new ListBuffer[ListBuffer[Int]]


    for (char <- s) {
      char match {
        case '{' =>
          pointers prepend parentheses
          parentheses prepend 1
        case '}' =>
          pointers.headOption match {
            case Some(head) if head eq parentheses =>
              pointers -= pointers.head
              parentheses -= 1
            case _ => return false
          }
        case '[' =>
          pointers prepend squares
          squares prepend 1
        case ']' =>
          pointers.headOption match {
            case Some(head) if head eq squares =>
              pointers -= pointers.head
              squares -= 1
            case _ => return false
          }
        case '(' =>
          pointers prepend circles
          circles prepend 1
        case ')' =>
          pointers.headOption match {
            case Some(head) if head eq circles =>
              pointers -= pointers.head
              circles -= 1
            case _ => return false
          }
        case _ =>
      }
    }
    circles.isEmpty && squares.isEmpty && parentheses.isEmpty
  }
}
