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
}
