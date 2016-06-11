package week3

trait List[T] {
  def append(head: T): List[T]
  def select[T](index: Int): T
}

class Nil[T] extends List[T] {
  override def append(value: T): List[T] = {
    new Cons(value, new Nil)
  }
  override def toString = "."
  override def select[T](index: Int) = ???
}

class Cons[T](head: T, tail: List[T]) extends List[T] {
  override def append(value: T): List[T] = {
    new Cons(head, tail.append(value))
  }
  override def toString = {
    s"($head ${tail.toString})"
  }
  override def select[T](index: Int): T = {
    if(index == 0) head.asInstanceOf[T] else tail.select(index - 1)
  }
}

object Factory {
  def singleton[T](value: T) = new Cons[T](value, new Nil[T])
}
