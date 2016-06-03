object HHF {
  def itself(a: Int): Int = a
  def sum(a: Int, b: Int): Int = a + b
  def product(a: Int, b: Int): Int = a * b


  def sumRange = map(sum, 0)

  def productRange = map(product, 1)

  def map(collant: (Int, Int) => Int, invariant: Int): (Int, Int) => Int = {
    def genericMap(from: Int, to: Int): Int = {
      if(from > to) invariant
      else collant(from , genericMap(from + 1, to))
    }
    genericMap
  }
}
