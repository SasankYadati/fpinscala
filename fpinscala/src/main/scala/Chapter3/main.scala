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
        println("\n")

        // 3_2
        println(List.tail(List(1,2,3,4)))
        println("\n")

        // 3_3
        println(List.setHead(List(1,2,3,4), 100))
        println("\n")

        // 3_4
        println(List.drop(List(1,2,3,4,5,6,7), 5))
        println("\n")

        // 3_5
        def lessThanFive(a: Int): Boolean = {
            if a < 5 then true
            else false
        }
        println(List.dropWhile(List(1,2,3,4,5,6,7))(x => x < 5))
        println("\n")

        // 3_6
        println(List.dropTail(List(1,2,3,4,5)))

        // 3_9
        println("Length of list using foldRight")
        val len = List.len(List(1,2,3))
        println(len)
        println("\n")
    }
}
