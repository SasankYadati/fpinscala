package chapter2
object Uncurry {
    def uncurry[A, B, C](f: A => B => C): (A, B) => C = {
        (a, b) => f(a)(b)
    }
}