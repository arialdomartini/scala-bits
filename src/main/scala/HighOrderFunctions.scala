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

  def sumCubes(list: List[Int]): Int = {
    def sumCubesAcc(list: List[Int], acc: Int): Int = if(list.isEmpty) acc else sumCubesAcc(list.tail, acc + cube(list.head))
    sumCubesAcc(list, 0)
  }

  def sumFactorials(list: List[Int]): Int = {
    def sumCubesAcc(list: List[Int], acc: Int): Int = if(list.isEmpty) acc else sumCubesAcc(list.tail, acc + factorial(list.head))
    sumCubesAcc(list, 0)
  }
}
