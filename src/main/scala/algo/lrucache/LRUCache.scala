package r.ian
package algo.lrucache

import java.util.concurrent.locks.ReentrantLock
import scala.collection.mutable

class LRUCache[K, V](private val capacity: Int) {
  //put map with value of some node with has links to the nearest elements
  private val map: mutable.Map[K, V] = new mutable.HashMap[K,V]()
  private val doubleLinkedList: LRUDoublyLinkedList[K] = new LRUDoublyLinkedList[K](capacity)
  private val lock = new ReentrantLock()


  def getOrElseApply(k: K, producerFun: () => V): V = {
    try{
      lock.lock()
      if (map.contains(k)) {
        doubleLinkedList.addFirst(k)
        doubleLinkedList.cutTail()
        map(k)
      }
      else {
        val v = map.getOrElseUpdate(k, producerFun.apply())
        doubleLinkedList.addFirst(k)
        doubleLinkedList.cutTail() match {
          case Some(key) => map.remove(key)
          case _ =>
        }
        v
      }
    }
    finally {
      lock.unlock()
    }
  }

  def get(k: K): Option[V] = {
    val maybeV = map.get(k)

    maybeV match {
      case Some(_) => {
        try{
          lock.lock()
          doubleLinkedList.addFirst(k)
          doubleLinkedList.cutTail()
        }
        finally{
          lock.unlock()
        }

      }
      case _ =>
    }
    maybeV
  }


  def mkString(sep: String = " ") = {
    map.mkString(sep)
  }
}

private class LRUDoublyLinkedList[K](val size: Int) {

  if (size < 2)
    throw new IllegalArgumentException("Size can't be less than 2")

  var currentSize: Int = _

  var first: LRUCacheNode[K] = _

  var last: LRUCacheNode[K] = _


  def addFirst(k: K): Unit = {
    linkFirst(k)
  }

  def cutTail(): Option[K]= {
    if (this.currentSize > size)
      Some(unLinkLast())
    else
      None
  }

  def unLinkLast(): K = {
    val l = this.last
    val preLast = l.nextNode
    preLast.prevNode = null
    this.last = preLast
    this.currentSize -=1
    l.value
  }

  def linkFirst(k: K): Unit = {
    val f = this.first
    val newNode = new LRUCacheNode(k, f)
    if (f == null) {
      this.first = newNode
      this.last = newNode
    } else {
      this.first = newNode
      f.nextNode = newNode
    }

    currentSize+=1
  }
}

private class LRUCacheNode[K](val value : K) {

  def this(k: K, prevNode: LRUCacheNode[K]) = {
    this(k)
    this.prevNode = prevNode
  }

  private[lrucache] var nextNode: LRUCacheNode[K] = _
  private[lrucache] var prevNode: LRUCacheNode[K] = _

}

