object HHF {
  def itself(n: Int): Int = n
  def double(n: Int) = 2 * n
  def sum(a: Int, b: Int): Int = a + b
  def product(a: Int, b: Int): Int = a * b


  def sumRange = map(sum, 0, itself) _

  def productRange = map(product, 1, itself) _

  def sumDoublesRange = map(sum, 0, double) _

  def map(collant: (Int, Int) => Int, invariant: Int, f: Int => Int)(from: Int, to: Int): Int = {
    if(from > to) invariant
    else collant(f(from) , map(collant, invariant, f)(from + 1, to))
  }
}
