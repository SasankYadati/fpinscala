object Fibonacci {
    def fib(n: Int): Int = {
        @annotation.tailrec
        def go(n: Int, prev: Int, curr: Int) : Int = {
            if (n == 1) prev
            else go(n-1, curr, prev+curr)
        }
        go(n, 0, 1)
    }

    def main(args: Array[String]): Unit = {
        println(fib(5))
    }
}