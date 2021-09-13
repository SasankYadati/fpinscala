import chapter4._

object c4 {
    def main(args:Array[String]): Unit = {
        // 4_1 and 4_2
        println("Variance of  elements in seq using flatMap")
        def mean(xs: Seq[Double]): Option[Double] = {
            if (xs.isEmpty) None
            else Some(xs.sum/xs.length)
        }

        def variance(xs: Seq[Double]): Option[Double] = {
            val m: Option[Double] = mean(xs)
            m.flatMap((a) => mean(xs.map(x => math.pow(x-a, 2))))

        }

        val l = Seq(1.0, 2.0, 3.0)
        println(variance(l))
        println("\n")

        // 4_4
        val sq = List(Some(1), Some(2), Some(3))
        println(Option.sequence(sq))
        println("\n")
    }
}