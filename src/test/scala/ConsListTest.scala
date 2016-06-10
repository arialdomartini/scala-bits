import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import week3._

@RunWith(classOf[JUnitRunner])
class ConsListTest extends FunSuite {
  test("Nil toString is .") {
    val sut = new Nil[Int]()
    
    assert(sut.toString === ".")
  }

  test("List of one element toString") {
    val sut = new Cons[Int](99, new Nil)
    
    assert(sut.toString === "(99 .)")
  }

  test("can append a value to Nil") {
    val sut = new Nil[Int]
    val result = sut.append(88)

    assert(result.toString === "(88 .)")
  }

  test("can append to a long list") {
    val result = new Nil[Int]().append(1).append(2).append(3)

    assert(result.toString === "(1 (2 (3 .)))")
  }

  test("being generic, TList also works with strings") {
    val result = new Nil[String]().append("a").append("b").append("c")

    assert(result.toString === "(a (b (c .)))")
  }

  test("singleton should create a list with one element terminated by a Nil") {
    val result = Factory.singleton(100)

    assert(result.toString === "(100 .)")
  }
}
