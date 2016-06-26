import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import Collections._

@RunWith(classOf[JUnitRunner])
class CollectionsTest extends FlatSpec with Matchers {
  it should "list all combinations of numbers x and y where x is drawn from 1..M and y is drawn from 1..N" in {
    val result = combinations(2, 2)

    result should contain theSameElementsAs Vector((1,1), (1,2), (2,1), (2,2))
  }
}
