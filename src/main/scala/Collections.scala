object Collections {
  def combinations(m: Int, n: Int): scala.collection.immutable.IndexedSeq[(Int, Int)] = {
    (1 to m).flatMap(x => (1 to n).map(y => (x, y)))
  }

  def scalarProduct(v1: Vector[Double], v2: Vector[Double]): Double = (v1 zip v2).map{ case (x, y) => x * y }.sum

  def isPrime(n: Int): Boolean = (2 until n).forall(i => n % i != 0)

  def pairsWhoseSumIsPrime(n: Int, m: Int) = {
    val pairs = for {
      i <- 1 to n
      j <- 1 to i
    } yield (i, j)
      pairs.filter( pair => isPrime(pair._1 + pair._2))
  }
}
