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

  test("should find the first elements of a list, excluding the last one") {
    val list = List("one", "two", "three", "four")

    val result = init(list)

    assert(result === List("one", "two", "three"))
  }

  test("should concatenate two lists") {
    val list1 = List(1, 2, 3, 4)
    val list2 = List(5, 6, 7, 8)

    val result = concat(list1, list2)

    assert(result === List(1, 2, 3, 4, 5, 6, 7, 8))
  }

  test("should reverse a list") {
    val list = List(1, 2, 3, 4, 5)

    val result = reverse(list)

    assert(result === List(5, 4, 3, 2, 1))
  }
}
