package r.ian

/**
 * Заданы тип A и его подтип B, а также функции, которые умеют распечатывать их поле value:

Также существует важный метод methodPrint, который принимает на вход экземпляр типа B и функцию, которая умеет распечатывать его значение. methodPrint(printB, objB) компилируется без проблем, однако, иногда нужно задействовать функцию printA.
Действительно: B <: A, поэтому любая f: A => Any умеет работать и с B. Но есть один нюанс: в текущей реализации printA инвариантна к printB (не является ни родителем, ни наследником), поэтому эту функцию нельзя передать в метод methodPrint.
Задание: исправьте компиляцию кода. В конце (после кода, отображаемого в редакторе) будет вызывано:
 */
object Generics
{


  val objB = new B("It is a B.value")
  val objA = new A("It is a A.value")


  def methodPrint(f: FunctionPrint[A], obj: B) = {
    f(() => obj.value)
  }

  val printA = FunctionPrint[A]("A-value:")
  val printB = FunctionPrint[B]("B-value:")

  def main(args: Array[String]): Unit = {
    methodPrint(printB, objB)
    methodPrint(printA, objB)
  }


}



class A(val value: String) {
}

class B(override val value: String)  extends A(value)

class FunctionPrint[+T <: A](prefix: String) {

  def apply(f: () => String): Unit = println(prefix + " " + f.apply())
}

object FunctionPrint {
  def apply[T <: A](prefix: String) = new FunctionPrint[T](prefix)
}
