package r.ian
package algo.mergesort

import scala.reflect.ClassTag

object MergeSort extends App {

  println(sortMerge(Array(10, 3, -1, 12321, 2311, 0, 0, 0, 4, 8, 4, 9, -1000)).mkString(" "))



  implicit val intOrdering = new Ordering[Int] {
    def compare(a1: Int, a2: Int): Int = a1 compare a2
  }

  def sortMerge[T: ClassTag](arr: Array[T])(implicit ordering: Ordering[T]): Array[T] = {
    if (arr.length < 2)
      return arr

    val i = arr.length / 2

    //divide
    val a1 = sortMerge(arr.slice(0, i))
    val a2 = sortMerge(arr.slice(i, arr.length))

    sort(a1, a2, arr)
  }

  private def sort[T: ClassTag](arr1: Array[T], arr2: Array[T], resArr: Array[T])(implicit ordering: Ordering[T]) : Array[T] = {
//    val resArr = new Array[T](arr1.length + arr2.length)
    var i = 0
    var j = 0
    var r = 0

    while (i < arr1.length && j < arr2.length){
      if (ordering.lteq(arr1(i), arr2(j))) {
        resArr(r) = arr1(i)
        i+=1
      }
      else {
        resArr(r) = arr2(j)
        j+=1
      }
      r+=1
    }
    //adding rest
    while (i < arr1.length){
      resArr(r) = arr1(i)
      r+=1
      i+=1
    }
    while (j < arr2.length) {
      resArr(r) = arr2(j)
      r += 1
      j += 1
    }
    resArr

  }
}
