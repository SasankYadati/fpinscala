package chapter2
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
}