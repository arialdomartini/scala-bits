import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class HighOrderFunctionsTest extends FunSuite {
  test("should calculate qubes") {
    assert(HighOrderFunctions.cube(0) == 0)
    assert(HighOrderFunctions.cube(1) == 1)
    assert(HighOrderFunctions.cube(2) == 8)
    assert(HighOrderFunctions.cube(3) == 27)
    assert(HighOrderFunctions.cube(4) == 64)
  }

  test("should calculate factorial") {
    assert(HighOrderFunctions.factorial(1) == 1)
    assert(HighOrderFunctions.factorial(2) == 2)
    assert(HighOrderFunctions.factorial(3) == 6)
    assert(HighOrderFunctions.factorial(4) == 24)
    assert(HighOrderFunctions.factorial(5) == 120)
  }

  test("should sum numbers in a list") {
    val expected = 15
    assert(HighOrderFunctions.sum(List(1, 2, 3, 4, 5)) == expected)
  }

  test("should sum cubes of numbers in a list") {
    val expected = 1 + 2*2*2 + 3*3*3 + 4*4*4
    assert(HighOrderFunctions.sumCubes(List(1, 2, 3, 4)) == expected)
  }

  test("should sum factorials of numbers in a list") {
    val expected = 1 + 2 + 6 + 24
    assert(HighOrderFunctions.sumFactorials(List(1, 2, 3, 4)) == expected)
  }

  test("should sum cubes using tail recursive call") {
    assert(HighOrderFunctions.sum( x => x*x*x, 1, 4) == 1 + 2*2*2 + 3*3*3 + 4*4*4)
  }

  test("should sum cubes of numbers given range extreems") {
    val expected = 1 + 2*2*2 + 3*3*3 + 4*4*4
    assert(HighOrderFunctions.sumCubes(1, 4) == expected)
  }

  test("should sum factorials of numbers given range extreems") {
    val expected = 1 + 2 + 6 + 24
    assert(HighOrderFunctions.sumFactorials(1, 4) == expected)
  }  
}
