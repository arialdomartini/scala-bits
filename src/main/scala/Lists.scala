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

  def partition[T](list: List[T], predicate: T => Boolean): (List[T], List[T]) = {
   def partitionAcc(remaining: List[T], satisfying: List[T], notSatisfying: List[T]): (List[T], List[T]) = remaining  match {
      case List() => (satisfying, notSatisfying)
      case x :: tail => if(predicate(x)) partitionAcc(remaining.tail, satisfying :+ x, notSatisfying)
                        else partitionAcc(remaining.tail, satisfying, notSatisfying :+ x)
   }
    partitionAcc(list, List(), List())
  }
}
