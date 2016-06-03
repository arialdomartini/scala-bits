object HHF {
  def itself(a: Int): Int = a
  def sum(a: Int, b: Int): Int = a + b
  def product(a: Int, b: Int): Int = a * b


  def sumRange = map(sum, 0) _

  def productRange = map(product, 1) _

  def map(collant: (Int, Int) => Int, invariant: Int)(from: Int, to: Int): Int = {
    if(from > to) invariant
    else collant(from , map(collant, invariant)(from + 1, to))
  }
}
