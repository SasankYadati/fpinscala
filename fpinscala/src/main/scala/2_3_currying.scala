object Curry {
    def curry[A, B, C](f: (A, B) => C): A => (B => C) = {
        a => b => f(a, b)
    }

    def add(a: Int, b: Int): Int = {
        a+b
    }

    def main(args: Array[String]): Unit = {
        println(curry(add)(2)(3))
    }
}
