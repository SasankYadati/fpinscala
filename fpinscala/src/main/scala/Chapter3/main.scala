import chapter3._

object c3 {
    def main(args: Array[String]): Unit = {
        // 3_1
        val x = List(1,2,3,4,5) match {
            case Cons(x, Cons(2, Cons(4, _))) => x
            case Nil => 42
            case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
            case Cons(h, t) => h + List.sum(t)
        }
        println(x)

        // 3_2
        println(List.tail(List(1,2,3,4)))
    }
}
