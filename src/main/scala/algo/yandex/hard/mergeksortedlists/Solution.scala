package r.ian
package algo.yandex.hard.mergeksortedlists

import java.util.concurrent.{ForkJoinPool, ForkJoinTask, RecursiveTask}
import scala.collection.parallel.ForkJoinTaskSupport
import scala.util.Try
import scala.util.control.Breaks.{break, breakable}


object Solution {

  def main(args: Array[String]): Unit = {
    val nodes = Array(createListNodeFrom(1,2), createListNodeFrom(1, 3))
    val result = mergeKLists(nodes)
    println(result)
  }


  def createListNodeFrom(ints: Int*) : ListNode = {
    var first = new ListNode(ints.last, null)
    for  (i <- ints.size-2 to 0 by -1) {
      first = new ListNode(ints(i), first)
    }
    first
  }


  def mergeKLists(lists: Array[ListNode]): ListNode = {

    if (lists.isEmpty)
      return null

    val par = lists.par
    par.tasksupport = new ForkJoinTaskSupport()

    par.reduce((a, b) => {
      var prevA: ListNode = null
      var prevB: ListNode = null

      var interimA = a
      var interimB = b

      val toReturn = (Option(interimA), Option(interimB)) match {
        case (Some(v1), Some(v2)) => {
          var a = if (v1.x <= v2.x) v1 else v2
          breakable {
            while (true) {

              if (interimA == null) {
                if (interimB != null)
                  prevA.next = interimB
                break
              }
              if (interimB == null) {
                if (interimA == null)
                  prevB.next = interimA
                break
              }

              if (interimA.x <= interimB.x) {
                prevA = interimA
                interimA = interimA.next
              }
              else {
                val nextB = interimB.next
                interimB.next = interimA
                if (prevA == null)
                  a = interimB
                else
                  prevA.next = interimB

                //going next in second
                //and prevA (in order to set the link) is interimB
                prevA = interimB
                prevB = interimB
                interimB = nextB
              }
            }
          }
          a
        }
        case (Some(v1), None) => v1
        case (None, Some(v2)) => v2
        case (None, None) => interimA
      }
      toReturn
    }
    )
  }

  def mergeKListsPar(lists: Array[ListNode]): ListNode = {
    val pool = new ForkJoinPool(4)
    val task = new MergeReduceTask(lists)
    val node = pool.invoke(task)
    node
  }


  def combine(node1: ListNode, node2: ListNode) : ListNode = {

    val nodeToReturn = (Option(node1), Option(node2)) match {
      case (Some(a), Some(b)) => {
        var prevA: ListNode = null
        var prevB: ListNode = null
        var interimA = a
        var interimB = b
        var c = if (a.x <= b.x) a else b

        breakable {
          while (true) {

            if (interimA == null) {
              if (interimB != null)
                prevA.next = interimB
              break
            }
            if (interimB == null) {
              if (interimA == null)
                prevB.next = interimA
              break
            }

            if (interimA.x <= interimB.x) {
              prevA = interimA
              interimA = interimA.next
            }
            else {
              val nextB = interimB.next
              interimB.next = interimA
              if (prevA == null)
                c = interimB
              else
                prevA.next = interimB

              //going next in second
              //and prevA (in order to set the link) is interimB
              prevA = interimB
              prevB = interimB
              interimB = nextB
            }
          }
        }
        c
      }
      case (Some(v1), None) => v1
      case (None, Some(v2)) => v2
      case (None, None) => node1
    }
    nodeToReturn
  }

  class MergeReduceTask(val arrayOfListNodes: Array[ListNode]) extends RecursiveTask[ListNode] {
    private val threshold: Int = 2

    override def compute(): ListNode = {
      if (arrayOfListNodes.length <= threshold) {
        return combine(Try(arrayOfListNodes(0)).getOrElse(null), Try(arrayOfListNodes(1)).getOrElse(null))
      }

      val i = arrayOfListNodes.length / 2
      val subTask1 = new MergeReduceTask(arrayOfListNodes.slice(0, i))
      val subTask2 = new MergeReduceTask(arrayOfListNodes.slice(i, arrayOfListNodes.length))

      ForkJoinTask.invokeAll(subTask1, subTask2)

      combine(subTask1.join(), subTask2.join())

    }
  }
}
