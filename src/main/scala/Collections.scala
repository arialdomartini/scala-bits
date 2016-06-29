object Collections {
  def combinations(m: Int, n: Int): scala.collection.immutable.IndexedSeq[(Int, Int)] = {
    (1 to m).flatMap(x => (1 to n).map(y => (x, y)))
  }

  def oldscalarProduct(v1: Vector[Double], v2: Vector[Double]): Double = (v1 zip v2).map{ case (x, y) => x * y }.sum
  def scalarProduct(v1: Vector[Double], v2: Vector[Double]): Double = {
    val products = for ( (i, j) <- v1 zip v2 ) yield i * j
    products.sum
  }

  def isPrime(n: Int): Boolean = (2 until n).forall(i => n % i != 0)

  def pairsWhoseSumIsPrime(n: Int, m: Int) =
    for {
      i <- 1 to n
      j <- 1 to i
      if(isPrime(i+j))
    } yield (i, j)

  def queens(n: Int): Set[List[Int]] = {
    def placeQueens(k: Int): Set[List[Int]] = {
      if(k == 0) Set(List())
      else
        for {
        queens <- placeQueens(k-1)
        column <- 0 until n
        if(isSafe(column, queens))
      } yield queens ++ List(column) 
    }
    placeQueens(n)
  }

  def isSafe(column: Int, queens: List[Int]): Boolean = queens match {
    case List() => true
    case head :: tail => (column != head && column != (head - (queens.length)) && column != (head + (queens.length)) && isSafe(column, tail))
  }

  def invertChar(char: Char) = {
    val r = invertChars
    r.get(char)
  }
  
  def invertChars: Map[Char, Char] = invertMap(this.map)

  def invertMap(map: Map[Char, String]): Map[Char, Char] = {
    for {
      (digit, string) <- map
      char <- string
    } yield char -> digit
  }

  var map = Map('2' -> "abc", '3' -> "def", '4' -> "ghi", '5' -> "jkl", '6' -> "mno", '7' -> "pqrs", '8' -> "tuv", '9' -> "wxyz")

  def t9(s: String): String = {
    s map invertChars
  }
}
