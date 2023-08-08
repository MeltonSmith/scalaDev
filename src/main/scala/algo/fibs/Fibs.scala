package r.ian
package algo.fibs

import scala.annotation.tailrec

object Fibs extends App {

  for (x <- 1 to 200){
    println(fibs(x))
  }


  @tailrec
  def fibs(number: Int, f2: BigDecimal = 1, f1: BigDecimal = 0): BigDecimal = {
    if (number == 1)
      f1
    else
      fibs(number - 1, f2 + f1, f2)
  }
}
