object Lists {
  def last[T](list: List[T]): T = list match {
      case List() => throw new Exception()
    case x :: List() => x
    case x :: xs => last(xs)
  }
}
