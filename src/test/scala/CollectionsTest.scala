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
}
