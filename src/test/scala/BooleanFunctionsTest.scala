import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class BooleaneanFunctionsTest extends FunSuite {
  test("and() works just like &&") {
    assert(BooleanFunctions.and(true, true) == true)
    assert(BooleanFunctions.and(true, false) == false)
    assert(BooleanFunctions.and(false, true) == false)
    assert(BooleanFunctions.and(false, false) == false)
  }

  test("or() works just like ||") {
    assert(BooleanFunctions.or(true, true) == true)
    assert(BooleanFunctions.or(true, false) == true)
    assert(BooleanFunctions.or(false, true) == true)
    assert(BooleanFunctions.or(false, false) == false)
  }
}
