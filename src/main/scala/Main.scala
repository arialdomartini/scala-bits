object Main {
  def callByValue(i: Int, b: Int) = i
  def callByName(i: Int, b: => Int) = i
  def loop() : Int = loop()

  def main(args: Array[String]): Unit = {
    println("Evaluating by name or by value")

    println("Call by name: ")
    println( callByName(99, loop()))

    println("Call by value (won't terminate): ")
    println( callByValue(99, loop()))
    
  }
}