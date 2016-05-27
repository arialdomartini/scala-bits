object SquareRoot {
  def calculate(x: Double): Double = calculate(1.0, x)

  def calculate(guess: Double, x: Double): Double = 
    if(isGoodEnough(guess, x)) guess
    else calculate(improve(guess, x), x)

 def isGoodEnough(guess: Double, x: Double) = Math.abs(guess * guess - x)/x < 0.001
 def improve(guess: Double, x: Double) = (guess + x/guess) /2
}

