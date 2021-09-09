package chapter4

sealed trait Option[+A] {
    def map[B](f:A => B): Option[B] = {
        this match {
            case None => None
            case Some(a) => Some(f(a))
        }
    }

    def flatMap[B](f: A => Option[B]): Option[B] = {
        this match {
            case None => None
            case Some(a) => f(a)
        }
    }

    def getOrElse[B >: A](default: => B): B = {
        this match {
            case None => default
            case Some(a) => a
        }
    }

    def orElse[B >: A](default: => Option[B]): Option[B] = {
        this match {
            case None => default
            case Some(a) => Some(a)
        }
    }

    def filter(f: A => Boolean): Option[A] = {
        this match {
            case Some(a) => if f(a) Some(a)
            case _ => None
        }
    }
}

case object None extends Option[Nothing]
case class Some[+A](value:A) extends Option[A]