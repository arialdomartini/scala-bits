import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import Lists._

@RunWith(classOf[JUnitRunner])
class ListsTest extends FunSuite {
  test("should find the last element of a list") {
    val list = List(1, 2, 3)

    val result = last(list)

    assert(result === 3)
  }
}
