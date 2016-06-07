import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ClassesTest extends FunSuite {
  test("empty does not contain anything") {
    val sut = new Empty
    
    assert(sut.contains(10) === false)
  }

  test("a not empty element contains its own value") {
    val sut = new NotEmpty(99, new Empty, new Empty)

    assert(sut.contains(99) === true)
    assert(sut.contains(42) === false)
  }

  test("a not empty element contains a value if its children contains it") {
    val left = new NotEmpty(1, new Empty, new Empty)
    val right = new NotEmpty(100, new Empty, new Empty)
    val sut = new NotEmpty(50, left, right)

    assert(sut.contains(1) === true)
    assert(sut.contains(100) === true)
  }

  test("an intset can include new intsets") {
    val sut: IntSet = new NotEmpty(100, new Empty, new Empty)

    assert(sut.contains(100) === true)
    assert(sut.contains(50) === false)

    val result = sut.include(50)

    assert(result.contains(100) === true)
    assert(result.contains(50) === true)
  }

  test("empty to string returns Empty") {
    assert(new Empty().toString === "Empty")
  }
}
