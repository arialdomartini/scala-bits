object HHF {
  def itself: Int => Int = x => x
  def double(n: Int) = 2 * n

  def sumRange = map((a, b) => a + b, 0, itself) _

  def productRange = map((a, b) => a * b, 1, itself) _

  def sumDoublesRange = map((a, b) => a + b, 0, double) _

  def map(combine: (Int, Int) => Int, invariant: Int, f: Int => Int)(from: Int, to: Int): Int = {
    if(from > to) invariant
    else combine(f(from) , map(combine, invariant, f)(from + 1, to))
  }
}
