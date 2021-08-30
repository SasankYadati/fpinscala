object Composition {
    def compose[A,B,C](f: B => C, g: A => B): A => C = {
        a => f(g(a))
    }

    def double(a: Int): Int = {
        a*2
    }

    def halve(a: Int): Int = {
        a/2
    }

    def main(args: Array[String]): Unit = {
        println(compose(halve, double)(5))
    }
}