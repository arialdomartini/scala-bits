import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import week3._

@RunWith(classOf[JUnitRunner])
class ConsListTest extends FunSuite {
  test("Nil toString is .") {
    val sut = new Nil
    
    assert(sut.toString === ".")
  }

  test("List of one element toString") {
    val sut = new Cons(99, new Nil)
    
    assert(sut.toString === "(99 .)")
  }

  test("can append a value to Nil") {
    val sut = new Nil
    val result = sut.append(88)

    assert(result.toString === "(88 .)")
  }

  test("can append to a long list") {
    val result = new Nil().append(1).append(2).append(3)

    assert(result.toString === "(1 (2 (3 .)))")
  }
}
