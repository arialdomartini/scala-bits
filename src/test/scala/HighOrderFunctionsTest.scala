import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import HighOrderFunctions._

@RunWith(classOf[JUnitRunner])
class HighOrderFunctionsTest extends FunSuite {
  test("should calculate qubes") {
    assert(cube(0) == 0)
    assert(cube(1) == 1)
    assert(cube(2) == 8)
    assert(cube(3) == 27)
    assert(cube(4) == 64)
  }

  test("should calculate factorial") {
    assert(factorial(1) == 1)
    assert(factorial(2) == 2)
    assert(factorial(3) == 6)
    assert(factorial(4) == 24)
    assert(factorial(5) == 120)
  }

  test("should sum numbers in a list") {
    val expected = 15
    assert(sum(List(1, 2, 3, 4, 5)) == expected)
  }

  test("should sum cubes of numbers in a list") {
    val expected = 1 + 2*2*2 + 3*3*3 + 4*4*4
    assert(sumCubes(List(1, 2, 3, 4)) == expected)
  }

  test("should sum factorials of numbers in a list") {
    val expected = 1 + 2 + 6 + 24
    assert(sumFactorials(List(1, 2, 3, 4)) == expected)
  }

  test("should sum cubes using tail recursive call") {
    assert(sum( x => x*x*x, 1, 4) == 1 + 2*2*2 + 3*3*3 + 4*4*4)
  }

  test("should sum cubes of numbers given range extreems") {
    val expected = 1 + 2*2*2 + 3*3*3 + 4*4*4
    assert(sumCubes(1, 4) == expected)
  }

  test("should sum factorials of numbers given range extreems") {
    val expected = 1 + 2 + 6 + 24
    assert(sumFactorials(1, 4) == expected)
  }

  test("function itself returns the number itself") {
    assert(itself(100) == 100)
  }

  test("high order function that calculates products can apply to function itself") {
    assert(product(itself)(1, 4) == 1 * 2 * 3 * 4)
  }

}
