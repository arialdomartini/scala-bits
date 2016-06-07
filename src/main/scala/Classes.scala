abstract class IntSet {
  def contains(elem: Int): Boolean
  def include(elem: Int): IntSet
}

class Empty extends IntSet {
  def contains(elem: Int): Boolean = false
  def include(elem: Int): IntSet = new NotEmpty(elem, new Empty, new Empty)
  override def toString = "Empty"
}

class NotEmpty(value: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(elem: Int): Boolean = {
    if(elem < value) left.contains(elem)
    else if(elem > value) right.contains(elem)
    else true
  }
  def include(elem: Int): IntSet = {
    if(elem < value) new NotEmpty(value, left include elem, right)
    else if(elem > value) new NotEmpty(value, left, right include elem)
    else this
  }
  override def toString() = {
    val sleft = left.toString
    val sright = right.toString
    
    s"($value $sleft $sright)"
  }
}
