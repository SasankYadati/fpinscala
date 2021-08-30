package chapter3

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head:A, tail:List[A]) extends List[A]

object List {
    def sum(ints:List[Int]): Int = {
        ints match {
            case Nil => 0
            case Cons(x, xs) => x + sum(xs)
        }
    }

    def apply[A](as: A*): List[A] = {
        if (as.isEmpty) Nil
        else Cons(as.head, apply(as.tail:_*))
    }

    def tail[A](xs: List[A]): List[A] = {
        xs match {
            case Nil => Nil
            case Cons(y, ys) => ys
        }
    }
}