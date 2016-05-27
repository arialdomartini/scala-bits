object SquareRoot {
  def calculate(x: Double): Double = 
  {
    def calculateIter(guess: Double): Double = 
      if(isGoodEnough(guess)) guess
      else calculateIter(improve(guess))

    def isGoodEnough(guess: Double) = Math.abs(guess * guess - x)/x < 0.001
    def improve(guess: Double) = (guess + x/guess) /2

    calculateIter(1.0)
  }

}

