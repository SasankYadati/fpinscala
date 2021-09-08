package chapter3

sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](left: Tree[A], value:A, right: Tree[A]) extends Tree[A]

object Tree {
    def size[A](tree: Tree[A]): Int = {
        tree match {
            case Leaf(x) => 1
            case Branch(left, x, right) => 1 + size(left) + size(right)
        }
    }
    
    def max(tree: Tree[Int]): Int = {
        tree match {
            case Leaf(x) => x
            case Branch(l, x, r) => max(l) max max(r)
        }
    }
}