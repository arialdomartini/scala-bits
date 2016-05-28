object Factorial {
  def calculate(n: Int): Int = {
    def calculate(n: Int, acc: Int): Int = if(n == 1) acc else calculate(n - 1, acc * n)
    calculate(n, 1)
  }
}
