package chapter3

trait List[+A]
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

    def setHead[A](xs: List[A], head: A): List[A] = {
        xs match {
            case Nil => Nil
            case Cons(_, tail) => Cons(head, tail)
        }
    }

    def drop[A](xs: List[A], n:Int): List[A] = {
        if n == 0 then xs
        else xs match {
            case Nil => Nil
            case Cons(_, tail) => drop(tail, n-1)
        }
    }
}