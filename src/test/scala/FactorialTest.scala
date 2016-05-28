import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class FactorialTest extends FunSuite {
  test("should calculate factorial") {
    val factorialOf10 = 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10

    val result = Factorial.calculate(10)

    assert(result == factorialOf10)
  }
}
