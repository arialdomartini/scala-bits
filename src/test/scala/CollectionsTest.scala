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
}
