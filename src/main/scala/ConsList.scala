package week3

trait List[T] {
  def append(head: T): List[T]
}

class Nil[T] extends List[T] {
  override def append(value: T): List[T] = {
    new Cons(value, new Nil)
  }
  override def toString = "."
}

class Cons[T](head: T, tail: List[T]) extends List[T] {
  override def append(value: T): List[T] = {
    new Cons(head, tail.append(value))
  }
  override def toString = {
    s"($head ${tail.toString})"
  }
}

