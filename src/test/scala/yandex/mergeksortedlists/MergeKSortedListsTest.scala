package r.ian
package yandex.mergeksortedlists

import org.scalatest.flatspec.AnyFlatSpec
import r.ian.algo.yandex.mergeksortedlists.Solution.createListNodeFrom
import r.ian.algo.yandex.mergeksortedlists.{ListNode, Solution}

class MergeKSortedListsTest extends AnyFlatSpec{


  it should "merge in case 1" in {
    val nodes = Array(createListNodeFrom(1, 2, 3, 4), createListNodeFrom(5, 6, 7, 8))
    print(Solution.mergeKListsPar(nodes))
  }

  it should "merge in case 2" in {
    val nodes = Array(createListNodeFrom(0, 8, 10), createListNodeFrom(3, 6, 7))
    print(Solution.mergeKListsPar(nodes))
  }

  it should "merge in case 3" in {
    val nodes = Array(createListNodeFrom(-101010, 8, 10), createListNodeFrom(3, 6, 7), createListNodeFrom(0, 1, 2, 25), createListNodeFrom(-201010, 3, 4, 12))
    print(Solution.mergeKListsPar(nodes))
  }

  it should "merge in case 4" in {
    val nodes = Array(createListNodeFrom(0,2), createListNodeFrom(0, 3))
    val node = Solution.mergeKListsPar(nodes)
    print(node)
  }

  it should "merge in case 5" in {
    val nodes = Array(createListNodeFrom(0, 4, 15), null, createListNodeFrom(2, 8, 13))
    val node = Solution.mergeKListsPar(nodes)
    print(node)
  }

  it should "merge in case 6" in {
    val nodes = Array[ListNode]()
    val node = Solution.mergeKListsPar(nodes)
    print(node)
  }

  it should "merge in case 7" in {
    val nodes = Array(null, createListNodeFrom(1))
    val node = Solution.mergeKListsPar(nodes)
    print(node)
  }

  it should "merge in case 8" in {
    val nodes = Array(createListNodeFrom(2), null ,createListNodeFrom(-1))
    val node = Solution.mergeKListsPar(nodes)
    print(node)
  }

  //ForkJoin
  it should "merge in case 9" in {
    val nodes = Array(createListNodeFrom(2), null, createListNodeFrom(-1))
    val node = Solution.mergeKListsPar(nodes)
    print(node)
  }

  it should "merge in case 10" in {
    val nodes = Array(null, createListNodeFrom(1))
    val node = Solution.mergeKListsPar(nodes)
    print(node)
  }

  it should "merge in case 11" in {
    val nodes = Array(createListNodeFrom(1,4,5), createListNodeFrom(1,3,4),  createListNodeFrom(2,6))
    val node = Solution.mergeKListsPar(nodes)
    print(node)
  }

  def createListNodeFrom(ints: Int*): ListNode = {
    var first = new ListNode(ints.last, null)
    for (i <- ints.size - 2 to 0 by -1) {
      first = new ListNode(ints(i), first)
    }
    first
  }
}
