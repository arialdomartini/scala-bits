object Lists {
  def last[T](list: List[T]): T = list match {
    case List() => throw new Exception()
    case x :: List() => x
    case x :: xs => last(xs)
  }

  def init[T](list: List[T]): List[T] = list match {
    case List() => list
    case x :: List() => List()
    case x :: xs => x :: init(xs)
  }

  def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case List() => ys
    case x :: xs => x :: concat(xs, ys)
  }

  def reverse[T](xs: List[T]): List[T] = xs match {
    case List() => xs
    case x :: xs => concat(reverse(xs), List(x)) 
  }

  def removeAt[T](position: Int, list: List[T]): List[T] = list.take(position) ::: list.drop(position + 1)

  def msort[T](list: List[T])(implicit ord: Ordering[T]): List[T] = list match {
    case List() => list
    case x :: List() => List(x)
    case _ => {

      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (List(), ys) => ys
        case (xs, List()) => xs
        case (x :: xtail, y :: ytail) => if (ord.lt(x, y)) x :: merge(xtail, ys) else y :: merge(xs, ytail)
      }

      val (left, right) = list.splitAt(list.length / 2)
      merge(msort(left)(ord), msort(right)(ord))
    }
  }

  def scale(list: List[Int], factor: Int): List[Int] = list match {
    case List() => list
    case x :: tail => x * factor :: scale(tail, factor)
  }

  def scaleWithMap(list: List[Int], factor: Int => Int) = list.map(factor)

  def posElems(list: List[Int]): List[Int] = filter[Int](list, x => x > 0)

  def map[T](list: List[T], p: T => T): List[T] = list match {
    case List() => list
    case x :: tail => p(x) :: map(tail, p)
  }

  def filter[T](list: List[T], predicate: T => Boolean): List[T] = list match {
    case List() => list
    case x :: tail => if(predicate(x)) x :: filter(tail, predicate) else filter(tail, predicate)
  }

  def filterNot[T](list: List[T], predicate: T => Boolean): List[T] = filter[T](list, x => ! predicate(x))

  def partition[T](list: List[T], predicate: T => Boolean): (List[T], List[T]) = (filter(list, predicate), filterNot(list, predicate))

  def takeWhile[T](list: List[T], predicate: T => Boolean): List[T] = list match {
    case List() => list
    case head :: tail => if(predicate(head)) head :: takeWhile[T](tail, predicate) else List()
  }

  def dropWhile[T](list: List[T], predicate: T => Boolean): List[T] = list match {
    case List() => list
    case head :: tail => if(predicate(head)) dropWhile(tail, predicate) else list
  }

  def span[T](list: List[T], predicate: T => Boolean): (List[T], List[T]) = (takeWhile[T](list, predicate), dropWhile[T](list, predicate))

  def pack[T](list: List[T]): List[List[T]] = list match {
    case List() => List()
    case head :: tail => 
      val (firsts, rest) = list.span(x => x == head)
      firsts :: pack[T](rest)
  }

  def foldLeft[T, U](list: List[T], acc: U)(fun: (U, T) => U): U = list match { 
    case List() => acc
    case head :: tail => foldLeft(list.tail, fun(acc, list.head))(fun)
  }

  def foldRight[T, U](list: List[T], acc: U)(fun: (T, U) => U): U = list match {
    case List() => acc
    case head :: tail => fun(head , foldRight(list.tail, acc)(fun))
  }
}
