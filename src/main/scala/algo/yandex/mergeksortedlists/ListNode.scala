package r.ian
package algo.yandex.mergeksortedlists

import java.util.StringJoiner

class ListNode(val x: Int, var next: ListNode) {
  override def toString: String = {
    val buffer = new StringJoiner(", ")
    buffer.add(x.toString)

    while (next != null){
      buffer.add(next.x.toString)
      next = next.next
    }
    buffer.toString
  }
}
