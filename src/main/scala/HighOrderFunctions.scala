object HighOrderFunctions {
  def cube(a: Int) = a * a * a
  
  def factorial(a: Int) = {
    def factorialAcc(a: Int, acc: Int): Int = if(a == 1) acc else factorialAcc(a - 1, a * acc)
    factorialAcc(a, 1)
  }

  def sum(list: List[Int]): Int = {
    def sumAccumulator(list: List[Int], acc: Int): Int = if(list.isEmpty) acc else sumAccumulator(list.tail, acc + list.head)
    sumAccumulator(list, 0)
  }

  def sumCubes(list: List[Int]): Int = sumF(list, a => a * a * a)

  def sumFactorials(list: List[Int]): Int = sumF(list, factorial)

  def sumF(list: List[Int], f:Int => Int): Int = {
    def sumAcc(list: List[Int], acc: Int): Int = if(list.isEmpty) acc else sumAcc(list.tail, acc + f(list.head))
    sumAcc(list, 0)
  }

  def sum(f: Int => Int, a: Int, b: Int) :Int = {
    def loop(a: Int, acc: Int): Int = {
      if(a > b) acc
      else loop(a+1, acc + f(a))
    }
    loop(a, 0)   
  }

  def sumx(f: Int => Int): (Int, Int) => Int = {
    def loop(a: Int, b: Int): Int = if(a>b) 0 else f(a) + loop(a+1, b) 
    loop
  }

  def sumCubes(a: Int, b: Int) = sumx(cube)(a, b)
  def sumFactorials(a: Int, b: Int) = sumx(factorial)(a, b)

}
