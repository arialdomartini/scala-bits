package week3

abstract class IntList {
  def append(head: Int): IntList
}

class Nil extends IntList {
  override def append(value: Int): IntList = {
    new Cons(value, new Nil)
  }
  override def toString = "."
}

class Cons(head: Int, tail: IntList) extends IntList {
  override def append(value: Int): IntList = {
    new Cons(head, tail.append(value))
  }
  override def toString = {
    s"($head ${tail.toString})"
  }
}

