object Uncurry {
    def curry[A, B, C](f: (A, B) => C): A => (B => C) = {
        a => b => f(a, b)
    }

    def add(a: Int, b: Int): Int = {
        a+b
    }

    def uncurry[A, B, C](f: A => B => C): (A, B) => C = {
        (a, b) => f(a)(b)
    }

    def main(args: Array[String]): Unit = {
        val add_curried = curry(add)
        val add_ = uncurry(add_curried)
        println(add_(5,2))
    }
}