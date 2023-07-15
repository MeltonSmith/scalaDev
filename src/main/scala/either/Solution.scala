package r.ian
package either

import scala.language.postfixOps

/**
 * Правильной называется дробь, у которой модуль числителя  меньше модуля знаменателя.
 * Будем представлять дробь парой (числитель, знаменатель).
 *
 * Реализуйте операцию деления divide(p: (Int, Int))(q: (Int, Int)): Either[String, (Int, Int)],
 * возвращающую результат деления p на q или текст ошибки. Проверьте корректность входных данных, если входные дроби неправильные,
 * верните ошибку Left("Invalid input"). Если делитель нулевой, верните Left("Zero divisor"). Если в результате получилась неправильная дробь,
 * ошибка Left("Improper result").
 *
 * Сократите результат до простой дроби. Воспользуйтесь алгоритмом Евклида, разобранным в модуле про кортежи, или методом BigInt.gcd .
 */
object Solution extends App {


  def divide(p: (Int, Int))(q: (Int, Int)): Either[String, (Int, Int)] = {
      if (p._1.abs > p._2.abs || q._1.abs > q._2.abs) return Left("Invalid input")
      if (p._2 == 0 || q._2 == 0 || q._1 == 0) return Left("Zero divisor")
      if (p._1 * q._2 > p._2 * q._1) return Left("Improper result")

      val div = BigInt(p._1 * q._2).gcd(BigInt(p._2 * q._1))

      Right((p._1 * q._2 / div toInt, p._2 * q._1 / div toInt))

  }


  divide(1, 10) (2, 10).map(ei => println(ei._1 + " / "+ ei._2))

}
