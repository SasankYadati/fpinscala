import chapter2._

object c2 {

    def main(args: Array[String]): Unit = {
        // 2_1
        println(Fibonacci.fib(5))

        // 2_2
        println(Sorted.IsSorted(Array(1, 2, 3), Sorted.compareIntegers))
        println(Sorted.IsSorted(Array(1, 2, 3, 2), Sorted.compareIntegers))

        // 2_3
        println(Curry.curry(Curry.add)(2)(3))

        // 2_4
        val add_curried = Curry.curry(Curry.add)
        val add_ = Uncurry.uncurry(add_curried)
        println(add_(5,2))

        // 2_5
        println(Composition.compose(Composition.halve, Composition.double)(5))
    }
}