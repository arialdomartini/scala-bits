import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class SquareRootTest extends FunSuite {
  test("should pass") {
    val squareOfTwo = 1.414

    val result = SquareRoot.calculate(2)
    assert(Math.abs(result - squareOfTwo) < 0.01)
  }
}
