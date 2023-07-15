package r.ian

/**
 * Исправьте определение класса Pair, чтобы он стал ковариантным.
  Метод printNames принимает на вход пары с объектами типа Person и печатает их имена. Однако нам хочется на вход этому методу передавать также и Student.
  Для этого нужна ковариантность пар: Pair[Student] <: Pair[Person].
  Подсказка: в определении Pair в методе replaceFirst тип T стоит в контрвариантной позиции, что мешает быть Pair ковариантным по T.
 */
object Generics2 {
  class Person (val name: String)

  class Student(name: String, val course: Int) extends Person(name)

  class Pair[+T](val first: T, val second: T) {
    def replaceFirst[B >: T](newValue: B): Pair[B] = {
      new Pair[B](newValue, second)
    }
  }

  def printNames[T <: Person](pair: Pair[T]): Unit = {
    println("1: " + pair.first.name + "  2: " + pair.second.name)
  }

  def main(args: Array[String]): Unit = {
    val pair = new Pair(new Student("Pavel", 1), new Student("Oleg", 5))
    printNames(pair.replaceFirst(new Person("Oliver")))

  }

}

