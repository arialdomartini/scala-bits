object BooleanFunctions {
  def and(a: Boolean, b: => Boolean): Boolean = if(a) b else false
  def or(a: Boolean, b: => Boolean): Boolean = if(a) true else b  
}

object Main {
  def callByValue(i: Int, b: Int) = i
  def callByName(i: Int, b: => Int) = i
  def loop() : Int = loop()

  def abs(i: Int) = if ( i >= 0) i else -i

  def main(args: Array[String]): Unit = {
    // callByNameAndCallByValue()
    println("abs(-12)==" + abs(12))
  }

  def callByNameAndCallByValue() = {
    println("Evaluating by name or by value")

    println("Call by name: ")
    println( callByName(99, loop()))

    println("Call by value (won't terminate): ")
    println( callByValue(99, loop()))
  }
}
