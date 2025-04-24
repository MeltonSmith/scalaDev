package r.ian
package typeclass

object TypeClasses {

  case class Person(name: String, age: Int)

  trait JSONSerializer[T] {
    def toJson(value: T): String

  }

  implicit object StringSerializer extends JSONSerializer[String] {
    override def toJson(value: String): String = "\"" + value + "\""
  }

  implicit object IntSerializer extends JSONSerializer[Int] {
    override def toJson(value: Int): String = value.toString
  }

  implicit object PersonSerializer extends JSONSerializer[Person] {
    override def toJson(value: Person): String =
      s"""
         |{"name": ${value.name}, "age": ${value.age}}
         |""".stripMargin.trim
  }

  def convertListToJson[T](list: List[T])(implicit serializer: JSONSerializer[T]): String = {
    list.map(v => serializer.toJson(v)).mkString("[", ",", "]")
  }

  //part4 - extending the existing types via extension methods

  object JSONSyntax {
    implicit class JSONSerializable[T](value: T)(implicit serializer: JSONSerializer[T]) {
      def toJson: String = serializer.toJson(value)
    }
  }

  def main(args: Array[String]): Unit = {
    import JSONSyntax._
    println(convertListToJson(List(Person("Alice", 23), Person("Xavier", 45))))

    val bob = Person("Bob", 35)
    bob.toJson

  }

}
