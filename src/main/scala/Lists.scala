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
}
