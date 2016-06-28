import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import Collections._

@RunWith(classOf[JUnitRunner])
class CollectionsTest extends FlatSpec with Matchers with GivenWhenThen {
  it should "list all combinations of numbers x and y where x is drawn from 1..M and y is drawn from 1..N" in {
    val result = combinations(2, 2)

    result should contain theSameElementsAs Vector((1,1), (1,2), (2,1), (2,2))
  }

  it should "calculate scalar product of two vectors" in {
    Given("two vectors")
    val v1: Vector[Double] = Vector(1, 2, 3)
    val v2: Vector[Double] = Vector(4, 5, 6)

    When("scalar product is calculated")
    val result = scalarProduct(v1, v2)

    Then("the result should be the sum of the products of each pair")
    result should be (1 * 4 + 2 * 5 + 3 * 6)
  }

  it should "tell if a number is prime" in {
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    val result = numbers.map(i => (i, isPrime(i)))

    result should contain theSameElementsAs List((1, true), (2, true), (3, true), (4, false), (5, true), (6, false), (7, true), (8, false), (9, false), (10, false))
  }

  it should "calculate the combinations of pairs of numbers whose some is a prime number" in {
    val n = 6
    val m = 6

    val result = pairsWhoseSumIsPrime(n, m)

    result should contain theSameElementsAs Vector((1, 1), (2, 1), (3, 2), (4, 1), (4, 3), (5, 2), (6, 1), (6, 5))
  }

  it should "find all the solutions of the 3-queens problem" in {
    // - - -
    // - - -
    // - - -

    val n = 3
    val solutions = Set()
    val result = queens(n)

    result should contain theSameElementsAs solutions
  }
/*
  it should "find all the solutions of the 4-queens problem" in {
    // - - x -  2
    // x - - -  0
    // - - - x  3
    // - x - -  1


    val n = 4
    val solutions = Set(List(2, 0, 3, 1))
    val result = queens(n)

    result should contain theSameElementsAs solutions
  }


  it should "find all the solutions of the 5-queens problem" in {
    // x - - - -  0
    // - - x - -  2
    // - - - - x  4
    // - x - - -  1
    // - - - x -  3
    val n = 5
    val solutions = Set(List(0, 2, 4, 1, 3))
    val result = queens(n)

    result should contain theSameElementsAs solutions
  }
*/

  it should "xxxx" in {
    // x - - -  0
    // - - - -  1000
    // - - - -  1000
    // - x x -  
    // n y y n
    // 0 1 2 3

    val queens = List(0, 1000, 1000)
    isSafe(0, queens) should be (false)
    isSafe(1, queens) should be (true)
    isSafe(2, queens) should be (true)
    isSafe(3, queens) should be (false)
  }


  it should "detect when a queen is safe given the positions of the other queens in a 4 board" in {
    // - - x -  2
    // x - - -  0
    // - - - x  3
    // - x - -  1

    val queens = List(2, 0, 3)
    isSafe(0, queens) should be (false)
    isSafe(1, queens) should be (true)
    isSafe(2, queens) should be (false)
    isSafe(3, queens) should be (false)
  }

  it should "detect when a queen is safe given the positions of the other queens in a 5 board, 1st" in {
    val queens = List(2, 0, 0, 0)
    // - - x - -  2
    // x - - - -  0
    // x - - - -  0
    // x - - - -  0
    // n n n n y
    // 0 1 2 3 4

    isSafe(0, queens) should be (false)
    isSafe(1, queens) should be (false)
    isSafe(2, queens) should be (false)
    isSafe(3, queens) should be (false)
    isSafe(4, queens) should be (true)
  }

  it should "detect when a queen is safe given the positions of the other queens in a 5 board, 2nd case" in {
    val queens = List(0, 0, 1, 0)
    // x - - - -  0
    // x - - - -  0
    // - x - - -  1
    // x - - - -  0
    // n n y n n
    // 0 1 2 3 4

    isSafe(0, queens) should be (false)
    isSafe(1, queens) should be (false)
    isSafe(2, queens) should be (true)
    isSafe(3, queens) should be (false)
    isSafe(4, queens) should be (false)
  }

  it should "detect when a queen is safe given the positions of the other queens in a 5 board, 3rd case" in {
    val queens = List(2, 1, 1, 1)
    // - - x - -  2
    // - x - - -  1
    // - x - - -  1
    // - x - - -  1
    // n n n n n
    // 0 1 2 3 4

    isSafe(0, queens) should be (false)
    isSafe(1, queens) should be (false)
    isSafe(2, queens) should be (false)
    isSafe(3, queens) should be (false)
    isSafe(4, queens) should be (false)
  }

  it should "detect when a queen is safe given the positions of the other queens in a 3 board" in {
    val queens = List(1, 0)
    // - x -  1
    // x - -  0
    // - - x  
    // n n y
    // 0 1 2

    isSafe(0, queens) should be (false)
    isSafe(1, queens) should be (false)
    isSafe(2, queens) should be (true)

  }

  it should "invert a map" in {
    var map = Map('1' -> "abc", '2' -> "def")

    var result = invertMap(map)

    assert(result === Map(
                          'a' -> '1', 'b' -> '1', 'c' -> '1', 
                          'd' -> '2', 'e' -> '2', 'f' -> '2'))
  }

  it should "convert a word in T9" in {
    var map = Map('2' -> "abc", '3' -> "def", '4' -> "ghi", '5' -> "jkl", '6' -> "mno", '7' -> "pqrs", '8' -> "tuv", '9' -> "wxyz")

    val result = t9(map, "arialdo")

    result should be ("2742536")
  }
}
