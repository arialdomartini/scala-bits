object Collections {
  def combinations(m: Int, n: Int): scala.collection.immutable.IndexedSeq[(Int, Int)] = {
    (1 to m).flatMap(x => (1 to n).map(y => (x, y)))
  }

  def scalarProduct(v1: Vector[Double], v2: Vector[Double]): Double = (v1 zip v2).map{ case (x, y) => x * y }.sum

  def isPrime(n: Int): Boolean = (2 until n).forall(i => n % i != 0)

  def pairsWhoseSumIsPrime(n: Int, m: Int) = {
    (1 to n).map( i => (1 to i).map( j => (i, j) ) ).
      flatten.
      filter( pair => isPrime(pair._1 + pair._2))
  }
}
