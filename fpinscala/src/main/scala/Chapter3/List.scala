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

    def product(ds: List[Double]): Double = {
        ds match {
            case Nil => 1
            case Cons(0.0, _) => 0.0
            case Cons(d, ds) => d * product(ds)
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
    
    @annotation.tailrec
    def drop[A](xs: List[A], n:Int): List[A] = {
        if n == 0 then xs
        else xs match {
            case Nil => Nil
            case Cons(_, tail) => drop(tail, n-1)
        }
    }

    // curried
    def dropWhile[A](l: List[A])(f:A => Boolean): List[A] = {
        l match {
            case Nil => Nil
            case Cons(x, xs) => if f(x) then dropWhile(xs)(f) else l
        }
    }

    def dropTail[A](xs: List[A]): List[A] = {
        import collection.mutable.ListBuffer
        val buffer = new ListBuffer[A]
        
        @annotation.tailrec
        def dropTailGo(l: List[A]): List[A] = {
            l match {
                case Nil => sys.error("dropTail of Nil")
                case Cons(_, Nil) => List(buffer.toList:_*)
                case Cons(h, t) => {
                    buffer += h
                    dropTailGo(t)
                }
            }
        }
        dropTailGo(xs)
    }

    def foldRight[A, B](l: List[A], acc: B)(f: (A, B) => B): B = {
        l match {
            case Nil => acc
            case Cons(h, t) => f(h, foldRight(t, acc)(f))
        }
    }

    def len[A](l: List[A]): Int = {
        foldRight(l, 0)((_, y) => 1 + y)
    }
}