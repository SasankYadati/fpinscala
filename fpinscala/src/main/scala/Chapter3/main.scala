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
        println("\n")

        // 3_9
        println("Length of list using foldRight")
        val len = List.len(List(1,2,3))
        println(len)
        println("\n")

        // 3_10 and 3_11
        println("Sum, product and length using foldleft")
        val l = List(1,3,5,10)
        val sum = List.foldLeft(l, 0)((x,y) => x + y)
        val product = List.foldLeft(l, 1.0)((x, y) => x * y)
        val length = List.foldLeft(l, 0)((_, y) => 1 + y)
        println(sum)
        println(product)
        println(length)
        println("\n")

        // 3_12
        println("Reverse a list using fold")
        println(List.reverse(l))
        println("\n")

        // 3_14
        println("Append a list using fold")
        val a = List(1,3,5,10)
        val b = List(2,4,6)
        val newl = List.append(a, b)
        println(newl)
        println("\n")

        // 3_16
        println("Add one to each item in list")
        val add1 = List.addX(a, 1)
        println(a)
        println(add1)
        println("\n")

        // 3_18
        println("Add 5 using map to each item in list")
        val add5 = List.map(a)(a => a+5)
        println(a)
        println(add5)
        println("\n")
    }
}
