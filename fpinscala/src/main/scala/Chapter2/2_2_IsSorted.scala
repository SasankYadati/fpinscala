object Sorted {
    def IsSorted[A](arr: Array[A], ordered: (A, A) => Boolean): Boolean = {
        @annotation.tailrec
        def loop(n: Int): Boolean = {
            if (n == arr.length-1) true
            else if (!ordered(arr(n), arr(n+1))) false
            else loop(n+1)
        }
        loop(0)
    }

    def compareIntegers(a: Int, b: Int): Boolean = {
        a <= b
    }

    def main(args: Array[String]): Unit = {
        println(IsSorted(Array(1, 2, 3), compareIntegers))
        println(IsSorted(Array(1, 2, 3, 2), compareIntegers))
    }
}