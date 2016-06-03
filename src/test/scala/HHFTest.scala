import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import HHF._

@RunWith(classOf[JUnitRunner])
class HHFTest extends FunSuite {
  test("itself should return the provided number") {
    assert(itself(10) == 10)
  }

  test("should calculate sum of numbers in a range") {
    assert(sumRange(1, 5) == 1 + 2 + 3 + 4 + 5)
  }

  test("should calculate product of numbers in a range") {
    assert(productRange(1, 5) == 1 * 2 * 3 * 4 * 5)
  }
}
