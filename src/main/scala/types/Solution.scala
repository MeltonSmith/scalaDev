package r.ian
package types

import types.Solution.Vect.Aux

import scala.collection.mutable.ListBuffer

object Solution {

  trait Vect extends Any {
    type Item

    def length: Int

    def get(index: Int): Item

    def set(index: Int, item: Item): Aux[Item]
  }

  object Vect {
    type Aux[I] = Vect {type Item = I}
  }

  final case class StringVect(str: String) extends AnyVal with Vect {
    type Item = Char

    def length = str.length

    def get(index: Int) = {
      if (index >= 0 && index < length)
        str.charAt(index)
      else
        throw new IllegalArgumentException
    }

    def set(index: Int, item: Char): Aux[Char] = {
      StringVect(str.updated(index, item))
    }
  }

  final case class BoolVect64(values: Long) extends AnyVal with Vect {
    type Item = Boolean

    def length = 64

    override def get(index: Int) = {
      if (index >= 0 && index < length)
        ((values >> index) & 1) == 1
      else
       false
    }

    def set(index: Int, item: Boolean) = {
      if (index < length  && index >= 0) {
        if (item)
          BoolVect64(values | (1 << index).toLong)
        else
          BoolVect64(values & ~(1 << index).toLong)
      }
      else
        this
    }
  }

  final case class BoolVect8(values: Byte) extends AnyVal with Vect {
    type Item = Boolean

    def length = 8

    def get(index: Int) = {
      if (index >= 0 && index < length)
        ((values >> index) & 1) == 1
      else
        false
    }

    def set(index: Int, item: Boolean) = {

      if (index < length && index >= 0) {
        if (item)
           BoolVect8((values | (1 << index)).toByte)
        else
           BoolVect8((values & ~(1 << index)).toByte)
      }
      else
        this
    }
  }

  def toList(vect: Vect): List[vect.Item] = {
    var buffer = List[vect.Item]()
    for (i <- vect.length-1  to 0 by -1){
      buffer = buffer.+:(vect.get(i))
    }
    buffer
  }

  def main(args: Array[String]): Unit = {
    val vect = BoolVect8(11)
    val vect2 = BoolVect64(128L)
    println(toList(vect))
    println(toList(vect2))
  }

}
