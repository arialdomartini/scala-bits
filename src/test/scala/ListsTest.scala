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

  test("should remove an item in a list, given its position") {
    val list = List("a", "b", "c", "d", "e")

    val result = removeAt(3, list)

    assert(result === List("a", "b", "c", "e"))
  }

  test("should sort a list with merge sort") {
    val list = List(2, -4, -5, 3, 1, 0, 5, 5)

    val result = msort(list)

    assert(result === List(-5, -4, 0, 1, 2, 3, 5, 5))
  }

  test("scale multiplies each element of a list for the same factor") {
    val list = List(1, 2, 3)

    val result = scale(list, 3)

    assert(result === List(3, 6, 9))
  }

  test("scale can be implemented in terms of List.map") {
    val list = List(1, 2, 3)

    assert(scale(list, 3) === scaleWithMap(list, _ * 3))
  }

  test("should extract positive numbers from a list") {
    val list = List(1, -4, 5, -2, 0, 6, 8, 1)

    val result = posElems(list)

    assert(result === List(1, 5, 6, 8, 1))
  }

  test("map applies a function to each element of a list") {
    val list = List(1, -4, 5, -2, 0, 6, 8, 1)

    val result = map[Int](list, _ * 2)

    assert(result == List(2, -8, 10, -4, 0, 12, 16, 2))
  }

  test("calculates the square of items in a list") {
    val list = List(1, 2, 3)

    val result = map[Int](list, x => x * x)

    assert(result == List(1, 4, 9))
  }

  test("filter filters list items based on a predicate") {
    val list = List(1, -4, 5, -2, 0, 6, 8, 1)

    val result = filter[Int](list, x => x > 0)

    assert(result == List(1, 5, 6, 8, 1))
  }

  test("filterNot filters list items based on a predicate") {
    val list = List(1, -4, 5, -2, 0, 6, 8, 1)

    val result = filterNot[Int](list, x => x > 0)

    assert(result == List(-4, -2, 0))
  }

  test("partition separates items that satisfy a predicate from items that don't") {
    val list = List(1, -4, 5, -2, 0, 6, 8, 1)

    val result = partition[Int](list, x => x > 0)

    assert(result === (List(1, 5, 6, 8, 1), List(-4, -2, 0)))
  }

  test("takeWhile takes the elements in a list up to the one that does not satidfy a predicate") {
    val list = List(-1, -5, 4, -2, 0, 6, 8, 1)

    val result = takeWhile[Int](list, _ < 0)

    assert(result === List(-1, -5))
  }
}
